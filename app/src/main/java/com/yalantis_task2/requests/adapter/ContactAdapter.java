package com.yalantis_task2.requests.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yalantis_task2.R;
import com.yalantis_task2.data.ContactInfo;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vImageEnterprise.setImageResource(ci.getImageEnterprise());
        contactViewHolder.vNameEnterprise.setText(ci.getNameEnterprise());
        contactViewHolder.vTitleStreet.setText(ci.getTitleStreet());

        contactViewHolder.vImageLike.setImageResource(ci.getImageLike());
        contactViewHolder.vAmountLikes.setText(ci.getAmountLikes());
        contactViewHolder.vTitleDate.setText(ci.getTitleDate());
        contactViewHolder.vAmountDays.setText(ci.getAmountDays());
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView vImageEnterprise;
        private TextView vNameEnterprise;
        private TextView vTitleStreet;
        private ImageView vImageLike;
        private TextView vAmountLikes;
        private TextView vTitleDate;
        private TextView vAmountDays;

        public ContactViewHolder(View v) {
            super(v);
            vImageEnterprise = (ImageView) v.findViewById(R.id.image1);
            vNameEnterprise = (TextView) v.findViewById(R.id.txtNameEnterprise);
            vTitleStreet = (TextView) v.findViewById(R.id.txtStreet);
            vImageLike = (ImageView) v.findViewById(R.id.imageLike);
            vAmountLikes = (TextView) v.findViewById(R.id.txtAmountLikes);
            vTitleDate = (TextView) v.findViewById(R.id.txtDate);
            vAmountDays = (TextView) v.findViewById(R.id.txtAmountDays);
        }
    }
}