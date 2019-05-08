package com.albertech.common.base.recycler.normal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public abstract class BaseRecyclerAdapter<Holder extends BaseHolder<? extends BaseRecyclerAdapter, Bean>, Bean>
        extends RecyclerView.Adapter<Holder>
        implements OnItemClickListener<Bean> {

    private final List<Bean> DATA = new ArrayList<>();


    public final void updateData(Collection<Bean> data) {
        DATA.clear();
        DATA.addAll(data);
        notifyDataSetChanged();
    }

    public final void appendData(Collection<Bean> data) {
        if (data != null && data.size() > 0) {
            int start = DATA.size();
            DATA.addAll(data);
            notifyItemRangeInserted(start, data.size());
        }
    }

    public final void appendItem(Bean item) {
        DATA.add(item);
        notifyItemInserted(DATA.size() - 1);
    }

    public final void clearData() {
        DATA.clear();
        notifyDataSetChanged();
    }

    public final List<Bean> getData() {
        return DATA;
    }

    public final Bean getItem(int position) {
        return DATA.get(position);
    }


    @Override
    public final int getItemCount() {
        return DATA.size();
    }

    @NonNull
    @Override
    public final Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(viewType, viewGroup, false);
        return getHolderByViewType(itemView, viewType);
    }

    @Override
    public final void onBindViewHolder(@NonNull Holder viewHolder, int position) {
        viewHolder.onBind(position, DATA.get(position));
    }

    @Override
    public boolean onItemClick(int position, Bean bean) {
        return false;
    }

    @Override
    public boolean onItemLongClick(int position, Bean bean) {
        return false;
    }


    protected abstract Holder getHolderByViewType(View itemView, int viewType);

}
