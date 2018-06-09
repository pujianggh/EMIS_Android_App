package com.android.ts.emis.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.fragment.MessageFragment;
import com.android.ts.emis.fragment.MyFragment;
import com.android.ts.emis.fragment.WorkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页
 *
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.fm_main_index)
    FrameLayout fmMainIndex;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.tv_main_message_count)
    TextView tvMainMessageCount;
    @BindView(R.id.tv_main_work_count)
    TextView tvMainWorkCount;
    @BindView(R.id.tv_main_my_count)
    TextView tvMainMyCount;

    private FragmentManager fragmentManager;
    private FragmentTransaction transition;
    private List<Fragment> fragments;
    private MessageFragment messageFragment;
    private WorkFragment workFragment;
    private MyFragment myFragment;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment(savedInstanceState);
        tvMainMessageCount.setVisibility(View.VISIBLE);
        tvMainMessageCount.setText("99+");
        tvMainMyCount.setVisibility(View.VISIBLE);
        tvMainMyCount.setText(" 2 ");
    }

    /**
     * 初始化Fragment
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        fragments = new ArrayList<>();

        rgMain.check(R.id.rb_main_message);
        messageFragment = new MessageFragment();
        fragments.add(messageFragment);
        hideOthersFragment(messageFragment, true);

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main_message://消息中心
                        hideOthersFragment(messageFragment, false);
                        break;
                    case R.id.rb_main_work://工作信息
                        if (workFragment == null) {
                            workFragment = new WorkFragment();
                            fragments.add(workFragment);
                            hideOthersFragment(workFragment, true);
                        } else {
                            hideOthersFragment(workFragment, false);
                        }
                        break;
                    case R.id.rb_main_my://我的
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                            fragments.add(myFragment);
                            hideOthersFragment(myFragment, true);
                        } else {
                            hideOthersFragment(myFragment, false);
                        }
                        break;
                }
            }
        });
    }

    /**
     * 动态显示Fragment
     *
     * @param showFragment 要增加的fragment
     * @param add          true：增加fragment；false：切换fragment
     */
    private void hideOthersFragment(Fragment showFragment, boolean add) {
        transition = fragmentManager.beginTransaction();
        if (add)
            transition.add(R.id.fm_main_index, showFragment);
        for (Fragment fragment : fragments) {
            if (showFragment.equals(fragment)) {
                transition.show(fragment);
            } else {
                transition.hide(fragment);
            }
        }
        transition.commit();
    }

}
