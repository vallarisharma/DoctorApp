package com.example.charvee.doctorapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class SearchPatient extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button btn_selectDate;
    int year,month,day;
    TextView tv_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);

        btn_selectDate=(Button)findViewById(R.id.btn_selectDate);
        tv_date=(TextView)findViewById(R.id.tv_date);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String date = day + "/" + (month) + "/" + year;
        tv_date.setText(date);
        btn_selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }
    @Deprecated
    protected Dialog onCreateDialog(int id) {

        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            day = selectedDay;
            month = selectedMonth;
            year = selectedYear;
            tv_date.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
