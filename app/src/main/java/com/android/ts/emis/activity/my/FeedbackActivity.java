package com.android.ts.emis.activity.my;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 意见反馈
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class FeedbackActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.selector_title_back, "意见反馈", "返回", true);
    }
}
