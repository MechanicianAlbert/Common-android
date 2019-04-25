package com.albertech.common.util;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * 资源工具类, 用于获取全局资源
 *
 * @author Albert
 */
public class Res {

    private static Application sApplication;


    // 私有构造
    private Res() {
        // 防止反射实例
        throw new RuntimeException("This class cannot be instantiated");
    }

    /**
     * 缓存 Application 实例
     * @param a Application 实例
     */
    public static void setApplication(Application a) {
        sApplication = a;
    }

    /**
     * 获得 Application 实例
     * @return Application 实例
     */
    public static Application application() {
        return sApplication;
    }

    /**
     * 获得 Context 实例
     * @return Context 实例
     */
    public static Context context() {
        return sApplication.getApplicationContext();
    }

    /**
     * 获得资源字符串
     * @param stringRes 资源id
     * @return 字符串
     */
    public static String string(@StringRes int stringRes) {
        return context().getResources().getString(stringRes);
    }

    /**
     * 获得资源颜色
     * @param colorRes 资源id
     * @return 颜色
     */
    public static int color(@ColorRes int colorRes) {
        return context().getResources().getColor(colorRes);
    }

    /**
     * 获得资源 Drawable
     * @param drawableRes 资源id
     * @return Drawable
     */
    public static Drawable drawable(@DrawableRes int drawableRes) {
        return context().getResources().getDrawable(drawableRes);
    }

    /**
     * 获得以像素为单位的资源尺寸
     * @param dimenRes 资源id
     * @return 尺寸像素值
     */
    public static int px(@DimenRes int dimenRes) {
        return context().getResources().getDimensionPixelSize(dimenRes);
    }

}
