package com.android.ts.emis.activity.work;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 工作-巡检-查询
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollingQueryActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_polling_query);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "巡检查询", true);

        initData();
    }

    private void initData() {

    }
}
