package com.example.christianxavier.agbrbucaramangapilotos;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.christianxavier.agbrbucaramangapilotos.vista.Info;
import com.example.christianxavier.agbrbucaramangapilotos.vista.ViewPiloto;
import com.example.christianxavier.agbrbucaramangapilotos.vista.VistaMensualidad;

public class Emergencias extends AppCompatActivity {

    TextView cruz,civil,bomberos,policia,carretera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencias);

        cruz = (TextView)findViewById(R.id.cruz);
        civil = (TextView)findViewById(R.id.civil);
        bomberos = (TextView)findViewById(R.id.bomberos);
        policia = (TextView)findViewById(R.id.policia);
        carretera = (TextView)findViewById(R.id.carreteras);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomEm);

        cruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:132")); //
                startActivity(i);
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:144")); //
                startActivity(i);
            }
        });

        bomberos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:119")); //
                startActivity(i);
            }
        });

        policia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:123")); //
                startActivity(i);
            }
        });

        carretera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:#767")); //
                startActivity(i);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(Emergencias.this, ViewPiloto.class));
                        finish();
                        break;
                    case R.id.money:
                        startActivity(new Intent(Emergencias.this, VistaMensualidad.class));
                        finish();
                        break;
                    case R.id.profile:
                        startActivity(new Intent(Emergencias.this,Info.class));
                        finish();
                        break;
                }
                return true;
            }
        });
    }
}
