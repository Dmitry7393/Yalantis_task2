package com.yalantis_task2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.List;

public class TabFragmentListView extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        View rootView = inflater.inflate(R.layout.tab_fragment_listview, container, false);

        ListView tabListView = (ListView) rootView.findViewById(R.id.list_view);

        List<ContactInfo> myList = activity.createList(3);
        MyListAdapter customAdapter = new MyListAdapter(getContext(), R.layout.card_layout, myList);

        tabListView.setAdapter(customAdapter);

        return rootView;
    }
}