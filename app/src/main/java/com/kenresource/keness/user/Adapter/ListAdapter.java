package com.kenresource.keness.user.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kenresource.keness.user.Model.ListModel;
import com.kenresource.keness.user.R;

import java.util.List;

/**
 * Created by suchismita on 2/23/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private final Context context;
    private List<ListModel> listModel;


    public ListAdapter(Context context, List<ListModel> items) {

        this.context = context;
        this.listModel =items;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date;
        TextView event;

        public MyViewHolder(View view)

        {
            super(view);
            date=(TextView)view.findViewById(R.id.date);
            event=(TextView)view.findViewById(R.id.event);
        }
    }


    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ListModel album = listModel.get(position);
        holder.date.setText(album.getDate());
        holder.event.setText(album.getEvent());


    }
    @Override
    public int getItemCount() {
        return listModel.size();
    }
}

