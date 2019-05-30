package bd.ac.pstu.cse.classnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Alarm extends BroadcastReceiver {
   MediaPlayer player;

    @Override
    public void onReceive(Context context, Intent intent) {
       Vibrator vibrator=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
       vibrator.vibrate(500);

        player= MediaPlayer.create(context, R.raw.alarm);
        player.start();

        makeNotification(context);

    }

    private void makeNotification(Context context){
    NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

    showClass showClass1=new showClass();
    Intent intent=new Intent(context,CancelAlarm.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,(int)System.currentTimeMillis(),intent,0);


    Notification notice=new Notification.Builder(context).
            setSmallIcon(R.drawable.ic_launcher_background).
            setContentTitle("You have a class after 30 minutes").
            setContentText("Click to stop alarm").
            setAutoCancel(true).
            setContentIntent(pendingIntent).
            build();
        notificationManager.notify(0,notice);

}

//public void settime(Context context){
//
//        Intent t=new Intent(AlarmClock.ACTION_SET_ALARM);
//        t.putExtra(AlarmClock.EXTRA_HOUR,7);
//        t.putExtra(AlarmClock.EXTRA_MINUTES,52);
//        context.startActivity(t);
//}


}
