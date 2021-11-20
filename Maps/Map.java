public class MapFragment extends Fragment implements OnMapReadyCallback {

    public static MapFragment Instance = null;

    private GoogleMap mMap;

    public static MapFragment getInstance() {
        if (Instance == null)
            Instance = new MapFragment();
        return Instance;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapView mapView = view.findViewById(R.id.map);

        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }
    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mMap = googleMap;
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.map_style));

        LatLng position01 = new LatLng(, );
        LatLng position02 = new LatLng(, );
        centerCamera(position01);

        mMap.addMarker(new MarkerOptions().title("Position 01").position(position01)).showInfoWindow();
        mMap.addMarker(new MarkerOptions().title("Position 02").position(position02)).showInfoWindow();

    }

    private void centerCamera(LatLng point){
        if(point != null && point.latitude != 0 && point.longitude !=0){
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(point.latitude, point.longitude), 17.0f), 1000, null);
        }
    }
}