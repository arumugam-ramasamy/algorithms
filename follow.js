var express = require('express');
var app = require('express')();
var http = require('http').Server(app);
var follow = require('text-file-follower');
const io = require('socket.io')(http);

app.use(express.static(__dirname + '/public'));

app.get('/', function(req, res) {
   res.sendfile('MetricLog.html');
});


 
// Totally redundant with the listener callback, but...
io.on('connection', (socket) => {

var allEventsCallback = function(event, filename, value) {
  switch (event) {
    case 'success':
//      console.log("Got success -- file exists and we're following");
      break;
    case 'line':
//      console.log("A line was appended to the file: " + value);
      socket.emit('line',value);
      break;
    case 'close':
//      console.log("We must have called follower.close()");
      break;
    case 'error':
//      console.log("Oh noes! Here's the error message: " + value);
      break;
  }
};
 
// Pass options and a callback
var follower = follow(
                '/home/pranav/nodejs/random.log',
                { persistent: true },
                allEventsCallback);

    socket.on('message', (received) => {
    console.log('client has received ', received);
  });
    follower.on('all', allEventsCallback);


});

http.listen(3001, function() {
   console.log('listening on *:3001');
});

