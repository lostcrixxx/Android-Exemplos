AndroidManifest.xml -

<?xml version="1.0" encoding="utf-8"?>
<manifest ...>
    <uses-permission android:name="android.permission.INTERNET" />
    <application
        ...
        android:usesCleartextTraffic="true"
        ...>
        ...
    </application>
</manifest>

https://developer.android.com/guide/topics/manifest/application-element#usesCleartextTraffic