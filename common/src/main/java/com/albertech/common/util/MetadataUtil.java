package com.albertech.common.util;


import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;

import static com.albertech.common.util.Res.context;

/**
 * 元数据工具类, 用于获取清单内声明的元数据
 *
 * @author Albert
 */
public class MetadataUtil {

    /**
     * 获得 Application 节点下的元数据
     * 需要在调用处自行判空
     *
     * @return 元数据
     */
    public static Bundle fromApplication() {
        try {
            String name = context().getPackageName();
            return context()
                    .getPackageManager()
                    .getApplicationInfo(name, PackageManager.GET_META_DATA)
                    .metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得 Activity 节点下的元数据
     * 需要在调用处自行判空
     *
     * @return 元数据
     */
    public static Bundle fromActivity(Class<? extends Activity> c) {
        try {
            ComponentName name = new ComponentName(context(), c);
            return context()
                    .getPackageManager()
                    .getActivityInfo(name, PackageManager.GET_META_DATA)
                    .metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得 Service 节点下的元数据
     * 需要在调用处自行判空
     *
     * @return 元数据
     */
    public static Bundle fromService(Class<? extends Service> c) {
        try {
            ComponentName name = new ComponentName(context(), c);
            return context()
                    .getPackageManager()
                    .getServiceInfo(name, PackageManager.GET_META_DATA)
                    .metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得 Receiver 节点下的元数据
     * 需要在调用处自行判空
     *
     * @return 元数据
     */
    public static Bundle fromReceiver(Class<? extends BroadcastReceiver> c) {
        try {
            ComponentName name = new ComponentName(context(), c);
            return context()
                    .getPackageManager()
                    .getReceiverInfo(name, PackageManager.GET_META_DATA)
                    .metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

}
