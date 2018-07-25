package com.example.christianxavier.agbrbucaramangapilotos.vista;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.christianxavier.agbrbucaramangapilotos.R;
import com.example.christianxavier.agbrbucaramangapilotos.controlador.PilotoHolder;
import com.example.christianxavier.agbrbucaramangapilotos.modelo.Piloto;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ViewPiloto extends AppCompatActivity {

    FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_piloto);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lsPiloto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.BottomVi);

        Query query = FirebaseDatabase.getInstance().getReference().child("Bucaramanga").child("Agbr").orderByChild("estado");

        adapter = new FirebaseRecyclerAdapter<Piloto,PilotoHolder>(Piloto.class,R.layout.list,PilotoHolder.class, query) {
            @Override
            protected void populateViewHolder(PilotoHolder viewHolder, Piloto model, int position) {
                viewHolder.setFoto(model.getFoto());
                viewHolder.setNombres("Nombre : " + model.getNombres());
                viewHolder.setApellidos(model.getApellidos());
                viewHolder.setCc("Cédula : " + model.getCc());
                viewHolder.setApodo("Apodo : " + model.getApodo());
                viewHolder.setRh("RH : " + model.getRh());
                viewHolder.setEstado("Estado : " + model.getEstado());
                viewHolder.setCodigo("Código : " + model.getCodigo());
                viewHolder.setCelular("Celular : " + model.getCelular());
                viewHolder.setOcupacion("Ocupacion : " + model.getOcupacion());
                viewHolder.setIngreso("Ingreso : " + model.getIngreso());
                viewHolder.setCumple("Cumpleaños : " + model.getCumple());
                viewHolder.setMotivo(model.getMotivo());
                viewHolder.setMoto("Moto : " + model.getMoto());
                viewHolder.setModelo("Modelo : " + model.getModelo());
                viewHolder.setPlaca("Placa : " + model.getPlaca());
                viewHolder.setNombreContact("Nombre : " + model.getNombreContact());
                viewHolder.setCelContact("Celular : " + model.getCelContact());
            }
        };

        recyclerView.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(ViewPiloto.this,ViewPiloto.class));
                        finish();
                        break;
                    case R.id.money:
                        startActivity(new Intent(ViewPiloto.this,VistaMensualidad.class));
                        finish();
                        break;
                    case  R.id.profile:
                        startActivity(new Intent(ViewPiloto.this,Info.class));
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
