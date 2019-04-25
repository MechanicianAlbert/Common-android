package com.albertech.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.albertech.common.base.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class TestFragment extends BaseFragment {

    TestAdapter ADAPTER = new TestAdapter();


    RecyclerView mRv;


    public static TestFragment newInstance() {
        return new TestFragment();
    }


    @Override
    protected int layoutRese() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView(View root) {
        mRv = root.findViewById(R.id.rv);
    }

    @Override
    protected void initData() {
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(new TestBean(R.drawable.ic_launcher, "Hello World"));
        }

        mRv.setAdapter(ADAPTER);
        mRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ADAPTER.updateData(list);
    }

    @Override
    public boolean interceptBackPressed() {
        if (ADAPTER.isSelecting()) {
            ADAPTER.stopSelecting();
            return true;
        } else {
            return false;
        }
    }
}
