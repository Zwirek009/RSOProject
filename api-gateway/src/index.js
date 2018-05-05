const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
app.use(bodyParser())

const { authRequest } = require('./authRequest')
const { matchRequest } = require('./matchRequest')
const { loginRequest } = require('./loginRequest')
const { fetchRequest } = require('./fetchRequest')
const { beerRequest } = require('./beerRequest')

app
  .use(matchRequest)
  .use(beerRequest)
  .use(authRequest)
  .use(loginRequest)
  .use(fetchRequest)

app.listen(3000)
