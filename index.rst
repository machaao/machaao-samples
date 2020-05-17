What is MessengerX? (Draft In Progress)
=============================================================================
MessengerX.io is a collaboration between MACHAAO and AppyHigh,
with an aim to aid developers looking to build and monetize deeply personalized messaging experiences.

.. figure:: _static/images/my_bots.png
   :scale: 25 %
   :align: center
   :alt: MessengerX.io - Bots everywhere!

   Multi Bot SDK - v0.751 - Beta - Your Personal Bot Store

The Problem
=============================================================================
The issue of customer acquisition has been plaguing the chatbot industry for sometime now.

Facebook's Messenger Platform, so far has been the only viable option available to truly get any kind of “traction” on your consumer facing bot.

Also, let's not forget the abilities of the Messenger Platform,
which are way ahead in our opinion than currently supported by Twitter, WhatsApp.

But that being said, the reach and the engagement has been severely impacted by the introduction of changes in Facebook Messenger Platform Policy
as well as the removal of the Discover Feature.

Even, if you were to look to WhatsApp as an alternative,
there is a marketing spend associated with promoting the phone number.

Such marketing spend numbers are generally not in the reach of independent developers or small businesses
who are looking to build deeply personalized chat bots.

Why MessengerX.io?
=============================================================================
With our unique learnings in the conversational space from processing over 2.5B+ messages from end consumers
in addition millions of active devices in our collective app ecosystem.

We see there is a gap between good chat bots and end users, alleviated now by the removal of Discover feature by Facebook.

We aim to bridge this gap between great chatbots and end users!

How it Works?
=============================================================================

.. figure:: _static/images/how_it_works.png
   :scale: 100 %
   :align: center
   :alt: How it Works - MessengerX.io

   How it Works? - MessengerX.io

When a person sends a message to your bot through MessengerX SDKs integrated inside publisher or partner app(s),
the following should happen.

* Our servers would route the incoming messages to the configured Webhook URL, where your messaging app is hosted.

* Using the Send Message API, the mini app or the chat bot can respond to the person on the Partner App.

As Darren Yau - Our lead chat bot developer puts it aptly,
“If you already have a Facebook Messenger based chatbot you can seamlessly launch
and expose your bot on millions of android devices within days if not hours!”

The MessengerX Platform is FREE for developers looking to build highly engaging consumer based chatbots.

What is a Chatbot?
=============================================================================
Messaging Apps or ChatBots are light weight programs that run inside an existing app
without any new installation required on the user side.

.. figure:: _static/images/ganesha_android_screenshot.png
   :scale: 25 %
   :align: center
   :alt: Ganesha - Your Horoscope Assistant

   Daily Horoscope Assistant (Powered by GaneshaSpeaks.com)

Receiving Messages from Users
=============================================================================
Understanding Webhooks
-----------------------------------------------------------------------------
Webhook is a REST endpoint url which denotes your custom functions / callbacks.

This is the end point which will receive any incoming messages destined for your bot.

Message Payload
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
* user: basic user details about the user requesting information.
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
               "userId":"JzBt502kWS",
               "creation_time":1589518339556,
               "device_id":"c311b145ed6a96d6",
               "email":"c311b145ed6a96d6@machaao.com",
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

Send a Text Message
=============================================================================




Sending Text
-----------------------------------------------------------------------------
Coming Soon

Sending a Media Attachment
-----------------------------------------------------------------------------
Coming Soon

Sending a List of Media Attachments
-----------------------------------------------------------------------------
Coming Soon

Small Businesses / Enterprise
=============================================================================
* Do you have an existing facebook messenger chatbot?
* Own your data with our SDKs
* Make your existing chatbot / platform work inside your client android app or website within hours.


Additional Perks for Developers
=============================================================================
In addition to the massive savings on marketing costs, the platform also offers
a developer suite looking to build deeply personalized apps:

* Rich Messaging Support via Core Messaging API
* Deep Personalization via Tagging API
* Deeper Engagement via Announcement API
* FREE Hosting for your chat bot (Subjected to Approval)
* Headless Conversational CMS API
* Data Capture API
* Transactional Wallet API
* Guaranteed Message Processing (Premium)
* Admin Dashboard (Premium)
* UI Bot Designer (Premium)


Partners
=============================================================================
Coming Soon

.. Indices and tables
.. ==================
..
.. * :ref:`genindex`
.. * :ref:`modindex`
.. * :ref:`search`
