const fetch = require('node-fetch')

const { restEndpoint } = require('./restEndpoint')
const { endpoints } = require('./properties')

exports.proxyRequest = restEndpoint(async ctx => {
  const uri = prepareUri(ctx)
  const data = prepareData(ctx)
  const res = await fetch(uri, data)
    .then(res => res.text())
    .catch(error => console.log(error) && null)
  console.log("LOG", res)
})

function prepareUri(ctx) {
  const url = ctx.request.url
  endpoints.filter(e => url.match(e.path))
    .map(console.log)
  return ctx.request.url
}

function prepareData(ctx) {
  return {
    method: ctx.method,
    body: JSON.stringify(ctx.request.body),
    headers: prepareHeaders()
  }
}
function prepareHeaders() {
  return {
    'Content-Type': 'application/json'
  }
}
