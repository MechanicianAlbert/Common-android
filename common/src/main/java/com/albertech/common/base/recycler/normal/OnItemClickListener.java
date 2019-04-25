package com.albertech.common.base.recycler.normal;

public interface OnItemClickListener<Bean> {

    boolean onItemClick(int position, Bean bean);

    boolean onItemLongClick(int position, Bean bean);
}
