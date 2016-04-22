package com.yalantis_task2;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "FloatingActionButton", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null)
            drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);

        initTabs();
    }

    private void initTabs() {
        TabFragmentRecyclerView tabFragmentRecyclerView1 = new TabFragmentRecyclerView();
        Bundle args1 = new Bundle();
        args1.putInt("TabNumber", 1);
        tabFragmentRecyclerView1.setArguments(args1);

        TabFragmentRecyclerView tabFragmentRecyclerView2 = new TabFragmentRecyclerView();
        Bundle args2 = new Bundle();
        args2.putInt("TabNumber", 2);
        tabFragmentRecyclerView2.setArguments(args2);

        TabFragmentListView tabFragmentListView = new TabFragmentListView();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(tabFragmentRecyclerView1);
        fragments.add(tabFragmentRecyclerView2);
        fragments.add(tabFragmentListView);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            tabLayout.addTab(tabLayout.newTab().setText("В роботі"));
            tabLayout.addTab(tabLayout.newTab().setText("Виконано"));
            tabLayout.addTab(tabLayout.newTab().setText("Очікує"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter pagerAdapter = new PagerAdapter
                (getSupportFragmentManager(), fragments);
        if (viewPager != null) {
            viewPager.setAdapter(pagerAdapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }

        if (tabLayout != null && viewPager != null) {
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_create_order) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_request) {

        } else if (id == R.id.nav_request_on_map) {

        } else if (id == R.id.login) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null)
            drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void CardViewOnClick1(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityFirstTask.class);
        startActivity(intent);
    }

    public ArrayList<ContactInfo> createList(int tabNumber) {
        ArrayList<ContactInfo> listData = new ArrayList<>();
        Resources res = getResources();
        TypedArray ta = res.obtainTypedArray(R.array.first_tab);
        if (tabNumber == 1)
            ta = res.obtainTypedArray(R.array.first_tab);
        if (tabNumber == 2)
            ta = res.obtainTypedArray(R.array.second_tab);
        if (tabNumber == 3)
            ta = res.obtainTypedArray(R.array.third_tab);

        int n = ta.length();
        String[][] array = new String[n][];
        for (int i = 0; i < n; ++i) {
            int id = ta.getResourceId(i, 0);
            if (id > 0) {
                array[i] = res.getStringArray(id);
                ContactInfo ci = new ContactInfo();

                ci.setImageEnterprise(getResources().getIdentifier(array[i][0], null, null));
                ci.setNameEnterprise(array[i][1]);
                ci.setTitleStreet(array[i][2]);
                ci.setImageLike(getResources().getIdentifier(array[i][3], null, null));
                ci.setAmountLikes(array[i][4]);
                ci.setTitleDate(array[i][5]);
                ci.setAmountDays(array[i][6]);
                listData.add(ci);
            }
        }
        ta.recycle();
        return listData;
    }
}
