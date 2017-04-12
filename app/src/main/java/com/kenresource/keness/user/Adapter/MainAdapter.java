package com.kenresource.keness.user.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kenresource.keness.user.Model.MainModel;
import com.kenresource.keness.user.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by suchismita on 3/4/2017.
 */

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.MyViewHolder> {

private final Context context;
private List<MainModel> listModel;
    public MainAdapter(Context context, List<MainModel> items) {

        this.context = context;
        this.listModel =items;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView username,date,time, desg, desc;
        CircleImageView profilepic;
        ImageView image;


        public MyViewHolder(View view)

        {
            super(view);
            date=(TextView)view.findViewById(R.id.text_time);
            username=(TextView)view.findViewById(R.id.text_name);
            desg = (TextView)view.findViewById(R.id.text_person_designation);
            time=(TextView)view.findViewById(R.id.text_person_designation);
            desc=(TextView)view.findViewById(R.id.text_person_designation);
            profilepic=(CircleImageView) view.findViewById(R.id.profilePic);
            image= (ImageView)view.findViewById(R.id.content_image);
        }
    }


    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_home, parent, false);

        return new MainAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MainAdapter.MyViewHolder holder, final int position) {
        MainModel album = listModel.get(position);
//        holder.date.setText(album.getPostingdate());
//        holder.username.setText(album.getUsername());
//        holder.desc.setText(album.getDescription());
//        holder.desg.setText(album.getDesignation());
//        holder.time.setText(album.getPostingtime());
//        Glide.with(context).load(album.getImage()).into(holder.image);
//        Glide.with(context).load(album.getProfilepic()).into(holder.profilepic);

//        holder.profilepic.setText(album.getUsername());
//        holder.image.setText(album.getUsername());
//        Picasso.with(context)
//                .load(listModel.get(position).getProfilepic())
//                .placeholder(R.drawable.anil)
//                .into(holder.profilepic);
//
//        Picasso.with(context)
//                .load(listModel.get(position).getImage())
//                .placeholder(R.drawable.shivratri)
//                .into(holder.image);
//        try {
//            Picasso.with(context)
//                    .load(listModel.get(position).getImage())
//                    .into(holder.image);
//
//        }catch (Exception e){
//
//        }
    }
    @Override
    public int getItemCount() {
        return listModel.size();
    }
}




