const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
app.use(bodyParser())

const { authRequest } = require('./authRequest')
const { matchRequest } = require('./matchRequest')
const { fetchRequest } = require('./fetchRequest')

app
  .use(matchRequest)
  .use(authRequest)
  .use(fetchRequest)

app.listen(3000)
