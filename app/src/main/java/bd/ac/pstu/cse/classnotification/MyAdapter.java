package bd.ac.pstu.cse.classnotification;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private ArrayList<NoticeChild> chieldlist = new ArrayList<>();

    public MyAdapter(ArrayList<NoticeChild> parentList){
        this.chieldlist=parentList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.notice_item,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        String title1=chieldlist.get(i).getTitle();
        myHolder.title.setText("Title: "+title1);
        String timea=chieldlist.get(i).getTime();
        myHolder.time.setText("Date: "+timea);
        String desc=chieldlist.get(i).getDescription();
        myHolder.description.setText(desc);
    }

    @Override
    public int getItemCount() {
        return chieldlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title,time,description;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            time=(TextView)itemView.findViewById(R.id.time);
            description=itemView.findViewById(R.id.des);
        }
    }
}
