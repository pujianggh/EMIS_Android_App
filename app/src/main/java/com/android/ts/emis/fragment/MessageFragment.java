package com.android.ts.emis.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.CommonWebActivity;
import com.android.ts.emis.adapter.MessageAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.utils.ThreadUtil;
import com.libcommon.action.utils.LogAPPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 首页-消息中心
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageFragment extends BaseFragment {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.tv_title_bar)
    TextView tvTitleBar;

    private MessageAdapter mAdapter;
    private MessageInfoBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_message);
        unBinder = ButterKnife.bind(this, mContentView);

        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setRefreshScaleDelegate(new BGARefreshLayout.BGARefreshScaleDelegate() {
            @Override
            public void onRefreshScaleChanged(float scale, int moveYDistance) {
                LogAPPUtil.i("@----->setRefreshScaleDelegate----->scale:" + scale + " moveYDistance:" + moveYDistance);
            }
        });
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                showToast("下拉加载最新");
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
                showToast("上拉加载最新");
                ThreadUtil.INSTANCE.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        rlRootRefresh.endLoadingMore();
                    }
                }, 2000);
                return true;
            }
        });

        mAdapter = new MessageAdapter(mAPPApplication);
        moduleBean = DataCenter.getMessageModuleData();
        lvListData.setAdapter(mAdapter);
        mAdapter.setData(moduleBean.getData());
    }

    @OnClick({R.id.tv_title_bar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_title_bar:
                startActivity(new Intent(getActivity(), CommonWebActivity.class));
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null) unBinder.unbind();
    }
}
