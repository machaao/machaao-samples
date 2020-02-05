## Machaao Samples

The following code contains sample bots along with their server and android client components using MACHAAO Bot Messaging Platform

## API Documentation
Review the Chatbot Messaging Platform API located at https://ganglia-dev.machaao.com/api-docs

## Current Sample Bot(s)
**basic_sample_bot** : This is an echo bot which shows the basic usage of the MACHAAO send message API, it contains the following code base to get you started

The above repository contains two assets
-   Server side code for a simple echo bot
-   Client Android App Source Code

## Register your bot url
Contact us for registering your bot url and we will issue you an api_token (connect@machaao.com)

## Setup your Android Client
Add following to your gradle file
Include Machaao Maven Public Repository

    maven {
            url "https://machaao-android-builds.s3.amazonaws.com/sdk/android/snapshots"
        }

Add Gradle Dependency


     implementation('com.machaao.android:machaao-sdk:0.1.163-SNAPSHOT') {
            transitive = true
        }

Modify Manifest


     <meta-data android:name="com.machaao.android.sdk.token"
    android:value="<!-- Replace with your bot token assigned by MACHAAO Inc (connect@machaao.com) -->" />
    

Intialize SDK

     Machaao.initialize(this);
    

Add MyBots Grid (For App Partners Only)

     <fragment
        android:name="com.machaao.android.sdk.fragments.MyBotFragment"
        android:id="@+id/botGrid"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
    

## single chatbot and multi chatbot sdk
If everything works fine you should be able to build your conversational app and run your bot(s) inside your own android / web app (iOS Coming Soon).

## Contact us for Advanced Usage
Please feel free to contact us for advanced support and instructions.
Email us at connect@machaao.com to get you started.
