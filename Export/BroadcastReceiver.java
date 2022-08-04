private LocalBroadcastManager mBroadcastManager = null;

// onCreate
registerBroadcastReceivers();


    protected BroadcastReceiver markSyncBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
//                Log.e(TAG, "get BroadcastReceiver");
                Bundle extras = intent.getExtras();
                String value;
                if (extras != null) {
                    value = extras.getString(MSG_KEY_MARKS_SYNC);
                    sensorsData.setText(value);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private void registerBroadcastReceivers() {
        try {
            mBroadcastManager = LocalBroadcastManager.getInstance(parent);
            mBroadcastManager.registerReceiver(markSyncBroadcastReceiver,
                    new IntentFilter(Constants.REPORT_DATA_RECEIVED_BROADCAST));
        } catch (Exception e) {
            Log.e(TAG, "ERRO registerBroadcastReceivers " + e.toString());
            e.printStackTrace();
        }
    }