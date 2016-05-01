package com.yalantis_task2.requests.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yalantis_task2.requests.MainActivity;
import com.yalantis_task2.R;
import com.yalantis_task2.data.*;
import com.yalantis_task2.requests.adapter.MyListAdapter;

import java.util.List;

public class TabFragmentListView extends Fragment {
    private static final int Tab3 = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        DataSet myDataSet = new DataSet(activity.getApplicationContext());
        View rootView = inflater.inflate(R.layout.tab_fragment_listview, container, false);

        ListView tabListView = (ListView) rootView.findViewById(R.id.list_view);

        List<ContactInfo> myList = myDataSet.createList(Tab3);
        MyListAdapter customAdapter = new MyListAdapter(getContext(), R.layout.card_layout, myList);

        tabListView.setAdapter(customAdapter);

        return rootView;
    }
}