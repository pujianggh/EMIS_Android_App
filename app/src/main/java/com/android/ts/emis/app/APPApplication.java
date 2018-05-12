package com.android.ts.emis.app;

import com.libcommon.action.base.CommonBaseApplication;
import com.libcommon.action.utils.APPToolsUtil;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Application类
 *
 * @author pujiang
 * @date 2018-01-25 17:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class APPApplication extends CommonBaseApplication {
    public static Class toIntentMainClass = "MainActivity".getClass();  //需要跳转主页的类
    private static APPApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initConfigData();
        initOkHttpConfig();//初始化网络请求参数
        initAndFix(APPToolsUtil.getAppVersionName(this));
    }

    /**
     * 初始化项目配置文件数据
     */
    private void initConfigData() {
        // 必须在Application的onCreate 方法中执行
        // BGASwipeBackManager.getInstance().init(this)来初始化滑动返回
        BGASwipeBackManager.getInstance().init(this);
    }

    public static synchronized APPApplication getInstance() {
        return mInstance;
    }
}
