package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.widget.ListView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkOrderListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.WorkOrderListBean;
import com.android.ts.emis.utils.ThreadUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 工作-工单列表
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private WorkOrderListAdapter mAdapter;
    private WorkOrderListBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_list);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "工单列表", true);

        initData();
    }

    private void initData() {
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

        mAdapter = new WorkOrderListAdapter(mAPPApplication);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getWorkOrderListModuleData();
        mAdapter.setData(moduleBean.getData());
    }
}
