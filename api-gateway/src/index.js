const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
app.use(bodyParser())

const { auth } = require('./auth')
const { proxyRequest } = require('./proxyRequest')

app
  .use(auth)
  .use(proxyRequest)

app.listen(3000)
