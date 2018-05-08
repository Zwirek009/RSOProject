const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
const cors = require('@koa/cors');

app.use(bodyParser())
app.use(cors())


const { authRequest } = require('./authRequest')
const { matchRequest } = require('./matchRequest')
const { loginRequest } = require('./loginRequest')
const { fetchRequest } = require('./fetchRequest')

app
  .use(matchRequest)
  .use(authRequest)
  .use(loginRequest)
  .use(fetchRequest)

app.listen(3000)
