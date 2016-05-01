package com.yalantis_task2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<ContactInfo> {
    private  List<ContactInfo> myList = new ArrayList<>(); //[Comment] Your list?
    public MyListAdapter(Context context, int resource, List<ContactInfo> items) {
        super(context, resource, items);
        myList = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView; //[Comment] Very bad. Use ViewHolder

        if (v == null) {
            LayoutInflater vi;//[Comment] Why you create object here, and in next row initialize it? What is vi?
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.card_layout, parent, false);
        }
        ImageView   vImageEnterprise = (ImageView) v.findViewById(R.id.image1);
        TextView  vNameEnterprise =  (TextView) v.findViewById(R.id.txtNameEnterprise);
        TextView  vTitleStreet = (TextView)  v.findViewById(R.id.txtStreet);
        ImageView  vImageLike = (ImageView) v.findViewById(R.id.imageLike);
        TextView   vAmountLikes = (TextView) v.findViewById(R.id.txtAmountLikes);
        TextView  vTitleDate = (TextView)  v.findViewById(R.id.txtDate);
        TextView  vAmountDays = (TextView) v.findViewById(R.id.txtAmountDays); //[Comment] Wrong formatting

        for(int i = 0; i < myList.size(); i++) {
            vImageEnterprise.setImageResource(myList.get(i).getImageEnterprise());
            vNameEnterprise.setText(myList.get(i).getNameEnterprise());
            vTitleStreet.setText(myList.get(i).getTitleStreet());
            vImageLike.setImageResource(myList.get(i).getImageLike());
            vAmountLikes.setText(String.valueOf(myList.get(i).getAmountLikes()));
            vTitleDate.setText(myList.get(i).getTitleDate());
            vAmountDays.setText(myList.get(i).getAmountDays());
        }
        return v;
    }

}