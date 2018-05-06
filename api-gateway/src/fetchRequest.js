const fetch = require('node-fetch')
const querystring = require('query-string')

const { restEndpoint } = require('./restEndpoint')
const { hosts } = require('./properties')

exports.fetchRequest = restEndpoint(async ctx => {
  const uri = prepareUri(ctx)
  const data = prepareData(ctx)

  console.log("DATA", data)
  console.log("URI", uri)
  const res = await fetch(uri, data)
    .then(res => res.text())
    .catch(error => console.log('FETCH ERROR:',error) && null)
  console.log("RES", res)
  return res
})

function prepareUri(ctx) {
  const querystring = ctx.request.querystring ? '?' + ctx.request.querystring : ''
  return 'http://' + hosts[ctx.match.service] + ctx.match.endpoint + querystring
}

function prepareData(ctx) {
  const data = {
    method: ctx.method,
    // headers: prepareHeaders(ctx)
  }
  if (ctx.method != "GET" && ctx.method != "HEAD") {
    body = ctx.request.body
    body.userId = ctx.headers.userId
    data.body = querystring.stringify(body)
  }
  return data
}

// function prepareHeaders(ctx) {
//   return {
//     cookie: ctx.headers.cookie,
//     userId: ctx.headers.userId,
//     'Content-Type': 'application/json'
//   }
// }