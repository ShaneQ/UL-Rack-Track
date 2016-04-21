package com.example.z00842877.ulbikespots;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;


public class EntryScreen extends AppCompatActivity {


    MapFragment mMapFragment;
    ArrayList<Parking> parkingspots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen);
        createHashSet();

        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();
        /*
        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(52.66136550517293, -8.624267575625026))
                        .title("Limerick")
                        .snippet("Come here for the craic!"));
                googleMap.moveCamera(CameraUpdateFactory
                        .newLatLngZoom(new LatLng(52.66136550517293, -8.624267575625026), 7));
            }
        });
        */

        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                for( Parking x : parkingspots) {
                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(x.getLatitude(), x.getLongitude()))
                            .title(x.getLocation())
                            .snippet("Suits "+ x.getUserType()+" Users"));
                    googleMap.moveCamera(CameraUpdateFactory
                            .newLatLngZoom(new LatLng(52.67514489282713, -8.571814621734575), 15));
                }
            }
        });


    }

    public void createHashSet(){
        parkingspots = new ArrayList<>();
        parkingspots.add(new Parking("KBS Back","ALL",52.67246556,-8.577017782,false,false,true));
        parkingspots.add(new Parking("KBS Front","ALL",52.67272578,-8.577339647,false,false,true));
        parkingspots.add(new Parking("CSIS Carpark","ALL",52.67436516,-8.575156329,false,false,false));
        parkingspots.add(new Parking("Foundation Carpark","STAFF",52.67457334,-8.57491493,true,true,true));
        parkingspots.add(new Parking("ERG Carpark","STAFF",52.67542553,-8.573032019,true,true,true));
        parkingspots.add(new Parking("Stokes Research Institute","ALL",52.67484005,-8.572710154,true,false,true));
        parkingspots.add(new Parking("Library Entrance","ALL",52.67338284,-8.573176858,false,false,true));
        parkingspots.add(new Parking("Sundial","ALL",52.6733308,-8.571438787,false,false,false));
        parkingspots.add(new Parking("Visitor Carpark","VISITOR",52.67302178,-8.571642635,false,false,false));
        parkingspots.add(new Parking("Student Union","ALL",52.67332755,-8.570135233,true,false,false));
        parkingspots.add(new Parking("Analog Devices","ALL",52.67306732,-8.568869231,false,false,false));
        parkingspots.add(new Parking("Arena Carpark","ALL",52.6728689,-8.56509268,true,false,true));
        parkingspots.add(new Parking("Arena","ALL",52.67326249,-8.564985392,false,false,true));
        parkingspots.add(new Parking("PESS","ALL",52.67442209,-8.568005559,false,false,true));
        parkingspots.add(new Parking("Health Sciences","ALL",52.67766814,-8.569266198,false,false,true));
        parkingspots.add(new Parking("Irish World Academy","ALL",52.67823081,-8.569700715,false,false,true));
        parkingspots.add(new Parking("Graduate Medical School","ALL",52.67823406,-8.568080661,false,false,true));
        parkingspots.add(new Parking("Pavillion","ALL",52.67872517,-8.569867012,false,false,true));
        parkingspots.add(new Parking("Schuman","ALL",52.67356012,-8.577715156,false,false,true));


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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
