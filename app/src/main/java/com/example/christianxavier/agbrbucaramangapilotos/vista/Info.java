package com.example.christianxavier.agbrbucaramangapilotos.vista;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.christianxavier.agbrbucaramangapilotos.Emergencias;
import com.example.christianxavier.agbrbucaramangapilotos.NotificaYActualiza;
import com.example.christianxavier.agbrbucaramangapilotos.R;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Info extends AppCompatActivity {

    private TextView tvName,tvId;
    private ImageView imageView;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvName = (TextView)findViewById(R.id.nameInfo);
        tvId = (TextView)findViewById(R.id.idInfo);
        imageView = (ImageView)findViewById(R.id.imagInfo);
        btnCerrar = (Button)findViewById(R.id.btnCerrar);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String nombre=user.getDisplayName(),id=user.getUid();

        tvName.setText("Nombre de Usuario : " + nombre);
        tvId.setText("Identificador : " + id);

        Profile profile = com.facebook.Profile.getCurrentProfile();
        Uri uri = profile.getProfilePictureUri(250,250);
        Glide.with(Info.this).load(uri).into(imageView);

        BottomNavigationView bottomNavigationView =(BottomNavigationView)findViewById(R.id.bottomInfo);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(Info.this,ViewPiloto.class));
                        finish();
                        break;
                    case R.id.contact:
                        startActivity(new Intent(Info.this, Emergencias.class));
                        finish();
                        break;
                    case R.id.evento:
                        startActivity(new Intent(Info.this, NotificaYActualiza.class));
                        break;
                }
                return true;
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                finish();
            }
        });
    }
}
