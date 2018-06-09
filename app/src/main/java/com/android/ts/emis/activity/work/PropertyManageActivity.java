package com.android.ts.emis.activity.work;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 工作-资产管理
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PropertyManageActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_property_manage);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, "资产管理", null, true);

        initData();
    }

    private void initData() {

    }
}
