package bd.ac.pstu.cse.classnotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MyService extends Service {
   DatabaseReference databaseReference,forNotice;
showClass showClassObj=new showClass();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        databaseReference=FirebaseDatabase.getInstance().getReference("Class");
        forNotice=FirebaseDatabase.getInstance().getReference("notice");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //onTaskRemoved(intent);
       databaseReference.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               notification();
               //notice();
               //showClassObj.setAlarm();
               //setAlarm();
           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


        forNotice.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               //notice();
               notification();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public void notification(){
        Intent intent=new Intent(getApplicationContext(),notification.class);
        PendingIntent pi=PendingIntent.getBroadcast(getApplicationContext().getApplicationContext(),0,intent,0);
        AlarmManager alarmManager= (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pi);

    }


    public void notice(){
        Intent intent=new Intent(getApplicationContext(),noticenotify.class);
        PendingIntent pi=PendingIntent.getBroadcast(getApplicationContext().getApplicationContext(),10,intent,0);
        AlarmManager alarmManager= (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pi);

    }




    public void setAlarm() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, showClassObj.alarmHour);
        c.set(Calendar.MINUTE, 30);
        c.set(Calendar.SECOND, 0);
        Intent intent = new Intent(getApplicationContext(), Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+8000, pi);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent){
        Intent intent=new Intent(getApplicationContext(),getClass());
        //restartServiceIntent.setPackege(getPackageName());
        startService(intent);
        super.onTaskRemoved(rootIntent);
    }
}
