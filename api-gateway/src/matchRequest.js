const rules = require('./rules')

exports.matchRequest = async (ctx, next) => {
  const match = matchUrl(ctx.request.url, ctx.method)
  if(!match) {
    ctx.throw(404)
  }
  ctx.match = match
  next()
}

function matchUrl(url, method) {
  const rule = Object.keys(rules).filter(rule => url.match(rule))
  return rule.length == 1 ? matchMethod(rules[rule[0]], method) : null
}

function matchMethod(methods, _method) {
  const key = Object.keys(methods).filter(method => method === _method)
  return methods[_method]
}
