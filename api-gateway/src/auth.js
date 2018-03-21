const fetch = require('node-fetch')

exports.auth = async (ctx, next) => {
  const mach = ctx.match
  if (match.permissions == "*") {
    next()
  }

}
