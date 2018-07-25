package com.example.christianxavier.agbrbucaramangapilotos.modelo;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by christianxavier on 19/07/2017.
 */

public class Persistencia extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
