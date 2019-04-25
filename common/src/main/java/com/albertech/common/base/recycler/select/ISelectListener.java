package com.albertech.common.base.recycler.select;

public interface ISelectListener {

    void onSelectingStatusChange(boolean isSelecting);

    void onSelectionCountChange(int count, boolean hasSelectedAll);
}
