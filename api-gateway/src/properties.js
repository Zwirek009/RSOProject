const DEFAULT_HOST = 'localhost:8081'

testService = process.env.testService || DEFAULT_HOST
authService = process.env.authService || DEFAULT_HOST

exports.hosts = {
  auth: authService,
  test: testService
}
