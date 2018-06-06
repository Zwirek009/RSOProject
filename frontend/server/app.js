const express = require('express');
const http = require('http');
const path = require('path');
var proxy = require('http-proxy-middleware');

const app = express();

app.use(express.static(path.join(__dirname, '../dist/frontend')));

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, '../dist/frontend/index.html'));
});

app.use('/api', proxy({target: 'http://api-gateway:3000', changeOrigin: true}));

const port = process.env.PORT || '4200';
app.set('port', port);

const server = http.createServer(app);
server.listen(port, () => console.log('BeerShare frontend is running on 4200'));