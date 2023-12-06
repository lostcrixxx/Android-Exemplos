// site
sentry.io

// dependencies
implementation 'io.sentry:sentry-android:5.0.1'

// manifest
<application>
...
<meta-data android:name="io.sentry.dsn" android:value="https://00000.ingest.sentry.io/000000" />
</application>

// implementation
SentryAndroid.init(this, options -> { // // initialize Sentry
});

// test
Sentry.captureMessage("testing");