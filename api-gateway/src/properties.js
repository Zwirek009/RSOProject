const DEFAULT_HOST = 'localhost'
const DEFAULT_PORT = ':8080'

testService = (process.env.testService || DEFAULT_HOST) + DEFAULT_PORT
authService = (process.env.authService || DEFAULT_HOST) + DEFAULT_PORT
beerService = (process.env.beerService || DEFAULT_HOST) + ':8082'

exports.hosts = {
  auth: authService,
  test: testService,
  beer: beerService,
}
