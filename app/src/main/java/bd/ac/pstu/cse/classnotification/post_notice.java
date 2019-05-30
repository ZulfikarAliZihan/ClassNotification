package bd.ac.pstu.cse.classnotification;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class post_notice extends AppCompatActivity {
Button postBtn;
EditText title,desc;
    DatabaseReference forNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_notice);



        forNotification=FirebaseDatabase.getInstance().getReference();
        postBtn=(Button)findViewById(R.id.button);
        title=(EditText) findViewById(R.id.title);
        desc=(EditText)findViewById(R.id.desc);
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().trim().length() > 0 && desc.getText().toString().trim().length()>0){
                    String title1=title.getText().toString();
                    String desc1=desc.getText().toString();

          Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date day11=calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String day1=sdf.format(day11);

                    NoticeChild na=new NoticeChild(title1,desc1,day1);
                    forNotification.child("notice").push().setValue(na);
                    Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
