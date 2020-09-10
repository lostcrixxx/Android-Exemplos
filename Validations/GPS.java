if(isGpsEnabled()) {
	...
}

private static final int GPS_REQUEST_CODE = 9003;   
   
   public boolean isGpsEnabled(){

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean providerEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);



        if(providerEnabled){

            return true;

        } else {

            AlertDialog alertDialogGPS = new AlertDialog.Builder(this)

                    .setTitle("GPS Desativado !")

                    .setMessage("GPS é necessário para este aplicativo funcionar. Ative o GPS !")

                    .setPositiveButton("SIM", ((dialogInterface, i) ->{

                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                        startActivityForResult(intent, GPS_REQUEST_CODE);

                    }))

                    .setCancelable(true)

                    .show();

        }

        return false;

    }



   @Override

    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {

        super.startActivityForResult(intent, requestCode, options);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean providerEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);



        if(requestCode == GPS_REQUEST_CODE){

            if(providerEnabled){

                Toast.makeText(this, "GPS ativado", Toast.LENGTH_SHORT).show();

            }

	}

}

