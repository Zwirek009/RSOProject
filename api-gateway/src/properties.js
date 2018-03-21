const DEFAULT_HOST = 'localhost'

testService = process.env.testService || DEFAULT_HOST
authService = process.env.authService || DEFAULT_HOST

hosts = {
  "auth": authService,
  "test": testService
}
