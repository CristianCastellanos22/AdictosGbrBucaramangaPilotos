package com.example.christianxavier.agbrbucaramangapilotos.vista;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.christianxavier.agbrbucaramangapilotos.R;
import com.example.christianxavier.agbrbucaramangapilotos.controlador.MensualidadHolder;
import com.example.christianxavier.agbrbucaramangapilotos.modelo.Mensualidad;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class VistaMensualidad extends AppCompatActivity {

    FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_mensualidad);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lsMensualidad);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomM);

        Query query = FirebaseDatabase.getInstance().getReference().child("Bucaramanga").child("MensualidadAgbr").orderByChild("codigo");

        adapter = new FirebaseRecyclerAdapter<Mensualidad,MensualidadHolder>(Mensualidad.class,R.layout.listmensualidad,MensualidadHolder.class,query) {
            @Override
            protected void populateViewHolder(MensualidadHolder viewHolder, Mensualidad model, int position) {
                viewHolder.setNombres("Nombre : " + model.getNombres());
                viewHolder.setApodo("Apodo : " + model.getApodo());
                viewHolder.setCodigo("Código : " + model.getCodigo());
                viewHolder.setEstado("Estado De Mensualidad : " + model.getEstado());
                viewHolder.setFallas(model.getFallas());
                viewHolder.setMes("Mes : " + model.getMes());
                viewHolder.setFalla1(model.getFalla1());
                viewHolder.setFalla2(model.getFalla2());
                viewHolder.setFalla3(model.getFalla3());
                viewHolder.setOtros(model.getOtros());
            }
        };

        recyclerView.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(VistaMensualidad.this,ViewPiloto.class));
                        finish();
                        break;
                    case R.id.money:
                        startActivity(new Intent(VistaMensualidad.this,VistaMensualidad.class));
                        finish();
                        break;
                    case R.id.profile:
                        startActivity(new Intent(VistaMensualidad.this,Info.class));
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.cleanup();
    }
}
