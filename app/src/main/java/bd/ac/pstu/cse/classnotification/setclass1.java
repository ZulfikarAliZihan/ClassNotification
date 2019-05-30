package bd.ac.pstu.cse.classnotification;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static android.content.Context.ALARM_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */

//Shared preference work still to be done
public class setclass1 extends Fragment {
    Button confirmBtn,set;
    Switch switch8_9,switch9_10,switch10_11,switch11_12,switch12_1,switch2_5;
    DatabaseReference databaseReference,forNotification;
    final HashMap<String, String> classData=new HashMap<String, String>();
    TextView class1s,class2s,class3s,class4s,class5s,class6s,textView11;
    routine rtn=new routine();

    public setclass1() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Set Classes");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.setclass1, container, false);


        //Mycode
//        Calendar calendar=Calendar.getInstance();
//        calendar.add(Calendar.DATE,1);
//        Date day11=calendar.getTime();
//
//        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//        String day1=sdf.format(day11);

        //String day11=DateFormat.getDateInstance().format(calendar.getTime());
        textView11=(TextView)v.findViewById(R.id.textView1);
        //textView11.setText(day1.toString());



        class1s=(TextView)v.findViewById(R.id.class1set);
        class2s=(TextView)v.findViewById(R.id.class2set);
        class3s=(TextView)v.findViewById(R.id.class3set);
        class4s=(TextView)v.findViewById(R.id.class4set);
        class5s=(TextView)v.findViewById(R.id.class5set);
        class6s=(TextView)v.findViewById(R.id.class6set);

        switch8_9=(Switch)v.findViewById(R.id.switch1);
        switch9_10=(Switch)v.findViewById(R.id.switch2);
        switch10_11=(Switch)v.findViewById(R.id.switch3);
        switch11_12=(Switch)v.findViewById(R.id.switch4);
        switch12_1=(Switch)v.findViewById(R.id.switch5);
        switch2_5=(Switch)v.findViewById(R.id.switch6);
        confirmBtn=(Button)v.findViewById(R.id.confirn);
        //databaseReference=FirebaseDatabase.getInstance().getReference();

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        final String day1=sdf.format(new Date());
        databaseReference=FirebaseDatabase.getInstance().getReference("Class");
        forNotification=FirebaseDatabase.getInstance().getReference();

        changeClassStates();
        switch8_9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch8_9.isChecked()){
                    state="on";
                    classData.put("8-9", state);
                }
            }
        });

        switch9_10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch9_10.isChecked()){
                    state="on";
                    classData.put("9-10", state);
                }
            }
        });

        switch10_11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch10_11.isChecked()){
                    state="on";
                    classData.put("10-11", state);
                }
            }
        });

        switch11_12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch11_12.isChecked()){
                    state="on";
                    classData.put("11-12", state);
                }
            }
        });
        switch12_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch12_1.isChecked()){
                    state="on";
                    classData.put("12-1", state);
                }
            }
        });

        switch2_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state="off";
                if(switch2_5.isChecked()){
                    state="on";
                    classData.put("2-5", state);
                }
            }
        });

        //Switch check complete

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
//                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//                    String day1=sdf.format(new Date());

//                    Calendar calendar=Calendar.getInstance();
//                    calendar.add(Calendar.DATE,1);
//                    Date day11=calendar.getTime();
//                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//                    String day1=sdf.format(day11);
                    //String id=databaseReference.push().getKey();
                   databaseReference.child(day1).setValue(classData);
                    //databaseReference.setValue(classData);
                    //setAlarm1();

                    showClass Sclass=new showClass();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main1, Sclass,Sclass.getTag());
                    ft.addToBackStack(null);
                    ft.commit();


                }
                catch (Exception e){}

            }
        });

        rtn.classRoutine(0,class1s,class2s,class3s,class4s,class5s,class6s);

        return v;
    }

    //necessary method (user defined)
    private void changeClassStates(){
        String state="off";
        classData.put("8-9", state);
        classData.put("9-10", state);
        classData.put("10-11", state);
        classData.put("11-12", state);
        classData.put("12-1", state);
        classData.put("2-5", state);

    }


    public void setAlarm1(){
        Intent intent=new Intent(getActivity(),Alarm.class);
        PendingIntent pi=PendingIntent.getBroadcast(getActivity().getApplicationContext(),0,intent,0);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+50,pi);

    }

    public void notification(){
        Intent intent=new Intent(getActivity(),notification.class);
        PendingIntent pi=PendingIntent.getBroadcast(getActivity().getApplicationContext(),0,intent,0);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5,pi);

    }


}
