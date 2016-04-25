package com.example.z00842877.ulbikespots;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class List extends AppCompatActivity {
    ArrayList<String> note;
    ArrayAdapter<String> noteAdapter;
    public String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //setup();
        buttons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

    private void setup(){
        note = new ArrayList<>();
        //instantiate adapter
        note.add("Visitor");
        note.add("Staff");
        note.add("Student");
        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, note);

        //attach adapter to Listview
        ListView noteListView = (ListView) findViewById(R.id.note_list_view);
        noteListView.setAdapter(noteAdapter);

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemData = note.get(position);
                Toast.makeText(parent.getContext(), "Clicked " + itemData, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), EntryScreen.class);
                if(note.get(position).equalsIgnoreCase("student")){
                    intent.putExtra("userType", "All");
                }else {
                    intent.putExtra("userType", note.get(position));
                }
                    startActivity(intent);

            }
        });
    }

    public void buttons() {
        Button button1 = (Button)findViewById(R.id.List_Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                Intent intent = new Intent(v.getContext(), EntryScreen.class);
                intent.putExtra("userType", button.getText());
                startActivity(intent);
                finish();
            }
        });

        Button button2 = (Button)findViewById(R.id.List_Button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                Intent intent = new Intent(v.getContext(), EntryScreen.class);
                intent.putExtra("userType", button.getText());
                startActivity(intent);
                finish();
            }
        });
        Button button3 = (Button)findViewById(R.id.List_Button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                Intent intent = new Intent(v.getContext(), EntryScreen.class);
                intent.putExtra("userType", button.getText());
                startActivity(intent);
                finish();
            }
        });
    }


}
