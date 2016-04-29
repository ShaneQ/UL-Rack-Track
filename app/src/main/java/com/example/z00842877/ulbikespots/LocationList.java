package com.example.z00842877.ulbikespots;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

import icepick.Icepick;
import icepick.State;


public class LocationList extends AppCompatActivity {
    ArrayList<String> note;
    ArrayAdapter<String> noteAdapter;
    @State public String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        setup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location_list, menu);
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
            Intent intent = new Intent(this, MapScreen.class);
            intent.putExtra("userType", userType);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setup(){
        note = new ArrayList<>();
        //instantiate adapter
        ParkingSet test = new ParkingSet();
        HashSet<Parking> parkingspots = test.parkingspots;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userType = extras.getString("userType");
            for (Parking x : parkingspots) {
                if (x.getUserType().equalsIgnoreCase(userType) || x.getUserType().equalsIgnoreCase("ALL")) {
                    note.add(x.getBuildingName());
                }
            }
        }
        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, note);

        //attach adapter to Listview
        ListView noteListView = (ListView) findViewById(R.id.note_list_view);
        noteListView.setAdapter(noteAdapter);

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemData = note.get(position);
                Toast.makeText(parent.getContext(), "Clicked " + itemData, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MapScreen.class);
                intent.putExtra("buildingName", note.get(position));
                intent.putExtra("userType", userType);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}
