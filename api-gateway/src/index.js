const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
app.use(bodyParser())

const { auth } = require('./auth')
const { proxyRequest } = require('./proxyRequest')
const { matchRequest } = require('./matchRequest')

app
  .use(matchRequest)
  .use(auth)

app.listen(3000)
