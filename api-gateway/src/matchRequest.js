const rules = require('./rules')

exports.matchRequest = async (ctx, next) => {
  const match = matchUrl(ctx.request.url, ctx.method)
  if(!match) {
    console.log("404")
    ctx.throw(404)
  }
  ctx.match = match
  await next()
}

function matchUrl(url, method) {
  //const rule = Object.keys(rules).filter(rule => url.match(rule))
  rule = rules[url]
  return rule ? matchMethod(rule, method) : null
}

function matchMethod(methods, _method) {
  const key = Object.keys(methods).filter(method => method === _method)
  return methods[_method]
}
