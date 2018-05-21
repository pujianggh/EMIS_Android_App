package com.android.ts.emis.activity.work;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.SignatureHandActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.config.ResultCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-工单创建
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderCreateActivity extends BaseActivity {
    @BindView(R.id.igv_signHand)
    ImageView mIgvSignHand;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_create);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "创建工单", true);

    }

    @OnClick({R.id.igv_signHand})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.igv_signHand:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissionInfo(RequestCode.INSTANCE.getResult_SignatureHand_Permission(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
                    return;
                }
                startActivityForResult(new Intent(mAPPApplication, SignatureHandActivity.class), RequestCode.INSTANCE.getResult_SignatureHand());
                break;
        }
    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (RequestCode.INSTANCE.getResult_SignatureHand_Permission() == requestCode) {
            startActivityForResult(new Intent(mAPPApplication, SignatureHandActivity.class), RequestCode.INSTANCE.getResult_SignatureHand());
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        showToast("您拒绝了读写存储权限!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_SignatureHand() && resultCode == ResultCode.INSTANCE.getResult_SignatureHand()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(AppConfig.INSTANCE.getFILE_CACHE_PATH(), options);
            mIgvSignHand.setImageBitmap(bitmap);
        }
    }
}
