package com.example.charvee.doctorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OneLook extends AppCompatActivity {
    String arrayList_FinalMed[]={"med1","med2","med3"};
    ArrayAdapter<String> adapter_FinalMed;
    ListView lv_to_eat_med;
    String arrayList_FinalTest[]={"test1","test2"};
    ArrayAdapter<String> Adapter_FinalTest;
    ListView lv_to_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_look);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lv_to_eat_med = (ListView) findViewById(R.id.lv_to_eat_med);
        lv_to_test = (ListView) findViewById(R.id.lv_to_test);

        adapter_FinalMed = new ArrayAdapter<String>(OneLook.this, android.R.layout.simple_list_item_1, arrayList_FinalMed) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                return view;
            }
        };
        Adapter_FinalTest = new ArrayAdapter<String>(OneLook.this, android.R.layout.simple_list_item_1, arrayList_FinalTest) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                return view;
            }
        };
        lv_to_eat_med.setAdapter(adapter_FinalMed);
        lv_to_test.setAdapter(Adapter_FinalTest);
    }
}
