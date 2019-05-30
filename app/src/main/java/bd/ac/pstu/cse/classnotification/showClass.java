package bd.ac.pstu.cse.classnotification;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.VIBRATOR_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class showClass extends Fragment {

ImageSwitcher imgSwitchOne,imgSwitchTwo,imgSwitchThree,imgSwitchFour,imgSwitchFive,imgSwitchSix;
TextView class1,class2,class3,class4,class5,class6;
DatabaseReference databaseReference,forNotification;
public int alarmHour=0;
    TextView textView,textView1;
    int i=1,a=0;


    public showClass() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Show Classes");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_show_class, container, false);





//         Calendar calendar=Calendar.getInstance();
//        String day=DateFormat.getDateInstance().format(calendar.getTime());


        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String day1=sdf.format(new Date());
        textView=(TextView)v.findViewById(R.id.time1);
        forNotification=FirebaseDatabase.getInstance().getReference("Class");

        databaseReference=FirebaseDatabase.getInstance().getReference("Class");
        //databaseReference=FirebaseDatabase.getInstance().getReference(day1);
        class1=(TextView)v.findViewById(R.id.class1);
        class2=(TextView)v.findViewById(R.id.class2);
        class3=(TextView)v.findViewById(R.id.class3);
        class4=(TextView)v.findViewById(R.id.class4);
        class5=(TextView)v.findViewById(R.id.class5);
        class6=(TextView)v.findViewById(R.id.class6);
        imgSwitchOne=(ImageSwitcher)v.findViewById(R.id.imgs1);
        imgSwitchTwo=(ImageSwitcher)v.findViewById(R.id.imgs2);
        imgSwitchThree=(ImageSwitcher)v.findViewById(R.id.imgs3);
        imgSwitchFour=(ImageSwitcher)v.findViewById(R.id.imgs4);
        imgSwitchFive=(ImageSwitcher)v.findViewById(R.id.imgs5);
        imgSwitchSix=(ImageSwitcher)v.findViewById(R.id.imgs6);

        imgSwitchOne.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
                }
        });
        imgSwitchTwo.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        imgSwitchThree.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        imgSwitchFour.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        imgSwitchFive.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        imgSwitchSix.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

       // Data retrive




            //Calling routine class for making routine
            routine r1 = new routine();
            r1.classRoutine(0, class1, class2, class3, class4, class5, class6);


        return v;
    }

    private void classStatus(String classOne,String classTwo,String classThree,String classFour,String classFive,String classSix){


        if(classOne.equalsIgnoreCase("on")) {
            imgSwitchOne.setImageResource(R.drawable.ok);
            alarmHour=7;
        }
        else {
            imgSwitchOne.setImageResource(R.drawable.cancle);
        }
        if(classTwo.equalsIgnoreCase("on")) {
            imgSwitchTwo.setImageResource(R.drawable.ok);
            alarmHour=8;
        }
        else {
            imgSwitchTwo.setImageResource(R.drawable.cancle);
        }
        if(classThree.equalsIgnoreCase("on")) {
            imgSwitchThree.setImageResource(R.drawable.ok);
            alarmHour=9;
        }
        else {
            imgSwitchThree.setImageResource(R.drawable.cancle);
        }
        if(classFour.equalsIgnoreCase("on")) {
            imgSwitchFour.setImageResource(R.drawable.ok);
            alarmHour=10;
        }
        else {
            imgSwitchFour.setImageResource(R.drawable.cancle);
        }
        if(classFive.equalsIgnoreCase("on")) {
            imgSwitchFive.setImageResource(R.drawable.ok);
            alarmHour=11;
        }
        else {
            imgSwitchFive.setImageResource(R.drawable.cancle);
        }
        if(classSix.equalsIgnoreCase("on")) {
            imgSwitchSix.setImageResource(R.drawable.ok);
            alarmHour=13;
        }
        else {
            imgSwitchSix.setImageResource(R.drawable.cancle);
        }
    }
    public void setAlarm(){
        Calendar c=Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,alarmHour);
        c.set(Calendar.MINUTE,30);
        c.set(Calendar.SECOND,0);
        Intent intent=new Intent(getActivity(),Alarm.class);
        PendingIntent pi=PendingIntent.getBroadcast(getActivity().getApplicationContext(),1,intent,0);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        //alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+500,pi);


    }

    public void notification(){
        Intent intent=new Intent(getActivity(),notification.class);
        PendingIntent pi=PendingIntent.getBroadcast(getActivity().getApplicationContext(),0,intent,0);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5,pi);

    }


//    @Override
//    public void onStart() {
//        super.onStart();
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Toast.makeText(getContext(),"Yes",Toast.LENGTH_SHORT).show();
//                if(dataSnapshot.getValue()!=null){
//                    Toast.makeText(getContext(),"no",Toast.LENGTH_SHORT).show();
//                    Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
//                    String c1 = map.get("8-9");
//                    String c2 = map.get("9-10");
//                    String c3 = map.get("10-11");
//                    String c4 = map.get("11-12");
//                    String c5 = map.get("12-1");
//                    String c6 = map.get("2-5");
//                    classStatus(c1, c2, c3, c4, c5, c6);
//                    setAlarm();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }


    @Override
    public void onStart(){
        super.onStart();
        databaseReference.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                // textView.setText("The " + dataSnapshot.getKey() + " score is " + dataSnapshot.getValue());
                if(dataSnapshot.getValue()!=null){
                    //Toast.makeText(getContext(),"no",Toast.LENGTH_SHORT).show();
                    Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                    String c1 = map.get("8-9");
                    String c2 = map.get("9-10");
                    String c3 = map.get("10-11");
                    String c4 = map.get("11-12");
                    String c5 = map.get("12-1");
                    String c6 = map.get("2-5");
                    classStatus(c1, c2, c3, c4, c5, c6);
                   // setAlarm();
                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if(dataSnapshot.getValue()!=null){
                   // Toast.makeText(getContext(),"no",Toast.LENGTH_SHORT).show();
                    Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                    String c1 = map.get("8-9");
                    String c2 = map.get("9-10");
                    String c3 = map.get("10-11");
                    String c4 = map.get("11-12");
                    String c5 = map.get("12-1");
                    String c6 = map.get("2-5");
                    classStatus(c1, c2, c3, c4, c5, c6);
                   // notification();
                    //setAlarm();
                }
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



    }

}
