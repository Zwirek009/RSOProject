const rules = require('./rules')

const fetch = require('node-fetch')
const querystring = require('query-string')

const { hosts } = require('./properties')
const { checkAuth } = require('./authRequest')

const beerHost = hosts.beer

const BEER_URL = `http://${beerHost}`

exports.beerRequest = async (ctx, next) => {
  if (rules['/api/beer/add'].POST == ctx.match) {
    requestBody = ctx.request.body
    const userData = await checkAuth(ctx)
    requestBody.userId = userData.id
    const res = await fetch(BEER_URL + '/beer/add', {
      method: "POST",
      body: querystring.stringify(requestBody)
    }).catch((error) => console.log(error) || null)
    ctx.status = 200
  } else {
    await next()
    return;
  }
}

