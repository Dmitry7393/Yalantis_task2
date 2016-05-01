package com.yalantis_task2.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.yalantis_task2.R;

import java.util.ArrayList;

public class DataSet {
    private Context context;

    public DataSet(Context current) {
        this.context = current;
    }

    public ArrayList<ContactInfo> createList(int tabNumber) {
        ArrayList<ContactInfo> listData = new ArrayList<>();
        Resources res = context.getResources();
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

                ci.setImageEnterprise(context.getResources().getIdentifier(array[i][0], null, null));
                ci.setNameEnterprise(array[i][1]);
                ci.setTitleStreet(array[i][2]);
                ci.setImageLike(context.getResources().getIdentifier(array[i][3], null, null));
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
