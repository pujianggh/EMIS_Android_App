package com.android.ts.emis.activity.work;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 工作-工单列表
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_list);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "工单列表", true);

        initData();
    }

    private void initData() {

    }
}