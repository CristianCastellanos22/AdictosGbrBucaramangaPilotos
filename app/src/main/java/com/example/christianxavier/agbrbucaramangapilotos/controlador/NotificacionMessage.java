package com.example.christianxavier.agbrbucaramangapilotos.controlador;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.christianxavier.agbrbucaramangapilotos.NotificaYActualiza;
import com.example.christianxavier.agbrbucaramangapilotos.R;
import com.example.christianxavier.agbrbucaramangapilotos.modelo.Notificaciones;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by christianxavier on 20/07/2017.
 */

public class NotificacionMessage extends FirebaseMessagingService {

    private final String key_evento = "url_evento";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setId(remoteMessage.getFrom());
        notificaciones.setNombre(remoteMessage.getNotification().getTitle());
        notificaciones.setContenido(remoteMessage.getNotification().getBody());
        notificaciones.setEvento(remoteMessage.getData().get(key_evento));

        notificacion(notificaciones);

    }

    private void notificacion(Notificaciones notificaciones) {

        Intent intentN = new Intent(this, NotificaYActualiza.class);
        intentN.putExtra(key_evento, notificaciones.getEvento());
        intentN.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intentN, PendingIntent.FLAG_ONE_SHOT);

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.gbr)
                .setContentTitle(notificaciones.getNombre())
                .setContentText(notificaciones.getContenido())
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSound(uri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, builder.build());
    }
}
