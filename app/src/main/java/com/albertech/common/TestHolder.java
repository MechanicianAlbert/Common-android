package com.albertech.common;


import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;

import com.albertech.common.base.recycler.select.SelectHolder;


public class TestHolder extends SelectHolder<TestAdapter, TestBean> {

    public TestHolder(TestAdapter adapter, @NonNull View itemView) {
        super(adapter, itemView);
    }

    @Override
    protected void onBind(int position, TestBean testBean) {
        setImage(R.id.iv, testBean.ICON);
        setText(R.id.tv, testBean.DESC + ": " + position);

        CheckBox cb = $(R.id.cb);
        cb.setVisibility(isSelecting() ? View.VISIBLE : View.INVISIBLE);
        cb.setChecked(isSelected(position));
    }
}
