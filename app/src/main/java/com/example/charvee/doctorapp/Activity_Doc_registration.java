package com.example.charvee.doctorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Charvee on 6/26/2018.
 */
public class Activity_Doc_registration extends AppCompatActivity {

    int images[]={R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon,R.drawable.logouticon};
    String name[]={"A","B","C","D","E","F","G","H","I"};
    ListView listView;
    Button btn_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_registration);
        listView=(ListView)findViewById(R.id.listview);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView textView=(TextView)view.findViewById(R.id.textView);
                String namea=textView.getText().toString();
                Toast.makeText(Activity_Doc_registration.this,""+name[position]+" "+namea,Toast.LENGTH_SHORT).show();
            }
        });*/


    }


    public void display(View view) {
        final View view1=getLayoutInflater().inflate(R.layout.custom_listview,null);
        btn_view=(Button)view.findViewById(R.id.btn_view);


        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)view1.findViewById(R.id.textView);
                String namea=textView.getText().toString();
                Toast.makeText(Activity_Doc_registration.this," "+namea,Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.custom_listview,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            TextView textView=(TextView)convertView.findViewById(R.id.textView);

            imageView.setImageResource(images[position]);
            textView.setText(name[position]);
            return convertView;
        }
    }
}

