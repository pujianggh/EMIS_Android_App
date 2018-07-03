package com.android.ts.emis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.android.ts.emis.R;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.mode.UserPasswordBean;
import com.android.ts.emis.utils.NavigationBarUtil;
import com.android.ts.emis.utils.ToastUtil;
import com.libcommon.action.base.CommonBaseSwipeBackActivity;

import cn.bingoogolapple.sweetaction.SweetAlertDialog;
import cn.bingoogolapple.titlebar.BGATitleBar;

/**
 * Activity基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseActivity extends CommonBaseSwipeBackActivity {
    protected BaseActivity mContext;
    protected APPApplication mAPPApplication;
    private SweetAlertDialog mLoadingDialog;
    protected BGATitleBar mTitleBar;
    private LinearLayout mTitleBarLayer;
    protected UserPasswordBean mUserPasswrd = new UserPasswordBean();

    @Override
    public boolean isSupportSwipeBack() {
        if (NavigationBarUtil.checkDeviceHasNavigationBar(this)){
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAPPApplication = APPApplication.getInstance();
        mContext = this;

        initView(savedInstanceState);
    }

    /**
     * 设置Title
     *
     * @param title
     * @param isUse
     */
    protected void setTitleBarLayout(CharSequence title, boolean isUse) {
        initTitleBarLayout(title, null, null, isUse);
    }

    /**
     * 设置Title样式
     *
     * @param leftDrawable
     * @param title
     * @param leftText
     * @param isUse
     */
    protected void setTitleBarLayout(int leftDrawable, String title, String leftText, boolean isUse) {
        setTitleBarLayout(title, isUse);
        mTitleBar.setLeftDrawable(leftDrawable);
        mTitleBar.getLeftCtv().setTextSize(18);
        if (!TextUtils.isEmpty(leftText))
            mTitleBar.setLeftText(leftText);
    }

    /**
     * 设置Title样式
     *
     * @param leftDrawable
     * @param title
     * @param leftText
     * @param isUse
     */
    protected void setTitleBarLayout(int leftDrawable, String title, String leftText, String rightText, boolean isUse) {
        setTitleBarLayout(leftDrawable, title, leftText, isUse);
        if (!TextUtils.isEmpty(rightText)) {
            mTitleBar.getRightCtv().setText(rightText);
            mTitleBar.getRightCtv().setTextSize(14);
            mTitleBar.getRightCtv().setVisibility(View.VISIBLE);
        }
    }

    protected void showToast(String text) {
        ToastUtil.INSTANCE.show(text);
    }

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化-设置Title
     *
     * @param title
     * @param left
     * @param right
     * @param isUse
     */
    private void initTitleBarLayout(CharSequence title, CharSequence left, CharSequence right, boolean isUse) {
        mTitleBarLayer = (LinearLayout) findViewById(R.id.layout_titleBar);
        mTitleBar = (BGATitleBar) findViewById(R.id.titleBar);
        if (null == mTitleBarLayer || null == mTitleBar) return;
        if (!isUse) mTitleBarLayer.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(title)) {
            mTitleBar.setTitleText(title);
        }
        if (!TextUtils.isEmpty(left)) {
            mTitleBar.setLeftText(left);
        }
        if (!TextUtils.isEmpty(right)) {
            mTitleBar.setRightText(right);
        }
        mTitleBar.setDelegate(new BGATitleBar.Delegate() {
            @Override
            public void onClickLeftCtv() {
                onBackPressed();//finish();
            }

            @Override
            public void onClickTitleCtv() {

            }

            @Override
            public void onClickRightCtv() {

            }

            @Override
            public void onClickRightSecondaryCtv() {

            }
        });
    }

    /**
     * 进度加载对话框-显示
     */
    public void showLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
            mLoadingDialog.setCancelable(true);
            mLoadingDialog.setTitleText("数据加载中...");
        }
        mLoadingDialog.show();
    }

    /**
     * 隐藏加载
     */
    public void dismissLoadingDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }
}
