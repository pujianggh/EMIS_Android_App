package com.android.ts.emis.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.ProjectMessageAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.ProjectMessageBean;
import com.android.ts.emis.utils.ThreadUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 多项目信息
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class ProjectMessageActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private ProjectMessageAdapter mAdapter;
    private ProjectMessageBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_project_message);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "项目选择", true);

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
                return false;
            }
        });

        mAdapter = new ProjectMessageAdapter(mAPPApplication);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getProjectMessageModuleData();
        mAdapter.setData(moduleBean.getData());
        lvListData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setResult(RESULT_OK, new Intent().putExtra(StrRes.INSTANCE.getMode(), moduleBean.getData().get(position)));
                onBackPressed();
            }
        });
    }
}
