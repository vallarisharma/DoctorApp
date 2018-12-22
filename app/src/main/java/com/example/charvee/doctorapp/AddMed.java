package com.example.charvee.doctorapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AddMed extends AppCompatActivity {
    EditText edit_medName,edit_precautions;
    RadioGroup radio_gp;
    RadioButton radio_1;
    RadioButton radio_2;
    RadioButton radio_half;
    CheckBox chk_breakfast;
    CheckBox chk_lunch;
    CheckBox chk_dinner;
    FloatingActionButton FAB_add_med;
    ArrayList<String> arrayList_AddMed;
    ArrayAdapter<String> adapter_AddMed;
    ListView list_med;
    Button btn_savemed;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        edit_medName=(EditText) findViewById(R.id.edit_medName);
        edit_precautions=(EditText) findViewById(R.id.edit_precautions);
        radio_gp =(RadioGroup) findViewById(R.id.radio_gp);
        radio_1 = (RadioButton) findViewById(R.id.radio_1);
        radio_2 = (RadioButton) findViewById(R.id.radio_2);
        chk_breakfast =(CheckBox) findViewById(R.id.chk_breakfast);
        chk_lunch = (CheckBox) findViewById(R.id.chk_lunch);
        chk_dinner = (CheckBox)findViewById(R.id.chk_dinner);
        radio_half = (RadioButton) findViewById(R.id.radio_half);
        FAB_add_med =(FloatingActionButton) findViewById(R.id.FAB_add_med);
        list_med = (ListView) findViewById(R.id.list_med);
        btn_savemed=(Button)findViewById(R.id.btn_savemed);

        arrayList_AddMed = new ArrayList<String>();
        //arrayList_AddMed.add("kdmkdk");
        adapter_AddMed = new ArrayAdapter<String>(AddMed.this,android.R.layout.simple_list_item_1,arrayList_AddMed) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                return view;
            }
        };

        list_med.setAdapter(adapter_AddMed);
        addToList();
        btn_savemed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddMed.this,AddPrescription.class);
                intent.putExtra("mylist", arrayList_AddMed);
                startActivity(intent);
            }
        });

    }

    private void addToList() {
        FAB_add_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = "";
                i++;
                if (radio_1.isChecked()) {
                    result = i + ") Take 1 dose each of ";
                }
                if (radio_2.isChecked()) {
                    result = i + ") Take 2 doses each of ";
                }
                if (radio_half.isChecked()) {
                    result = i + ") Take half dose each of ";
                }
                String result_a = edit_medName.getText().toString();
                result = result + result_a;
                if (chk_breakfast.isChecked()) {
                    result = result + " breakfast";
                }
                if (chk_lunch.isChecked()) {
                    result = result + ", lunch ";
                }
                if (chk_dinner.isChecked()) {
                    result = result + ", dinner ";
                }
                String result_b = edit_precautions.getText().toString();
                if (!result_b.matches(""))
                    result = result + "with precaution: " + result_b;
                arrayList_AddMed.add(result);
                adapter_AddMed.notifyDataSetChanged();
            }
        });
    }


}
