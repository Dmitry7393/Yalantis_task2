package com.yalantis_task2.requests.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ListView;

import com.yalantis_task2.requests.MainActivity;
import com.yalantis_task2.R;
import com.yalantis_task2.data.*;
import com.yalantis_task2.requests.adapter.ListViewAdapter;

import java.util.List;

public class TabFragmentListView extends Fragment implements Animation.AnimationListener {
    private static final int TAB3 = 3;
    private Animation mAnimationHide;
    private Animation mAnimationShow;
    private FloatingActionButton mFab1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_listview, container, false);

        MainActivity activity = (MainActivity) getActivity();
        DataSet myDataSet = new DataSet(activity.getApplicationContext());

        mAnimationHide = AnimationUtils.loadAnimation(rootView.getContext(), R.anim.floating_action_button_hide);
        mAnimationShow = AnimationUtils.loadAnimation(rootView.getContext(), R.anim.floating_action_button_show);
        mAnimationHide.setAnimationListener(this);
        mAnimationShow.setAnimationListener(this);

        ListView tabListView = (ListView) rootView.findViewById(R.id.list_view);
        mFab1 = (FloatingActionButton) activity.findViewById(R.id.fab);

        tabListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState != SCROLL_STATE_TOUCH_SCROLL) {
                    if (mFab1.getVisibility() == View.VISIBLE && (mAnimationHide.hasEnded() || !mAnimationHide.isInitialized())) {
                        mFab1.startAnimation(mAnimationHide);
                    } else if ((mAnimationShow.hasEnded() && mAnimationHide.hasEnded()) || mFab1.getVisibility() == View.INVISIBLE) {
                        mFab1.startAnimation(mAnimationShow);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        List<ContactInfo> myList = myDataSet.createList(TAB3);
        ListViewAdapter customAdapter = new ListViewAdapter(getContext(), R.layout.card_layout, myList);

        tabListView.setAdapter(customAdapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (mFab1.getVisibility() == View.VISIBLE) {
            mFab1.setVisibility(View.INVISIBLE);
        } else {
            mFab1.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}