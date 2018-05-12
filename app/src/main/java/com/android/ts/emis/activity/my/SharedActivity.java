package com.android.ts.emis.activity.my;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 分享
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class SharedActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_shared);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.selector_title_back, "分享", "返回", true);
    }
}
