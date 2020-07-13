Get Started
=============================================================================

Requirements
---------------------
JDK 8
Latest Android SDK tools
Latest Android platform tools
Android SDK 21 or newer
AndroidX

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
website to install webchat for your Machaao bot.

::

  <script themecolor="#2b2bab" botname="Ganglia" avatarurl="chaticon.png" type="text/javascript"
      id="webchat" chathost="https://web-client-dev.machaao.com" machaaokey="<botkey>" src="https://web-client-dev.machaao.com/static/js/script.js"></script>

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
        url "https://machaao-android-builds.s3.amazonaws.com/sdk/android/snapshots"
    }
    maven {
        url "https://machaao-android-builds.s3.amazonaws.com/sdk/android/releases"
    }

Add Gradle Dependency
---------------------

::

     debugImplementation('com.machaao.android:machaao-sdk:0.828-SNAPSHOT') {
            transitive = true
     }

     releaseImplementation('com.machaao.android:machaao-sdk:0.828') {
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



Contact us for Advanced Usage / Implementation Support / Bugs
-------------------------------------------------------------
Please feel free to contact us for advanced support and instructions.
Email us at connect@machaao.com to get you started.
