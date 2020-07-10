What is MessengerX.io?
=============================================================================
MessengerX.io is a joint venture between AppyHigh and MACHAAO with an aim to aid developers
looking to build and monetize deeply personalized chat experiences.

Why MessengerX.io?
=============================================================================

.. figure:: _static/images/my_bots.png
   :scale: 25 %
   :align: center
   :alt: MessengerX.io - Everyday Chat Apps for Everyone

   Multi Bot SDK - v0.751 - Beta - Your Personal Bot Store

With our unique learnings in the conversational space from processing over 2.5B+ messages
from or to end users, we would like to claim that we know a thing or two about making good chat apps :)

We see a gap between good messaging apps and end users due to the operating nature of current messaging eco-systems.

We aim to bridge this gap between "great" chat apps and end users!

The Problem
=============================================================================
The issue of customer acquisition has been plaguing the chat apps industry for sometime now.

Facebook's Messenger Platform, so far has been the only viable option available to truly get any kind of “organic” traction on your consumer facing bot.

But that being said, the reach and the engagement of your chatbot would be severely impacted
by the introduction of some core changes in Facebook Messenger Platform Policy
as well as the removal of the "Discover" Feature. Even, if you were to look to WhatsApp as an alternative,
there is a marketing spend associated with promoting the phone number.

Such marketing spend numbers are generally not in the reach of independent developers or small businesses
who are looking to build deeply personalized chat apps.


How it Works?
=============================================================================

.. figure:: _static/images/platform_overview.png
   :width: 1429px
   :height: 678px
   :align: center
   :alt: MessengerX.io - Overview
   :figwidth: 75%

   How it Works? - MessengerX.io

When a person sends a message to your bot through MessengerX SDKs integrated inside publisher or partner app(s).

The following set of events sequence should take place when an incoming message is received destined for you bot.

* Our servers would route the incoming messages to Your Webhook or CHAT BOT URL, where your messaging app or chatbot is hosted.

* Using the Send Message API, the mini app or the chat bot can then respond to the person directly on the Partner App via our Platform APIs

The MessengerX Platform is FREE for developers looking to build highly engaging consumer based chat apps.

In fact, you earn 💰 per incoming message your bots process!

Learn more @ https://www.linkedin.com/pulse/build-chatbot-starting-earning-per-message-harshal-dhir




What is a Chatbot?
=============================================================================
Messaging Apps or ChatBots are light weight programs that one can talk to carry quick tasks.

.. figure:: _static/images/ganesha_android_screenshot.png
   :scale: 25 %
   :align: center
   :alt: Ganesha - Your Horoscope Assistant

   Daily Horoscope Assistant (Powered by GaneshaSpeaks.com)

Get Started
=============================================================================
Signup and Get your FREE API Token to get started

Signup @ https://portal.messengerx.io

Receiving Messages
=============================================================================
Understanding Webhooks
-----------------------------------------------------------------------------
Webhook is a REST endpoint url which denotes your custom functions / callbacks.

This is the end point which will receive any incoming messages destined for your bot.

Understanding Message Payloads
-----------------------------------------------------------------------------
A message payload is a JSON representation of an incoming message sent by the end user.

Encrypted Incoming Message Payload
-----------------------------------------------------------------------------
The incoming messages that your webhook will receive are encrypted using HS512 algorithm with your token as the key.

Below is the JSON representation of the raw incoming message.

::

 {"raw":"eyJhbGciOiJIUziJ9.===jsY8eeeru2i1vcsJQ....."}


Decrypting Incoming Message Payload
-----------------------------------------------------------------------------
Decrypt the incoming payload with the secret_key provided.

You can use the open source JWT.io libraries available for all major programming languages

Let's quickly go through the sample representation of the decrypted incoming message object payload

* messaging: list of incoming message actions
* message_data: details about the nature of data sent.
* user: basic user info details about the user associated with the message.
* sender: the unique device id of the user.
* client: the partner app client id.
* version: android / web sdk client version
* silent: if silent is true, don't reply back to the request.

::

 {
   "sub":{
      "messaging":[
         {
            "message_data":{
               "text":"hi",
               "action_type":"get_started"
            },
            "user":{
               "userId":"<!-- USER_ID -->",
               "creation_time":1589518339556,
               "device_id":"311b145ed6a96d6",
               "email":"<c11b145ed6a96d6>@machaao.com",
               "timezone":"-7.0"
            },
            "sender":"dWnjre9rTr65ZeiOmrY1oU",
            "silent":false,
            "client":"messenger.---.debug",
            "version":"0.814"
         }
      ]
   }
 }

Sending On-Demand Responses
=============================================================================
Send a outgoing message in response to user's input can be done by the usage of our On Demand Messaging APIs as demonstrated below


Sending a Text Message Response
-----------------------------------------------------------------------------
Below is an example CURL request to send a message / response to a particular user id using our Core Messaging APIs.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/messages/send' \
    --header 'api_token: API_TOKEN' \
    --header 'Content-Type: application/json' \
    --header 'Content-Type: text/plain' \
    --data-raw '{
      "users":["<!--- UNIQUE_USER_ID -->"],
      "message":{
          "text": "I am a good bot",
          "quick_replies": [{
            "content_type": "text",
            "title": "Hi",
            "payload": "hi"
          }]
       }
    }'


Sending a Media Attachment
-----------------------------------------------------------------------------
Below is an example CURL request to send a message attachment to a particular user id.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/messages/send' \
    --header 'api_token: API_TOKEN' \
    --header 'Content-Type: application/json' \
    --header 'Content-Type: text/plain' \
    --data-raw '{
      "users":["<!-- UNIQUE_USER_ID -->"],
      "message":{
          "attachment":{
             "type":"template",
             "payload":{
                "template_type":"generic",
                "elements":[
                   {
                      "title": "Test #786 - Duffle Bag + 200 Machaao Credits",
                      "subtitle":"Only Pay Shipping & Handling Charges. Combo Offer for Machaao Users only.",
                      "image_url":"https://provogue.s3.amazonaws.com/provogue-duffle1.jpg"
                   }
                ]
             }
          },
          "quick_replies": [{
            "content_type": "text",
            "title": "Hi",
            "payload": "hi"
          }]
       }
    }'

Sending a List of Media Attachment(s) aka Carousel
-----------------------------------------------------------------------------
Below is an example CURL request to send a list of attachments / media elements to a particular user id.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/messages/send' \
    --header 'api_token: API_TOKEN' \
    --header 'Content-Type: application/json' \
    --header 'Content-Type: text/plain' \
    --data-raw '{
      "users":["<!-- UNIQUE_USER_ID -->"],
      "message":{
          "attachment":{
             "type":"template",
             "payload":{
                "template_type":"generic",
                "elements":[
                   {
                      "title": "Test #786 - Duffle Bag + 200 Machaao Credits",
                      "subtitle":"Only Pay Shipping & Handling Charges. Combo Offer for Machaao Users only.",
                      "image_url":"https://provogue.s3.amazonaws.com/provogue-duffle1.jpg"
                   },
                   {
                      "title": "Test #787 - Duffle Bag + 200 Machaao Credits",
                      "subtitle":"Only Pay Shipping & Handling Charges. Combo Offer for Machaao Users only.",
                      "image_url":"https://provogue.s3.amazonaws.com/provogue-duffle1.jpg"
                   }
                ]
             }
          },
          "quick_replies": [{
            "content_type": "text",
            "title": "Hi",
            "payload": "hi"
          }]
       }
    }'

Personalization, Tagging & User Engagement
=============================================================================
The personalization and engagement api is the core base to build sophisticated re-engaging bots.

The process starts with tagging a user, Tagging a user allows you to open up
multiple re-targeting or re-engagement use cases such as sending daily news, personalized responses, etc.

Tag a User
-----------------------------------------------------------------------------
Annotate or Tag a user for deeper personalization.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/users/tag/<USER_ID>' \
    --header 'api_token: <API_TOKEN>' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "tag": "india",
      "status": 1,
      "displayName": "India"
    }'

Un-tag a User
-----------------------------------------------------------------------------
Un-tag a user for deeper personalization.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/users/tag/<USER_ID>' \
    --header 'api_token: <API_TOKEN>' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "tag": "india",
      "status": 0,
      "displayName": "India"
    }'

Get all the Active Tags for a Particular User in Context
-----------------------------------------------------------------------------
Get all the tags for deeper personalization use cases.

::

    curl --location --request GET 'https://ganglia-dev.machaao.com/v1/users/tag/<USER_ID>' \
    --header 'api_token: <API_TOKEN>' \
    --header 'Content-Type: application/json'


Sending Subscription Messages
=============================================================================
Sending a broadcasts or an announcements in order to re-engage your bot user.

Sample CURL Command
-----------------------------------------------------------------------------
Below is an example CURL request to send a message / response to a particular user id using our Core Messaging APIs.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/messages/announce' \
    --header 'api_token: API_TOKEN' \
    --header 'Content-Type: application/json' \
    --data-raw '{
      "tags":["india", "pakistan", "usa"],
      "message":{
          "text": "I am a good bot",
          "quick_replies": [{
            "content_type": "text",
            "title": "Hi",
            "payload": "hi"
          }]
       }
    }'


Headless CMS
=============================================================================
Tagging a user allows you to open up multiple re-targeting or re-engagement use cases such as sending daily news, personalized responses, etc.

Insert new content
-----------------------------------------------------------------------------
Auto-Annotate and insert content for your chat app.

::

    curl --location --request POST 'https://ganglia-dev.machaao.com/v1/content' \
    --header 'api_token: <API_TOKEN>' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "url": "https://www.youtube.com/watch?v=5UmM-tclggg",
        "tags": ["india", "pakistan", "bangladesh"]
    }'

Search API
-----------------------------------------------------------------------------
Allows you to perform search content for your chat app by query based in a paginated way.

::

   curl --location --request GET 'https://ganglia-dev.machaao.com/v1/content/search?q=ipl&limit=10&skip=0' \
   --header 'api_token: <API_TOKEN>' \
   --header 'Content-Type: application/json'


Open Source Samples
=============================================================================
Below are some samples which will help get you started


RASA Sample
-----------------------------------------------------------------------------
https://github.com/machaao/rasa-sample-nlu-bot




Bonus for Developers
=============================================================================
In addition to the massive savings on marketing and infrastructure costs, the platform also offers
multiple other Rest APIs dor developers looking to build deeply personalized super chat apps:

* Rich Messaging Support via On Demand Messaging API
* Deep Personalization via Tagging API
* Auto ML based Engagement via Announcement API
* Data Capture API (Subjected to Approval)
* Transactional Wallet API (Subjected to Approval)
* FREE Hosting for your chat bot (Subjected to Approval)
* Guaranteed Message Processing (Subjected to Approval)
* Admin Dashboard (Premium)

Small Businesses / Enterprise
=============================================================================
* Do you have an existing facebook messenger chatbot?
* Own your data with our SDKs
* Make your existing chatbot / platform work inside your client android app or website within hours.
* Conversational Bot Designer (Premium)

Other Resources
=============================================================================
Partner Deck: https://docsend.com/view/jxdbrcf

Join our Gitter Community
=============================================================================
Coming Soon


.. Indices and tables
.. ==================
..
.. * :ref:`genindex`
.. * :ref:`modindex`
.. * :ref:`search`
