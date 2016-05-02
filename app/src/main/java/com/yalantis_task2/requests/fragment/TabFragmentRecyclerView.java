package com.yalantis_task2.requests.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yalantis_task2.requests.MainActivity;
import com.yalantis_task2.R;
import com.yalantis_task2.data.*;
import com.yalantis_task2.requests.adapter.ContactAdapter;

import java.util.List;

public class TabFragmentRecyclerView extends Fragment {
    private List<ContactInfo> myList;
    private static final int TAB1 = 1;
    private static final int TAB2 = 2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int index = args.getInt("TabNumber", 0);
        MainActivity activity = (MainActivity) getActivity();
        DataSet myDataSet = new DataSet(activity.getApplicationContext());
        if(index == 1)
            myList = myDataSet.createList(TAB1);
        if(index == 2)
            myList = myDataSet.createList(TAB2);

        View rootView;
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