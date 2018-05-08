const DEFAULT_HOST = 'localhost'
const DEFAULT_PORT = ':8080'

authService = (process.env.authService || DEFAULT_HOST) + DEFAULT_PORT
beerService = (process.env.beerService || DEFAULT_HOST) + ':8082'

exports.hosts = {
  auth: authService,
  beer: beerService,
}
