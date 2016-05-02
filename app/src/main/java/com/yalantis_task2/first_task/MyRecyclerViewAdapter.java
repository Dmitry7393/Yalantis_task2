package com.yalantis_task2.first_task;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yalantis_task2.R;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private int[] mListImages;
    private Context mContext;

    public MyRecyclerViewAdapter(int[] listImages, Context context) {
        mContext = context;
        mListImages = listImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(mContext).load(mListImages[position]).fit().centerInside().into(holder.imageViewIcon);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.recyclerviewimages);
        }
    }

    @Override
    public int getItemCount() {
        return mListImages.length;
    }
}