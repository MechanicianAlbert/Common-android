package com.albertech.common;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.albertech.common.base.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private final TestAdapter ADAPTER = new TestAdapter();


    private TestFragment mFragment;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        mFragment = TestFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl, mFragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (mFragment != null && mFragment.interceptBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

}
