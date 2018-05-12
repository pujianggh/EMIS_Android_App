package com.android.ts.emis.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkModuleAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.mode.WorkModuleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页-工作信息
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkFragment extends BaseFragment {
    @BindView(R.id.rly_work_bill)
    RelativeLayout rlyWorkBill;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;

    private WorkModuleAdapter mWorkModuleAdapter;
    private List<WorkModuleBean.BodyBean> mDatas;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_wrok);
        unBinder = ButterKnife.bind(this, mContentView);

        initData();
    }

    private void initData() {
        rlyWorkBill.getBackground().setAlpha(100);
        mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean;
        for (int i = 1; i <= 9; i++) {
            bodyBean = new WorkModuleBean.BodyBean();
            bodyBean.setName("工单" + i);
            bodyBean.setCount("" + i * i);
            mDatas.add(bodyBean);
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvContent.setLayoutManager(layoutManager);
        mWorkModuleAdapter = new WorkModuleAdapter(getActivity(), mDatas);
        rlvContent.setAdapter(mWorkModuleAdapter);
    }
}
