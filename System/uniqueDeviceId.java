public String getUniqueDeviceId() {
	String androidId = "No_DEVICE_ID";
	try {
		androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
	} catch (Exception e) {
		Log.e(TAG, "ERROR getUniqueDeviceId() " + e.toString());
		e.printStackTrace();
	}
	return androidId;
}