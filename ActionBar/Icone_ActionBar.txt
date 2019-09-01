// back button
// AndroidManifest.xml
<activity android:name=".NewActivity"
    android:label="Título"
    android:parentActivityName=".MainActivity">
</activity>
		
ou

// AndroidManifest.xml
<application
    android:icon="@drawable/ic_launcher"
    android:label="@string/app_name"
    android:theme="@style/Seu.Tema">
    ...
</application>

// Class
ActionBar bar = getActionBar();
if(bar != null){
    bar.setDisplayShowHomeEnabled(true);
    bar.setLogo(R.drawable.ic_launcher);
    bar.setDisplayUseLogoEnabled(true);
}
