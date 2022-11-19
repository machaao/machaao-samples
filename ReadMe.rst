Get Started
=============================================================================  

.. image:: https://badges.gitter.im/messengerx-io/community.svg
   :target: https://gitter.im/messengerx-io/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge
   :alt: Gitter

Requirements
---------------------
JDK 8
Latest Android SDK tools
Latest Android platform tools
Android SDK 21 or newer
AndroidX
Basic Server Side Programming (Python / NodeJS)

Overview
---------------------

**basic\_sample\_bot** : This is an echo bot which shows the basic usage
of the MACHAAO send message API, it contains the following code base to
get you started

The above repository contains two assets - Server side code for a simple
echo bot - Client Android App Source Code

Get a FREE API Token
---------------------

Get your FREE API Token by signing up @ https://portal.messengerx.io

Integrate your bot on your website
--------------------

**Step\_1**: Below is a sample script you need to paste into your
website to install webchat for your chatbot.

::

    <script
            id="webchat"
            src="https://dev.messengerx.io/bot/js/widget.js"
            type="text/javascript"
            themecolor="#2196f3"
            chathost="https://dev.messengerx.io"
            botname="<!-- your bot name -->"
            machaaokey="<!-- your api token -->"
            avatarurl="<!-- your bot logo url -->"
        ></script>

**Step\_2**: You will need to update variables above as shown below:

``themecolor`` : Put the desired color in hex or rgb format which will
be applied to the chat header background, buttons and message bubble
background.

``botname`` : The name of the bot that will appear on the chat header

``avatarurl`` : The url of the image that is shown on bot launcher icon.

``chathost`` : Url where the static assets for the webchat are hosted.

``machaaokey`` : The API token for your bot proivded by Machaao

Integrate your bot in your android app
-------------------------

Add following to your app gradle file.

::

    maven {
        url "https://cdn.machaao.com/sdk/android/snapshots"
    }

Add Gradle Dependency
---------------------

::

     debugImplementation('com.machaao.android:machaao-sdk:1.831-SNAPSHOT') {
            transitive = true
     }


Modify Manifest (Add Token)
---------------------------

::

     <meta-data android:name="com.machaao.android.sdk.token"
    android:value="<!-- Replace with your bot / api token assigned by MACHAAO Inc (connect@machaao.com) -->" />

Add SingleBotActivity Reference to Manifest (Bot Developers)
------------------------------------------------------------

::

      <activity android:name="com.machaao.android.sdk.activities.SingleBotActivity"
            android:logo="@mipmap/ic_launcher"
            android:windowSoftInputMode="stateHidden|adjustResize"
            android:screenOrientation="portrait"
            android:launchMode="singleTop"
            tools:node="merge"
            android:theme="@style/AppTheme.Orange">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
                <action android:name="android.intent.action.VIEW" />
            </intent-filter>
        </activity>


Intialize MACHAAO Chatbot SDK
-----------------------------

::

     Machaao.initialize(this);

Launch Your Bot / Mini App via our SDK [For Bot Developers / Partners]
----------------------------------------------------------------------

::

      Intent intent = new Intent(this, SingleBotActivity.class);
      intent.putExtra("botToken", botToken);
      startActivity(intent);

Launch Your Bot / Mini App via our SDK [For Bot Developers / Partners]
----------------------------------------------------------------------

Sample Android Chat App @ https://github.com/machaao/machaao-samples/tree/master/basic_sample_bot/client/android/sample_bot_client


Contact us for Advanced Usage / Implementation Support / Bugs
-------------------------------------------------------------
Please feel free to contact us for advanced support and instructions.
Email us at connect@machaao.com to get you started.
