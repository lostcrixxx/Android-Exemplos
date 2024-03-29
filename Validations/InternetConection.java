// add policy or create in a separate thread from the main one
StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
StrictMode.setThreadPolicy(policy);	
public boolean isInternetAvailable() throws UnknownHostException {
	boolean result = false;

	try {
		InetAddress ipAddr = InetAddress.getByName("google.com");
		Log.e(TAG, "isConnected(): " + !ipAddr.equals(""));
		result = !ipAddr.equals("");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}


@IntRange(from = 0, to = 3)
public static int isConnected(Context context) {
    int result = 0; // Returns connection type. 0: none; 1: mobile data; 2: wifi
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (cm != null) {
            NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = 2;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = 1;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    result = 3;
                }
            }
        }
    } else {
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) {
                // connected to the internet
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    result = 2;
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    result = 1;
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_VPN) {
                    result = 3;
                }
            }
        }
    }
    return result;
}