package wen.hackthon.com.wen;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //    GPSTracker gps;
    private LatLng currentLatlong;
    private LatLngBounds bounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
        addMarkers();
    }

    public void addMarkers() {
        ArrayList<MarkerData> markersArray = new ArrayList<MarkerData>();


        MarkerData md1 = new MarkerData(17.421972, 78.338536, "driven cafe");
        MarkerData md2 = new MarkerData(17.424381, 78.487485, "Marriott hotel");
        MarkerData md3 = new MarkerData(17.423738, 78.462145, "the Park");
        MarkerData md4 = new MarkerData(17.437534, 78.444388, "maitri vanam");
        MarkerData md5 = new MarkerData(17.438164, 78.449853, "Satyam Theater");
        markersArray.add(md1);
        markersArray.add(md2);
        markersArray.add(md3);
        markersArray.add(md4);
        markersArray.add(md5);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (int i = 0; i < markersArray.size(); i++) {

            Marker markar = createMarker(markersArray.get(i).getLatit(), markersArray.get(i).getLongit(), markersArray.get(i).getTitle());
//            mMap.addMarker(markars);


            builder.include(markar.getPosition());

            bounds = builder.build();
        }

//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        LatLng currentloc = new LatLng(markersArray.get(0).getLatit(), markersArray.get(0).getLongit());


//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentloc, 50));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentloc));


        if (bounds != null) {
            int width = getResources().getDisplayMetrics().widthPixels;
            int height = getResources().getDisplayMetrics().heightPixels;
            int padding = (int) (width * 0.10);
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

            mMap.animateCamera(cu);

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
            {

                @Override
                public boolean onMarkerClick(Marker arg0) {
//                    if(arg0.getTitle().equals("MyHome")) // if marker source is clicked
                        Toast.makeText(getApplicationContext(), arg0.getTitle(), Toast.LENGTH_SHORT).show();// display toast
                    return true;
                }

            });
        }
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng))));

// Setting the zoom level in the map on last position is clicked
//        googleMap.animateCamera(CameraUpdateFactory.zoomTo(Float.parseFloat(zoom)));
//    }

    }


    protected Marker createMarker(double latitude, double longitude, String title) {

        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title));
    }
}

