package com.challenge.prishtinaexplorer;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Prishtina and move the camera
        LatLng prishtina = new LatLng(42.6611862, 21.1612116);

        LatLng newborn = new LatLng(42.6609072, 21.158417);
        mMap.addMarker(new MarkerOptions().position(newborn).title("NEWBORN"));

        LatLng cathedral = new LatLng(42.6623228, 21.1569929);
        mMap.addMarker(new MarkerOptions().position(cathedral).title("Mother Teresa Cathedral"));

        LatLng germia = new LatLng(42.677873, 21.2083975);
        mMap.addMarker(new MarkerOptions().position(germia).title("Gërmia Park"));

        LatLng library = new LatLng(42.6702803, 21.1458493);
        mMap.addMarker(new MarkerOptions().position(library).title("The National Library of Kosovo \"Pjetër Bogdani\""));

        LatLng billClinton = new LatLng(42.6534546, 21.1520834);
        mMap.addMarker(new MarkerOptions().position(billClinton).title("Statue of Bill Clinton"));

        LatLng museum = new LatLng(42.666891, 21.1568192);
        mMap.addMarker(new MarkerOptions().position(museum).title("Kosovo Museum"));

        LatLng gallery = new LatLng(42.6570673,21.161722);
        mMap.addMarker(new MarkerOptions().position(gallery).title("The National Gallery of Kosovo"));

        LatLng ethnoMuseum = new LatLng(42.6686568,21.1657813);
        mMap.addMarker(new MarkerOptions().position(ethnoMuseum).title("Ethnographic Museum"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(newborn));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(prishtina, 13.0f));
    }
}