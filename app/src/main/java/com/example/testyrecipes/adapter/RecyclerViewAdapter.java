package com.example.testyrecipes.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testyrecipes.R;
import com.example.testyrecipes.model.Recipes;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Recipes> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Recipes> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for glide

        option = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.recipes_row_item,parent,false);
        // click listener here
        return new MyViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.R_name.setText(mData.get(position).getName());
        holder.R_time.setText(mData.get(position).getPrepTime());
        holder.R_cook.setText(mData.get(position).getCookTime());
        holder.R_name.setText(mData.get(position).getName());

        // Load Image from ImageView use Glide

        Glide.with(mContext).load(mData.get(position).getImageResource()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView R_name;
        TextView R_time;
        TextView R_cook;

        ImageView img_thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            R_name = itemView.findViewById(R.id.rowname);
            R_time = itemView.findViewById(R.id.ptime);
            R_cook = itemView.findViewById(R.id.ctime);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

}
