package com.example.notificacoes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class NotificationUtils extends ContextWrapper {

    private NotificationManager notificationManager;

    String DEFAULT_CHANNEL_ID = "DEFAULT";

    String DEFAULT_CHANNEL_NAME = "DEFAULT CHANNEL";

    String pkgName = "notification.channel";


    public NotificationUtils(Context context) {
        super(context);
        pkgName = context.getPackageName() != null ? context.getPackageName() : pkgName;
        DEFAULT_CHANNEL_ID = pkgName + "." + DEFAULT_CHANNEL_ID.toUpperCase();
        createChannel(DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME);
    }

    public void createChannel(String CHANNEL_ID, String CHANNEL_NAME) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // criar canal android
            NotificationChannel newChannel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            // Define se as notificações enviadas para este canal devem exibir luzes de notificação
            newChannel.enableLights(true);
            // Define se a notificação postada neste canal deve vibrar.
            newChannel.enableVibration(true);
            // Define a cor da luz de notificação para notificações postadas neste canal
            newChannel.setLightColor(Color.GREEN);
            // Define se as notificações postadas neste canal aparecem na tela de bloqueio ou não
            newChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            getNotificationManager().createNotificationChannel(newChannel);
        }
    }

    private NotificationManager getNotificationManager() {
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public void sendNotificationInChannel(int notificationId, Intent resultIntent,
            NotificationCompat.Builder builder) {
        PendingIntent pi = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent
                .FLAG_UPDATE_CURRENT);

        // para a ação de clique de notificação, também necessária no Gingerbread(Android 2.3) e abaixo
        builder.setContentIntent(pi);

        getNotificationManager().notify(notificationId, builder.build());
    }

    public void sendNotificationInDefaultChannel(String title, String body, int notificationId) {
        Intent resultIntent = new Intent(this, MainActivity.class);
        sendNotificationInChannel(notificationId, resultIntent,
                getDefaultNotificationBuilder(title, body, DEFAULT_CHANNEL_ID));
    }


    public void sendBigNotificationInDefaultChannel(String title, String body, int notificationId) {
        Intent resultIntent = new Intent(this, MainActivity.class);
        NotificationCompat.Builder builder = getDefaultNotificationBuilder(title, body, DEFAULT_CHANNEL_ID);
        builder = convertToBigNotificationBuilder(builder);
        sendNotificationInChannel(notificationId, resultIntent, builder);
    }


    private NotificationCompat.Builder getDefaultNotificationBuilder(String title, String body, String
            channelId) {
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        return new NotificationCompat.Builder(getApplicationContext(),
                channelId)
                // set title
                .setContentTitle(title)
                // set body
                .setContentText(body)
                // set ticker
                .setTicker("Notificações")
                // set notification sound
                .setSound(defaultSoundUri)
                // set small icon
                .setSmallIcon(android.R.drawable.stat_notify_more)
                // definir o comportamento de cancelamento automático
                .setAutoCancel(true);
    }


    private NotificationCompat.Builder convertToBigNotificationBuilder(NotificationCompat.Builder builder) {
        /* Adicionar configuração específica de visualização grande */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = "1ª linha...";
        events[1] = "2ª linha...";
        events[2] = "3ª linha...";
        events[3] = "4ª linha...";
        events[4] = "5ª linha...";
        events[5] = "6ª linha...";

        // Define um título para a exibição grande do estilo da Caixa de entrada
        inboxStyle.setBigContentTitle("Big detalhes:");

        // Move os eventos para a grande exibição
        for (final String event : events) {
            inboxStyle.addLine(event);
        }

        builder.setStyle(inboxStyle);
        return builder;
    }
}

