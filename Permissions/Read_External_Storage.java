private final int MULTIPLE_PERMISSIONS = 999;

// onCreate
requestPermissions();

@Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
//        Log.d(TAG, "Permissões" + requestCode + grantResults.toString());
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:
                if (grantResults.length > 0) {
                    boolean readExternalFile = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    boolean coarseLocation = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//                    boolean fineLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    if (!fineLocation || !coarseLocation || !readExternalFile) {
                    if (!readExternalFile) {
//                        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
////                        builder.setTitle(this.getResources().getString(R.string.limited_functionality_title));
//                        builder.setTitle("titulo");
////                        builder.setMessage(this.getResources().getString(R.string.limited_functionality_message));
//                        builder.setMessage("mensagem");
//                        builder.setPositiveButton(android.R.string.ok, null);
//                        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                            @Override
//                            public void onDismiss(DialogInterface dialog) {
                                requestPermissions();
//                            }
//                        });
//                        builder.show();
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(
                                new String[]{
                                        Manifest.permission.READ_EXTERNAL_STORAGE
                                }, MULTIPLE_PERMISSIONS);
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestPermissions() {
        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        int hasReadSMSPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasReadSMSPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(perms, MULTIPLE_PERMISSIONS);
            return;
        }
    }