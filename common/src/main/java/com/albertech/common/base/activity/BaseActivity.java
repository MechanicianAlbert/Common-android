package com.albertech.common.base.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * 常用 Activity 基类
 *
 * @author Albert
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉系统 ActionBar, 子类需要标题栏, 使用Toolbar实现
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(layoutRes());
        init();
    }

    /**
     * 简写 findViewById() 方法
     */
    protected final <T extends View> T  $(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 初始化
     * 使用 protected 修饰, 当子类需要覆写 onCreate() 方法时, 可以自行调用 init() 方法使用模板自动化逻辑
     * 不建议覆写此方法
     */
    protected void init() {
        initArgs(getIntent());
        initPermission();
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化参数
     * @param intent 启动活动的 intent 实例
     */
    protected void initArgs(Intent intent) {

    }

    /**
     * 初始化权限
     */
    protected void initPermission() {

    }

    /**
     * 初始化布局
     */
    protected void initView() {

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
     * 获得根布局资源id
     * @return 根布局资源id
     */
    protected abstract int layoutRes();

}
