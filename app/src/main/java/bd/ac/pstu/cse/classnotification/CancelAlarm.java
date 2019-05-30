package bd.ac.pstu.cse.classnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CancelAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_alarm);
        Alarm alarm=new Alarm();
        alarm.player.stop();
    }
}
