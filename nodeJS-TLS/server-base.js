var fs = require('fs'); 
var https = require('https'); 
var options = { 
  //key: fs.readFileSync(<ficheiro PEM com chave privada do servidor>), 
  //cert: fs.readFileSync(<ficheiro PEM com certificado do servidor>), 
  //ca: fs.readFileSync(<ficheiro PEM com certificado da CA root>), 
  //requestCert: true, 
  //rejectUnauthorized: true 
}; 

var server = https.createServer(options, function (req, res) { 
  console.log(new Date()+' '+ 
    req.socket.remoteAddress+' '+ 
    //req.socket.getPeerCertificate().subject.CN+' '+ 
    req.method+' '+req.url); 
  res.writeHead(200); 
  res.end("Secure Hello World with node.js\n"); 
}).listen(4433);

server.on('uncaughtException', function (e) {
  // Handle your error here
  console.log(e);
});

console.log('Listening @4433');