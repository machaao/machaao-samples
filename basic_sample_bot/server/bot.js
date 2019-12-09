//
// This is main file containing code implementing the Express server and functionality for the Express echo bot.
//
'use strict';
const express = require('express');
const bodyParser = require('body-parser');
const request = require('request');
const path = require('path');
let jwt = require('jsonwebtoken');
var messengerButton = "<html><head><title>Sample Machaao Bot</title></head><body><h1>Sample Bot</h1>This is a bot based on Machaao Platform. For more details, see their <a href=\"https://ganglia-dev.machaao.com/api-docs\">docs</a>.<script src=\"https://button.glitch.me/button.js\" data-style=\"glitch\"></script><div class=\"glitchButton\" style=\"position:fixed;top:20px;right:20px;\"></div></body></html>";

// The rest of the code implements the routes for our Express server.
let app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

// Display the web page
app.get('/', function(req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.write(messengerButton);
  res.end();
});

// Message processing
app.post('/machaao_hook', function (req, res) {
  console.log(req.body);
  var data = req.body;
  let secretKey;
  let _rawBody = data && data.raw;

  if(req.headers.api_token) {
      secretKey = req.headers.api_token;
  }

  let userID;

  if(req.headers.user_id) {
    userID = req.headers.user_id;
  }

  let api_token = secretKey; // HACK

  if(!_rawBody || !userID) {
    res.status(500).send({
      message: 'Unauthorized Client Request, Bot is not available at this time, Please contact us at connect@machaao.com'
    });
  }

  jwt.verify(_rawBody, secretKey, {"algorithms": ["HS512"]}, function(err, decoded) {
    if(err) {
        botLogger.error("not authorized request, body: " + _rawBody + ", err: " + JSON.stringify(err));
        res.status(500).send({
          message: 'Unauthorized Client Request, Bot is not available at this time, Please contact us at connect@machaao.com'
        });
      } else {
        try {
          // console.log("decoded body: " + JSON.stringify(decoded));
          let _body = decoded && decoded.sub && decoded.sub.messaging ? decoded.sub : JSON.parse(decoded && decoded.sub);
          const messagingEntries = getMessagingEntries(_body) || _body;

          messagingEntries.forEach(function (m) {
              const messaging = m;

              let version = messaging.version && messaging.version.replace("v", "");
              console.log("client: v" + version);

              if(!messaging.client || (version && eval(version) < 0.585)) {
                const _upgradeClient = "Sorry, you are using an older or an invalid version of the client.\nPlease update from Play Store....\nDownload -> https://play.google.com/store/apps/details?id=com.machaao.ganglia.cricket.release"; //findAndReplace(config.error_responses.maintenance_mode, "{name}", _sName);
                res.status(500).send({
                  message: _upgradeClient
                });
                return;
              }

              // console.log("firebase input message payload: " + JSON.stringify(messaging));

              var msg = messaging.message_data && messaging.message_data.text ? messaging.message_data.text : "";
              let _isMetaData = false;

              if(messaging.message_data.quick_reply_response && messaging.message_data.quick_reply_response.metadata) {
                msg = messaging.message_data.quick_reply_response.metadata; // prefer meta data processing...
                _isMetaData = true;
              }

              const silent = messaging.silent;
              const sender = messaging.sender;
              let user = getUser(messaging);


              switch (msg) {
                case 'generic':
                  sendGenericMessage(userID);
                  break;
                default:
                  sendTextMessage(userID, msg);
              }

              console.log("processed message: " + msg  + " from " + userID);
            });

            res.sendStatus(200);

        } catch (e) {
          res.status(500).send({
            message: 'Bot is not available at this time, Please contact us at connect@machaao.com'
          });
        }
      }
  });
    // Assume all went well.
    // You must send back a 200, within 20 seconds, to let us know
    // you've successfully received the callback. Otherwise, the request
    // will time out and we will keep trying to resend.
  // }
});

//////////////////////////
// Sending helpers
//////////////////////////
function sendTextMessage(userID, messageText) {
  var messageData = {
    identifier: 'BROADCAST_FB_QUICK_REPLIES',
    users: [userID],
    source: "firebase",
    message: {
      text: messageText
    }
  };

  callSendAPI(messageData);
}

function getMessagingEntries(body) {
    let self = this;
    const val = body.messaging &&
    Array.isArray(body.messaging) &&
    body.messaging.length > 0 && body.messaging;
    return val || null;
  }

function getUser(messaging) {
    let self = this;
    const val = messaging.user;
    return val || null;
}

function sendGenericMessage(userID) {
  var messageData = {
    identifier: 'BROADCAST_FB_QUICK_REPLIES',
    users: [userID],
    source: "firebase",
    message: {
      attachment: {
        type: "template",
        payload: {
          template_type: "generic",
          elements: [{
            title: "rift",
            subtitle: "Next-generation virtual reality",
            image_url: "http://messengerdemo.parseapp.com/img/rift.png",
            buttons: [{
              type: "web_url",
              url: "https://www.oculus.com/en-us/rift/",
              title: "Open Web URL"
            }, {
              type: "postback",
              title: "Call Postback",
              payload: "Payload for first bubble",
            }],
          }, {
            title: "touch",
            subtitle: "Your Hands, Now in VR",
            image_url: "http://messengerdemo.parseapp.com/img/touch.png",
            buttons: [{
              type: "web_url",
              url: "https://www.oculus.com/en-us/touch/",
              title: "Open Web URL"
            }, {
              type: "postback",
              title: "Call Postback",
              payload: "Payload for second bubble",
            }]
          }]
        }
      }
    }
  };

  callSendAPI(messageData);
}

function callSendAPI(messageData) {
  request({
    uri: 'https://ganglia-dev.machaao.com/v1/messages/send',
    headers: {
      "api_token": "5be86060-1982-11ea-a5b2-2b73297f80e5", // YOUR API KEY (connect@machaao.com)
      "Content-Type": "application/json"
    },
    method: 'POST',
    json: messageData

  }, function (error, response, body) {
    if (!error && response.statusCode == 200) {
      // var recipientId = body.recipient_id;
      // var messageId = body.message_id;

      console.log("Successfully sent a message - " + JSON.stringify(body));
    } else {
      console.error("Unable to send message.");
      console.error(response);
      console.error(error);
    }
  });
}

// Set Express to listen out for HTTP requests
var server = app.listen(process.env.PORT || 3000, function () {
  console.log("Listening on port %s", server.address().port);
});
