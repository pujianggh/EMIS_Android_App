package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StrRes;
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
    private int mType = 30002;
    private String mTitle = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_list);
        ButterKnife.bind(this);

        mType = getIntent().getIntExtra(StrRes.INSTANCE.getType(), 30002);
        switch (mType) {
            case 30002://待处理工单
                mTitle = "待处理工单";
                break;
            case 30003://待派批工单
                mTitle = "待派批工单";
                break;
            case 30004://待审批工单
                mTitle = "待审批工单";
                break;
            case 30005://待存档工单
                mTitle = "待存档工单";
                break;
        }
        setTitleBarLayout(R.drawable.icon_back_white_bar, mTitle, null, true);

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
