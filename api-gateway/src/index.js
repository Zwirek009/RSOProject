const Koa = require('koa')
const app = new Koa()
const bodyParser = require('koa-bodyparser');
var cors = require('koa-cors');

const corsOptions = {
  origin: true,
  credentials: true
};

app.use(bodyParser())
app.use(cors(corsOptions))


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
