package com.android.ts.emis.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.CommonWebActivity;
import com.android.ts.emis.activity.my.SettingActivity;
import com.android.ts.emis.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-工作信息
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.rly_one)
    RelativeLayout rlyOne;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_my);
        unBinder = ButterKnife.bind(this, mContentView);
    }

    @OnClick({R.id.rly_one, R.id.rly_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rly_one:
                startActivity(new Intent(getActivity(), CommonWebActivity.class));
                break;
            case R.id.rly_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }
}
