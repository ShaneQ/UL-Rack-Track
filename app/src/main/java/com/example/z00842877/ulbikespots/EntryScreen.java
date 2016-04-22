package com.example.z00842877.ulbikespots;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;

import icepick.Icepick;
import icepick.State;


public class EntryScreen extends AppCompatActivity {

    //@State
    public String userType;
    private MapFragment mMapFragment;
    public HashSet<Parking> parkingspots;
    private HashSet<Parking> tempParkingSpots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_entry_screen);
        ParkingSet test = new ParkingSet();
        parkingspots = test.parkingspots;
        specifyHashSet();
        initilaiseMap();
        buttons();

    }

    public void specifyHashSet(){
        tempParkingSpots = new HashSet<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userType = extras.getString("userType");
            for(Parking x : parkingspots){
                if(x.getUserType().equalsIgnoreCase(userType) || x.getUserType().equalsIgnoreCase("ALL")){
                    tempParkingSpots.add(x);
                }
            }
            String buildingName = extras.getString("buildingName");
            String featureType = extras.getString("featureType");
            HashSet<Parking> tempRemove =new  HashSet<>();
            if(featureType != null) {
                if (featureType.equalsIgnoreCase("Shower")) {
                    for (Parking x : tempParkingSpots) {
                        if (!x.hasShower()) {
                            tempRemove.add(x);
                        }
                    }
                } else if (featureType.equalsIgnoreCase("Coverage")) {
                    for (Parking x : tempParkingSpots) {
                        if (!x.isCovered()) {
                            tempRemove.add(x);
                        }
                    }
                } else if (featureType.equalsIgnoreCase("Secure")) {
                    for (Parking x : tempParkingSpots) {
                        if (!x.isSecure()) {
                            tempRemove.add(x);
                        }
                    }
                }
            }  else if(buildingName != null) {
                for (Parking x : tempParkingSpots) {
                    if (!x.getBuildingName().equalsIgnoreCase(buildingName)) {
                        tempRemove.add(x);
                    }
                }
            }
            tempParkingSpots.removeAll(tempRemove);
        }else{
            tempParkingSpots = parkingspots;
        }

    }


    public void initilaiseMap(){
        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();

        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                for (Parking x : tempParkingSpots) {
                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(x.getLatitude(), x.getLongitude()))
                            .title(x.getLocation())
                            .snippet(x.toString())
                            .icon(BitmapDescriptorFactory.defaultMarker(x.getColor())));
                }
                googleMap.moveCamera(CameraUpdateFactory
                        .newLatLngZoom(new LatLng(52.67514489282713, -8.571814621734575), 15));
            }
        });
    }
    public void buttons() {
        Button buttonNext = (Button)findViewById(R.id.but1);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FeatureList.class);
                intent.putExtra("userType", userType);
                startActivity(intent);
            }
        });

        Button buttonBut2 = (Button)findViewById(R.id.but2);
        buttonBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BuildingList.class);
                intent.putExtra("userType", userType);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, List.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

}
