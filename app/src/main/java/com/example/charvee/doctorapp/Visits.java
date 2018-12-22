package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Visits extends AppCompatActivity {

    ListView lv_visits;
    Button btn_plogout;
    String visits[]= {"visit no.1 ", "visit no.2"};
    ArrayAdapter<String> aa_visits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);
        lv_visits=(ListView)findViewById(R.id.lv_visits);
        btn_plogout=(Button)findViewById(R.id.btn_plogout);

        aa_visits=new ArrayAdapter<String>(Visits.this,android.R.layout.simple_list_item_1,visits);
        lv_visits.setAdapter(aa_visits);



        lv_visits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Visits.this, MedandTests.class);
                startActivity(i);
            }
        });
        btn_plogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Visits.this,Seperation.class);
                startActivity(i);
            }
        });

    }
}
