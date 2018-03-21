const DEFAULT_HOST = 'localhost'

testService = process.env.testService || DEFAULT_HOST
authService = process.env.authService || DEFAULT_HOST

exports.hosts = {
  auth: authService,
  test: testService
}
