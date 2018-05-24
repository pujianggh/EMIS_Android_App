package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkOrderQueryListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.handle.DatePickerHandle;
import com.android.ts.emis.mode.WorkOrderListBean;
import com.android.ts.emis.utils.ThreadUtil;
import com.libcommon.action.utils.DateToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 工作-工单列表查询
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.tv_agoMonth)
    TextView tvAgoMonth;
    @BindView(R.id.tv_newMonth)
    TextView tvNewMonth;
    @BindView(R.id.tv_nextMonth)
    TextView tvNextMonth;

    private WorkOrderQueryListAdapter mAdapter;
    private WorkOrderListBean moduleBean;
    private DatePickerHandle mDatePickerHandle;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_query_list);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "工单查询", true);

        initData();
    }

    @OnClick({R.id.tv_agoMonth, R.id.tv_newMonth, R.id.tv_nextMonth})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_agoMonth:
                break;
            case R.id.tv_newMonth:
                mDatePickerHandle.showTimePicker();
                break;
            case R.id.tv_nextMonth:
                break;
        }
    }

    private void initData() {
        tvNewMonth.setText(DateToolsUtil.getNewDateYM());
        mDatePickerHandle = new DatePickerHandle(this, tvNewMonth);
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                ThreadUtil.INSTANCE.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        rlRootRefresh.endRefreshing();
                        mAdapter.notifyDataSetChanged();
                    }
                }, 2000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                ThreadUtil.INSTANCE.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        rlRootRefresh.endLoadingMore();
                    }
                }, 1000);
                return true;
            }
        });

        mAdapter = new WorkOrderQueryListAdapter(this);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getWorkOrderListModuleData();
        mAdapter.setData(moduleBean.getData());
    }
}
