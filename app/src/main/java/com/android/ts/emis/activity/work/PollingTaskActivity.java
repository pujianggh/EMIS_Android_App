package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.ContentPagerAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.fragment.PollTaskListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-巡检-任务
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollingTaskActivity extends BaseActivity {
    @BindView(R.id.btn_tabLeft)
    Button btnTabLeft;
    @BindView(R.id.btn_tabCenter)
    Button btnTabCenter;
    @BindView(R.id.btn_tabRight)
    Button btnTabRight;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    private ContentPagerAdapter mContentPagerAdapter;
    private Fragment[] fragments;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_polling_task);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "巡检任务", true);

        initData();
    }

    @OnClick({R.id.btn_tabLeft, R.id.btn_tabCenter, R.id.btn_tabRight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tabLeft:
                setCurrentPage(0);
                break;
            case R.id.btn_tabCenter:
                setCurrentPage(1);
                break;
            case R.id.btn_tabRight:
                setCurrentPage(2);
                break;
        }
    }

    private void initData() {
        btnTabLeft.setText("全 部(15)");
        btnTabCenter.setText("未同步(0)");
        btnTabRight.setText("未完成(15)");
        fragments = new Fragment[3];
        Bundle bundle = new Bundle();
        fragments[0] = new PollTaskListFragment();//完成
        bundle.putInt(StrRes.INSTANCE.getType(), 1);
        fragments[0].setArguments(bundle);

        fragments[1] = new PollTaskListFragment();//未同步
        bundle.putInt(StrRes.INSTANCE.getType(), 2);
        fragments[1].setArguments(bundle);

        fragments[2] = new PollTaskListFragment();//未完成
        bundle.putInt(StrRes.INSTANCE.getType(), 3);
        fragments[2].setArguments(bundle);

        mContentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager(), fragments);
        vpView.setAdapter(mContentPagerAdapter);
        vpView.setOffscreenPageLimit(3);//让ViewPager缓存2个页面
        vpView.setCurrentItem(0);//设置默认打开第一页
        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setCurrentPage(0);
    }

    /**
     * 选择卡切换
     *
     * @param current
     */
    private void setCurrentPage(int current) {
        btnTabLeft.setSelected(false);
        btnTabLeft.setBackgroundResource(R.drawable.button_tar_left);
        btnTabCenter.setSelected(false);
        btnTabCenter.setBackgroundResource(R.drawable.button_tar_center);
        btnTabRight.setSelected(false);
        btnTabRight.setBackgroundResource(R.drawable.button_tar_right);
        if (current == 0) {
            btnTabLeft.setSelected(true);
            btnTabLeft.setBackgroundResource(R.drawable.button_tar_left_select);
        } else if (current == 1) {
            btnTabCenter.setSelected(true);
            btnTabCenter.setBackgroundResource(R.drawable.button_tar_center_select);
        } else if (current == 2) {
            btnTabRight.setSelected(true);
            btnTabRight.setBackgroundResource(R.drawable.button_tar_right_select);
        }
    }
}
