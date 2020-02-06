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
ActionBar actionBar = getActionBar();
if(bar != null){
    actionBar.setDisplayShowHomeEnabled(true);
    actionBar.setLogo(R.drawable.ic_launcher);
    actionBar.setDisplayUseLogoEnabled(true);
	actionBar.setDisplayHomeAsUpEnabled(true);   //show back button
}
