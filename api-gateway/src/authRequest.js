const fetch = require('node-fetch')
const { hosts } = require('./properties')

const authHost = hosts.auth

const AUTH_URL = `http://${authHost}/users/current`

exports.authRequest = async (ctx, next) => {
  const match = ctx.match
  if (match.permissions == "*") {
    ctx.headers.userId = ""
    await next()
    return;
  }
  const res = await checkAuth(ctx)
  ctx.headers.userId = res.id
  await next()
}

checkAuth = async (ctx) => {
  const res = await fetch(AUTH_URL, {
    method: "GET",
    headers: {cookie: ctx.headers.cookie}
  }).then(res => res.json()).catch(error => console.log("AUTH ERROR:", error) || null)
  if (!res) {
    ctx.throw(500)
  }
  if (res.status == 401) {
    ctx.throw(res.status, res.message)
  }
  return res
}

exports.checkAuth = checkAuth
