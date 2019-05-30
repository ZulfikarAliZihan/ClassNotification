package bd.ac.pstu.cse.classnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class notification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(700);
        Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show();
        makeNotification(context);

    }

    private void makeNotification(Context context){
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        showClass showClass1=new showClass();
        Intent intent=new Intent(context,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,(int)System.currentTimeMillis(),intent,0);

        Notification notice=new Notification.Builder(context).
                setSmallIcon(R.drawable.ic_launcher_background).
                setContentTitle("Updates").
                setContentText("You have a new class update.").
                setAutoCancel(true).
                setContentIntent(pendingIntent).
                build();
        notificationManager.notify(1,notice);

    }
}
