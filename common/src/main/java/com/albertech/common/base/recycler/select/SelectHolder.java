package com.albertech.common.base.recycler.select;


import android.support.annotation.NonNull;
import android.view.View;

import com.albertech.common.base.recycler.normal.BaseHolder;


public class SelectHolder<Adapter extends SelectRecyclerAdapter<? extends SelectHolder, Bean>, Bean> extends BaseHolder<Adapter, Bean> {


    public SelectHolder(Adapter adapter, @NonNull View itemView) {
        super(adapter, itemView);
    }


    protected boolean isSelecting() {
        return getAdapter().isSelecting();
    }

    protected boolean isSelected(int position) {
        return getAdapter().isItemSelected(position);
    }

}
