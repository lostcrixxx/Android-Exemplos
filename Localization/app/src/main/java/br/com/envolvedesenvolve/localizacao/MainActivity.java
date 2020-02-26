package br.com.envolvedesenvolve.localizacao;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView t;
    private LocationManager locationManager;
    private LocationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.textView);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                t.append("\n " + location.getLongitude() + " " + location.getLatitude());
                //Log.i("localizacao","Enviado");
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };


        verificaGPS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                verificaGPS();
                break;
            default:
                break;
        }
    }

    void verificaGPS() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }

        locationManager.requestLocationUpdates("gps", 10000, 0, listener);
    }
	
	private LatLng myLocation(GoogleMap mMap){
        LatLng point;
        Location myLocation = mMap.getMyLocation();
//        Log.e("location", "Localização Lat " + myLocation.getLatitude() + " Lng " + myLocation.getLongitude());

        return point = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
    }
	
	private void polyLine(){
		            ArrayList<LatLng> directionPositionList = new ArrayList<>();

            directionPositionList.add(new LatLng(-9.802749, -48.572226));
            directionPositionList.add(new LatLng(-9.801639, -48.569049));
            directionPositionList.add(new LatLng(-9.801179, -48.566720));
            directionPositionList.add(new LatLng(-9.799868, -48.563180));
            directionPositionList.add(new LatLng(-9.798448, -48.560857));
            directionPositionList.add(new LatLng(-9.798138, -48.560346));
            directionPositionList.add(new LatLng(-9.796958, -48.558412));
            directionPositionList.add(new LatLng(-9.796523, -48.557701));
            directionPositionList.add(new LatLng(-9.793447, -48.554541));
            directionPositionList.add(new LatLng(-9.791401, -48.553141));
            directionPositionList.add(new LatLng(-9.791248, -48.553035));
            directionPositionList.add(new LatLng(-9.791198, -48.553001));
            directionPositionList.add(new LatLng(-9.790976, -48.552847));
            directionPositionList.add(new LatLng(-9.790668, -48.552642));

            PolylineOptions polylineOptions = DirectionConverter.createPolyline(getBaseContext(), directionPositionList, 5, Color.RED);
            mMap.addPolyline(polylineOptions);

            centralizeCamera(directionPositionList.get(0));
            updateZoomCamera(15.0f);
	}
}


