package com.albertech.common.base.recycler.select;


import java.util.List;


public interface ISelect<Bean> {

    boolean isSelecting();

    void startSelecting();

    void stopSelecting();

    void selectAll();

    void clearSelection();

    void updateItemSelection(int position, boolean selected);

    boolean isItemSelected(int position);

    int getSelectionCount();

    List<Bean> getSelections();

}
