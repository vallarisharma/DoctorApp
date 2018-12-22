package com.example.charvee.doctorapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddNewTest extends AppCompatActivity {

    EditText edit_testName;
    EditText edit_testRef;
    FloatingActionButton FAB_add_test;
    ListView list_test;
    ArrayList<String> arrayList_AddTest;
    ArrayAdapter<String> adapter_AddTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_test);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edit_testName =(EditText) findViewById(R.id.edit_testName);
        edit_testRef =(EditText) findViewById(R.id.edit_testRef);
        FAB_add_test = (FloatingActionButton)findViewById(R.id.FAB_add_test);
        list_test =(ListView) findViewById(R.id.list_test);

        arrayList_AddTest =new ArrayList<String >();
        adapter_AddTest = new ArrayAdapter<String>(AddNewTest.this,android.R.layout.simple_list_item_1,arrayList_AddTest){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
                return view;
            }
        };
        list_test.setAdapter(adapter_AddTest);

        addToList();

    }

    public void addToList(){
        FAB_add_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result_a = edit_testName.getText().toString();
                String result_b = edit_testRef.getText().toString();
                String result = result_a+" from "+result_b;
                arrayList_AddTest.add(result);
                adapter_AddTest.notifyDataSetChanged();
            }
        });
    }
}
