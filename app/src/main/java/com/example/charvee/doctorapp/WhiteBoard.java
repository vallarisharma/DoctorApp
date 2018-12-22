package com.example.charvee.doctorapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class WhiteBoard extends AppCompatActivity {

    Button btn_sizeUp,btn_sizeDown,btn_colorChange,btn_undo,btn_save,btn_back;
    DrawableView drawableView;
    DrawableViewConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_board);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createIds();

        config=new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);

        drawableView.setConfig(config);

        btn_sizeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                config.setStrokeWidth(config.getStrokeWidth() + 10);
            }
        });
        btn_sizeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                config.setStrokeWidth(config.getStrokeWidth()-10);
            }
        });
        btn_colorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                config.setStrokeColor(Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            }
        });
        btn_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawableView.undo();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WhiteBoard.this,Patient_History_Main.class);
                startActivity(i);
            }
        });

    }

    private void createIds() {
        drawableView=(DrawableView)findViewById(R.id.paintView);
        btn_sizeUp=(Button)findViewById(R.id.btn_sizeUp);
        btn_sizeDown=(Button)findViewById(R.id.btn_sizeDown);
        btn_colorChange=(Button)findViewById(R.id.btn_colorChange);
        btn_undo=(Button)findViewById(R.id.btn_undo);
        btn_save=(Button)findViewById(R.id.btn_save);
        btn_back=(Button)findViewById(R.id.btn_back);
    }
}
