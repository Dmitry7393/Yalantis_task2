package com.yalantis_task2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TabFragmentRecyclerView extends Fragment {
    private ArrayList<ContactInfo> myList ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int index = args.getInt("index", 0);
        MainActivity activity = (MainActivity) getActivity();

        if(index == 1)
            myList = activity.createList(1);
        if(index == 2)
            myList = activity.createList(2);

        View rootView ;
        rootView = inflater.inflate(R.layout.tab_fragment_recyclerview, container, false);
        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.cardList);
        if (recList != null) {
            recList.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(rootView.getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recList.setLayoutManager(llm);

            ContactAdapter ca = new ContactAdapter(myList);
            recList.setAdapter(ca);
        }
        return rootView;
    }
}