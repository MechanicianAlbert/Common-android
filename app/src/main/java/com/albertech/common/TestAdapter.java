package com.albertech.common;


import android.view.View;

import com.albertech.common.base.recycler.normal.BaseHolder;
import com.albertech.common.base.recycler.normal.BaseRecyclerAdapter;
import com.albertech.common.base.recycler.select.SelectHolder;
import com.albertech.common.base.recycler.select.SelectRecyclerAdapter;


public class TestAdapter extends SelectRecyclerAdapter<SelectHolder<TestAdapter, TestBean>, TestBean> {

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_test;
    }

    @Override
    protected SelectHolder<TestAdapter, TestBean> getHolderByViewType(View itemView, int viewType) {
        return new TestHolder(this, itemView);
    }
}
