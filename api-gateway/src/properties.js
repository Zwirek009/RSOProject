const DEFAULT_HOST = 'localhost'
const DEFAULT_PORT = ':8080'

testService = (process.env.testService || DEFAULT_HOST) + DEFAULT_PORT
authService = (process.env.authService || DEFAULT_HOST) + DEFAULT_PORT

exports.hosts = {
  auth: authService,
  test: testService
}
