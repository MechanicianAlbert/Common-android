package com.albertech.common.base.recycler.select;


import com.albertech.common.base.recycler.normal.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class SelectRecyclerAdapter<Holder extends SelectHolder<? extends SelectRecyclerAdapter, Bean>, Bean>
        extends BaseRecyclerAdapter<Holder, Bean>
        implements ISelect<Bean>, ISelectListener {

    private final Set<Integer> SELECTED_POSITIONS = new HashSet<>();


    private boolean mIsSelecting;


    @Override
    public boolean isSelecting() {
        return mIsSelecting;
    }

    @Override
    public void startSelecting() {
        mIsSelecting = true;
        notifyDataSetChanged();
        onSelectingStatusChange(mIsSelecting);
    }

    @Override
    public void stopSelecting() {
        mIsSelecting = false;
        SELECTED_POSITIONS.clear();
        notifyDataSetChanged();
        onSelectingStatusChange(mIsSelecting);
    }

    @Override
    public void selectAll() {
        if (mIsSelecting) {
            for (int i = 0; i < getItemCount(); i++) {
                SELECTED_POSITIONS.add(i);
            }
            notifyDataSetChanged();

            onSelectionCountChange(getSelectionCount(), true);
        }
    }

    @Override
    public void clearSelection() {
        if (mIsSelecting) {
            SELECTED_POSITIONS.clear();
            notifyDataSetChanged();

            onSelectionCountChange(0, false);
        }
    }

    @Override
    public void updateItemSelection(int position, boolean selected) {
        if (mIsSelecting) {
            if (selected) {
                SELECTED_POSITIONS.add(position);
            } else {
                SELECTED_POSITIONS.remove(position);
            }
            notifyItemChanged(position);

            int count= SELECTED_POSITIONS.size();
            onSelectionCountChange(count, count == getItemCount());
        }
    }

    @Override
    public boolean isItemSelected(int position) {
        return SELECTED_POSITIONS.contains(position);
    }

    @Override
    public int getSelectionCount() {
        return SELECTED_POSITIONS.size();
    }

    @Override
    public List<Bean> getSelections() {
        List<Bean> selections = new ArrayList<>();
        for (int selectedPosition : SELECTED_POSITIONS) {
            if (selectedPosition < getItemCount()) {
                selections.add(getItem(selectedPosition));
            }
        }
        return selections;
    }


    @Override
    public void onSelectingStatusChange(boolean isSelecting) {

    }

    @Override
    public void onSelectionCountChange(int count, boolean hasSelectedAll) {

    }


    @Override
    public final boolean onItemClick(int position, Bean bean) {
        if (mIsSelecting) {
            updateItemSelection(position, !isItemSelected(position));
        } else {
            onItemClickNotSelecting(position, bean);
        }
        return super.onItemClick(position, bean);
    }

    @Override
    public final boolean onItemLongClick(int position, Bean bean) {
        if (!mIsSelecting) {
            startSelecting();
            updateItemSelection(position, true);
        }
        return super.onItemLongClick(position, bean);
    }


    protected void onItemClickNotSelecting(int position, Bean bean) {

    }

}
