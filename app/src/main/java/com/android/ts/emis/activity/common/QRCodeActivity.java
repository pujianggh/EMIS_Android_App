package com.android.ts.emis.activity.common;

import android.Manifest;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qrcode.zxing.ZXingView;

/**
 * 二维码扫描
 *
 * @author pujiang
 * @date 2018-5-20 20:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class QRCodeActivity extends BaseActivity implements ZXingView.Delegate {
    @BindView(R.id.layout_titleBar)
    RelativeLayout mLayoutTitleBar;
    @BindView(R.id.zxv_content)
    ZXingView mZxvContent;
    @BindView(R.id.igv_back)
    ImageView mIgvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.igv_icon)
    ImageView mIgvIcon;

    private int mLightCount = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this);

        mIgvIcon.setImageResource(R.drawable.icon_light_open);
        mZxvContent.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mZxvContent.startCamera();
        mZxvContent.showScanRect();
        mZxvContent.startSpot();
        mZxvContent.startSpotAndShowRect();//显示扫描框
        //mZxvContent.stopSpotAndHiddenRect();//隐藏扫描框
        //mZxvContent.changeToScanBarcodeStyle();//扫描条码
        //mZxvContent.changeToScanQRCodeStyle();//扫描二维码
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        showToast("扫描结果:" + result);
        vibrate();
        mZxvContent.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        showToast("打开相机出错");
    }

    @OnClick({R.id.igv_back, R.id.tv_title, R.id.igv_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.igv_back:
            case R.id.tv_title:
                onBackPressed();
                break;
            case R.id.igv_icon:
                if (mLightCount % 2 == 0) {
                    mZxvContent.openFlashlight();
                    mIgvIcon.setImageResource(R.drawable.icon_light_close);
                } else {
                    mZxvContent.closeFlashlight();
                    mIgvIcon.setImageResource(R.drawable.icon_light_open);
                }
                ++mLightCount;
                break;
        }
    }

    /**
     * 震动操作
     */
    private void vibrate() {
        if (checkPermissions(new String[]{Manifest.permission.VIBRATE})) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(200);
        }
    }

    @Override
    protected void onStop() {
        mZxvContent.stopSpot();
        mZxvContent.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZxvContent.onDestroy();
        super.onDestroy();
    }
}
