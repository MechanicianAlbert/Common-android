package com.albertech.common.base.pager;


import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager 适配器的基类, 列表泛型为 View 的子类, 如果希望使用 Bean 作列表泛型, 则无需继承此实现
 * @param <T> 单页布局 View
 *
 * @author Albert
 */
public class BasePagerAdapter<T extends View> extends PagerAdapter {

    private final List<T> PAGERS = new ArrayList<>();

    /**
     * 更新元素
     * @param pagers
     */
    public final void updatePagers(List<T> pagers) {
        PAGERS.clear();
        PAGERS.addAll(pagers);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return PAGERS.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public T instantiateItem(@NonNull ViewGroup container, int position) {
        T v = PAGERS.get(position);
        container.addView(v);
        return v;
    }

}
