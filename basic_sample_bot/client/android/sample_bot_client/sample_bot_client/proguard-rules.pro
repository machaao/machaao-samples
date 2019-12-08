####################################################################################################
####################################################################################################
####################################################################################################
######################################### PROGUARD #################################################
####################################################################################################
####################################################################################################
####################################################################################################

# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

-printusage unused.txt


# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
#-dontoptimize
#-dontpreverify

# If you want to enable optimization, you should include the
# following:
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
-allowaccessmodification

-keep class androidx.appcompat.widget.** { *; }
-keep interface androidx.appcompat.widget.** { *; }

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version. We know about them, and they are safe.
#-dontwarn android.support.**
#-dontwarn com.google.ads.**
#-dontwarn org.apache.http.**
#-dontwarn javax.servlet.**
#-dontwarn org.w3c.dom.**
#-dontwarn java.beans.**
#-dontwarn java.lang.**
#-dontwarn org.slf4j.**
#-dontwarn javax.xml.**
#-dontwarn org.bouncycastle.**
#-dontwarn org.apache.**
#-keep class java.lang.** { *; }

#jasypt
#-keep class org.jasypt.** {*;}
#-keep interface org.jasypt.** {*;}
#-keep enum org.jasypt.** {*;}
#-dontwarn com.ibm.icu.text.**
#-dontwarn org.jasypt.web.pbeconfig.WebPBEConfigServlet
#-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry
#-keepattributes SourceFile, LineNumberTable


# Note that you cannot just include these flags in your own
# configuration file; if you are including this file, optimization
# will be turned off. You'll need to either edit this file, or
# duplicate the contents of this file and remove the include of this
# file from your project's proguard.config path property.

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends androidx.fragment.app.Fragment
-keep public class * extends androidx.fragment.app.FragmentActivity
-keep public class * extends androidx.fragment.app.DialogFragment
-keep public class * extends android.app.Fragment
-keep public class * implements java.lang.annotation.Annotation

## Retrofit, OkHttp, Gson
#-keepattributes *Annotation*,EnclosingMethod,Signature
#-keepattributes InnerClasses
#-keep class org.bouncycastle.** { *; }
#-keep class io.jsonwebtoken.** { *; }
#-keepnames class io.jsonwebtoken.* { *; }
#-keepnames interface io.jsonwebtoken.* { *; }
#-dontwarn io.jsonwebtoken.impl.Base64Codec
#-keepnames class com.fasterxml.jackson.** { * ; }
#-keepnames interface com.fasterxml.jackson.** { *; }
#-keep class com.fasterxml.jackson.** { *; }

# OkHttp3
#-keep class okhttp3.** { *; }
#-keep interface okhttp3.** { *; }
#-keep class android.support.v7.app.** { *; }
#-keep interface android.support.v7.app.** { *; }
#-keep class com.parse.** { *; }
#-keep class org.slf4j.** { *; }
#-keep class com.wang.avi.** { *; }
#-keep class com.wang.avi.indicators.** { *; }
#-keep class pl.droidsonroids.gif.** { *; }
#-keep class org.diztart.no2.** { *; }
#-keep class org.slf4j.** { *; }
#-keep class org.h2.** { *; }
#-keep class org.objenesis.** { *; }

###---------------Begin: proguard configuration for ButterKnife  ----------
# For Butterknife:
#-keep class butterknife.** { *; }

# Version 7
#-keep class **$$ViewBinder { *; }
# Version 8
#-keep class **_ViewBinding { *; }

#-keepclasseswithmembernames class * { @butterknife.* <fields>; }
#-keepclasseswithmembernames class * { @butterknife.* <methods>; }
###---------------End: proguard configuration for ButterKnife  ----------


#-keep class com.machaao.android.sdk.models.** { *; }

### -- appsflyer -- ###
-keep class com.appsflyer.** { *; }

-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**
-dontwarn com.google.firebase.appindexing.**

#############
# Serializables
#############
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}


# PayTM Integration
-keepclassmembers class com.paytm.pgsdk.PaytmWebView$PaytmJavaScriptInterface {
   public *;
}

#okhttp
#-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
#-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

#-keepclassmembers class * extends com.stephentuso.welcome.WelcomeActivity {
#    public static java.lang.String welcomeKey();
#}

#
#-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$OutcomingTextMessageViewHolder {
#     public <init>(android.view.View, java.lang.Object);
#     public <init>(android.view.View);
# }
#-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$IncomingTextMessageViewHolder {
#     public <init>(android.view.View, java.lang.Object);
#     public <init>(android.view.View);
# }
#-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$IncomingImageMessageViewHolder {
#     public <init>(android.view.View, java.lang.Object);
#     public <init>(android.view.View);
# }
#-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$OutcomingImageMessageViewHolder {
#     public <init>(android.view.View, java.lang.Object);
#     public <init>(android.view.View);
# }