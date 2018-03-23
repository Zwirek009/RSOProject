const rules = require('./rules')

const fetch = require('node-fetch')
const querystring = require('query-string')

const { hosts } = require('./properties')

const authHost = hosts.auth

const LOGIN_URL = `http://${authHost}/sessions`

exports.loginRequest = async (ctx, next) => {
  if (rules['/api/sessions'].POST != ctx.match) {
    await next()
    return;
  } else {
    const res = await fetch(LOGIN_URL, {
      method: "POST",
      headers: {
        "Content-type": "application/x-www-form-urlencoded"
      },
      body: querystring.stringify(ctx.request.body)
    }).catch((error) =>console.log(error) || null)
    if (!res) {
      ctx.throw(500)
    }
    if (res.status == 401) {
      ctx.throw(401, 'Unauthorized')
    }
    ctx.set('set-cookie', res.headers.get('set-cookie'))
    ctx.status = 200
  }
}
