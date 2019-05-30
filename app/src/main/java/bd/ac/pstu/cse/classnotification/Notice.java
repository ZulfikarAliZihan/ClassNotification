package bd.ac.pstu.cse.classnotification;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.content.Context.ALARM_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notice extends Fragment {
RecyclerView recyclerView;
    ArrayList<NoticeChild> chieldlist = new ArrayList<>();
    DatabaseReference databaseReference,databaseReference1;
    FloatingActionButton fbtn;
    public Notice() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Notice");
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_notice, container, false);
        databaseReference=FirebaseDatabase.getInstance().getReference("notice");
        databaseReference1=FirebaseDatabase.getInstance().getReference().child("notice");
        fbtn=view.findViewById(R.id.button);
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),post_notice.class);
                startActivity(intent);
            }
        });


        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,);
       recyclerView=(RecyclerView)view.findViewById(R.id.recycle);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // NoticeChild na=new NoticeChild("this","Th","Thi");
       // NoticeChild na1=new NoticeChild("this is new","This is time","This is total description and is");
       // chieldlist.add(na);
        //chieldlist.add(na1);



databaseReference1.orderByValue().addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        NoticeChild post = dataSnapshot.getValue(NoticeChild.class);
              chieldlist.add(post);
        recyclerView.setAdapter(new MyAdapter(chieldlist));
        //Toast.makeText(getContext(), post.getTitle(), Toast.LENGTH_SHORT).show();
        //notification();

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


//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                NoticeChild post = dataSnapshot.getValue(NoticeChild.class);
//               chieldlist.add(post);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // [START_EXCLUDE]
//                Toast.makeText(getContext(), "Failed to load post.",
//                        Toast.LENGTH_SHORT).show();
//                // [END_EXCLUDE]
//            }
//        };
//        databaseReference1.child("notice").child("abc").addValueEventListener(postListener);

        return view;
    }



    public void notification(){
        Intent intent=new Intent(getActivity(),notification.class);
        PendingIntent pi=PendingIntent.getBroadcast(getActivity().getApplicationContext(),0,intent,0);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5,pi);

    }

}
