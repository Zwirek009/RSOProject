const fetch = require('node-fetch')
const { hosts } = require('./properties')

const authHost = hosts.auth

const AUTH_URL = `http://${authHost}:8081/users/current`

exports.auth = async (ctx, next) => {
  const match = ctx.match
  if (match.permissions == "*") {
    ctx.headers.userId = ""
    next()
  }
  const res = await checkAuth(ctx)
  ctx.headers.userId = res.id
  ctx.body = "XDDD"
  next()
}

checkAuth = async (ctx) => {
  const res = await fetch(AUTH_URL, {
    method: "GET",
    headers: {cookie: ctx.headers.cookie}
  }).then(res => res.json()).catch((error) => null)
  if (!res) {
    ctx.throw(500)
  }
  if (res.status == 401) {
    console.log("unauth")
    ctx.throw(401, 'Unauthorized')
  }
  return res
}
