const rules = require('./rules')

exports.matchRequest = async (ctx, next) => {
  const match = matchRule(ctx.request.url, ctx.method)
  console.log(match)
  if (!match) {
    ctx.throw(404)
  }
  ctx.match = match
  await next()
}

function matchRule(url, method) {
  const rule = rules[url]
  return rule ? rule[method] : matchRegexRule(url, method)
}

function matchRegexRule(url, method) {
  if (!url) {
    return null
  }
  const matchedRule = Object.keys(rules).filter(rule => matchRegexUrl(url, rule))
  if(matchedRule.length != 1) {
    return null
  }
  const rule = rules[matchedRule][method]
  return rule ? prepareRule(url, rule) : null
}

function matchRegexUrl(url, rule) {
  const matchedRule = url.match(rule)
  return matchedRule ? url.length == matchedRule[0].length : false
}

function prepareRule(url, rule) {
  return {
    permissions: rule.permissions,
    service: rule.service,
    endpoint: url.match(rule.endpoint)[0],
    method: rule.method
  }
}
