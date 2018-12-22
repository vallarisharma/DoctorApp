package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPrescription extends AppCompatActivity {

    FloatingActionButton FAB_add_medicine,FAB_add_test;
    ListView lv_addprescription;
    ArrayAdapter<String> aa_addprescription;
     ArrayList<String> al_new;
    Button btn_savepres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescription);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FAB_add_medicine = (FloatingActionButton) findViewById(R.id.FAB_add_medicine);
        FAB_add_test = (FloatingActionButton) findViewById(R.id.FAB_add_test);
        lv_addprescription=(ListView)findViewById(R.id.lv_addprescription);
        btn_savepres=(Button)findViewById(R.id.btn_savepres);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            ArrayList<String> myList =  bundle.getStringArrayList("mylist");
            Log.e("my list count", "" + myList.size());


            aa_addprescription = new ArrayAdapter<String>(AddPrescription.this,android.R.layout.simple_list_item_1,myList);
            lv_addprescription.setAdapter(aa_addprescription);
        }

        addNewMed();
        addNewTest();
        savePres();

    }

    private void savePres() {
        btn_savepres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddPrescription.this,OneLook.class);
                //intent.putExtra("tabNo",2);
                startActivity(intent);
            }
        });

    }

    private void addNewTest() {
        FAB_add_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AddPrescription.this,AddNewTest.class);
                startActivity(intent);
            }
        });
    }

    private void addNewMed() {
        FAB_add_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AddPrescription.this, AddMed.class);
                startActivity(intent2);
            }
        });
    }
}
