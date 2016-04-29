package com.yalantis_task2;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class ActivityFirstTask extends AppCompatActivity { //[Comment] Please make project structure with packages
    private static final int SPACE_SIZE_BETWEEN_IMAGES = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        int[] mListImages = new int[]{R.drawable.image_bridge, R.drawable.seafront,
                R.drawable.dnepr_night, R.drawable.karl_marx_street,
                R.drawable.most_city, R.drawable.merefo_hersonsky_bridge_dnipropetrovsk,
                R.drawable.seafront_winter
        };
        initRecyclerView(mListImages);
    }

    /**
     * Creating RecyclerView
     */
    private void initRecyclerView(int[] mListImages) {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); //[Comment] Without "m" it's local

        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager =
                    new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(layoutManager);

            RecyclerView.Adapter mAdapter = new MyRecyclerViewAdapter(mListImages, this);

            mRecyclerView.setAdapter(mAdapter);
            RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(SPACE_SIZE_BETWEEN_IMAGES);
            mRecyclerView.addItemDecoration(itemDecoration);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Show toast with control name when user presses any control
     */
    public void onClickToast(View view) {
        String mText = view.getClass().getSimpleName();
        Toast.makeText(this, mText, Toast.LENGTH_LONG).show();
    }
}