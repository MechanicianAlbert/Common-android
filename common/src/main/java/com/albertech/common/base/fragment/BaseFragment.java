package com.albertech.common.base.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 常用 Fragment 的基类
 *
 * @author Albert
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 根布局
     */
    private View mRoot;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(layoutRes(), container, false);
        initView(mRoot);
        initListener();
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearActions();
        release();
    }


    /**
     * 获得页面标题, 常用作填充 Toolbar 的 title, 或 ViewPager 的 tab, 如无需标题则不覆写即可
     * @return 页面标题
     */
    public String getTitle() {
        return "";
    }

    /**
     * 用于容器 Activity 判断返回按钮点击是否应被此 Fragment 拦截
     * @return 是否拦截返回点击
     */
    public boolean interceptBackPressed() {
        return false;
    }


    /**
     * 获得根布局, 需要在调用处自行判空
     * 声明为 final, 子类不应覆写
     * @return 根布局
     */
    protected final View getRootView() {
        return mRoot;
    }

    /**
     * 在主线程执行任务
     * 声明为 final, 子类不应覆写
     */
    protected final void post(Runnable r) {
        if (mRoot != null && ViewCompat.isAttachedToWindow(mRoot)) {
            mRoot.post(r);
        }
    }

    /**
     * 在主线程延迟执行任务
     * 声明为 final, 子类不应覆写
     */
    protected final void postDelayed(Runnable r, long delay) {
        if (mRoot != null && ViewCompat.isAttachedToWindow(mRoot)) {
            mRoot.postDelayed(r, delay);
        }
    }

    /**
     * 清空在队列中未完成的任务
     * 声明为 final, 子类不应覆写
     *
     * 默认在 onDestroy 中调用
     */
    protected final void clearActions() {
        if (mRoot != null) {
            mRoot.removeCallbacks(null);
        }
    }


    /**
     * 获得传入参数
     * @param args 外部通过调用本实例的 setArguments() 方法传入的 Bundle 参数
     */
    protected void initArgs(Bundle args) {

    }

    /**
     * 初始化布局
     * @param root 根布局
     */
    protected void initView(View root) {

    }

    /**
     * 初始化监听器
     */
    protected void initListener() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 释放资源, 默认在 onDestroy 中调用, 子类应在此处理释放资源操作
     */
    protected void release() {

    }

    /**
     * 获得根布局资源id
     * @return 根布局资源id
     */
    protected abstract int layoutRes();

}
