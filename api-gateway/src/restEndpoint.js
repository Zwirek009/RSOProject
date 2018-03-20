exports.restEndpoint = function (middleware) {
  return async function (ctx, next) {
    try {
      const response = await middleware(ctx)
      ctx.type = 'application/json'
      ctx.body = JSON.stringify(response)
    } catch (e) {
      ctx.throw(e.httpCode || 500, e.message)
    }
  }
}
