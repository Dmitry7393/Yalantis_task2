package com.yalantis_task2.requests.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yalantis_task2.R;
import com.yalantis_task2.data.*;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ContactInfo> {
    private List<ContactInfo> mListData = new ArrayList<>();

    public ListViewAdapter(Context context, int resource, List<ContactInfo> items) {
        super(context, resource, items);
        mListData = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder;
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_layout, parent, false);
            holder = new ViewHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        holder.setData(position);
        return itemView;
    }

    private class ViewHolder {

        private ImageView vImageEnterprise;
        private TextView vNameEnterprise;
        private TextView vTitleStreet;
        private ImageView vImageLike;
        private TextView vAmountLikes;
        private TextView vTitleDate;
        private TextView vAmountDays;

        public ViewHolder(View itemView) {
            vImageEnterprise = (ImageView) itemView.findViewById(R.id.image1);
            vNameEnterprise = (TextView) itemView.findViewById(R.id.txtNameEnterprise);
            vTitleStreet = (TextView) itemView.findViewById(R.id.txtStreet);
            vImageLike = (ImageView) itemView.findViewById(R.id.imageLike);
            vAmountLikes = (TextView) itemView.findViewById(R.id.txtAmountLikes);
            vTitleDate = (TextView) itemView.findViewById(R.id.txtDate);
            vAmountDays = (TextView) itemView.findViewById(R.id.txtAmountDays);
        }

        public void setData(int position) {
            vImageEnterprise.setImageResource(mListData.get(position).getImageEnterprise());
            vNameEnterprise.setText(mListData.get(position).getNameEnterprise());
            vTitleStreet.setText(mListData.get(position).getTitleStreet());
            vImageLike.setImageResource(mListData.get(position).getImageLike());
            vAmountLikes.setText(String.valueOf(mListData.get(position).getAmountLikes()));
            vTitleDate.setText(mListData.get(position).getTitleDate());
            vAmountDays.setText(mListData.get(position).getAmountDays());
        }
    }
}