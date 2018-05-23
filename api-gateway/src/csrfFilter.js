exports.csrfFilter = async (ctx, next) => {
    console.log(ctx.request)
    if (ctx.headers["x-requested-with"]) {
        await next()
    } else {
        ctx.throw(403, 'CSRF validation failed.')
    }
}