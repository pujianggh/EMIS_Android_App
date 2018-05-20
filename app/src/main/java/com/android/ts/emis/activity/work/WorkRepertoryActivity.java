package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkModule2Adapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.handle.RecycleViewDivider;
import com.android.ts.emis.mode.WorkModuleBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工作-库存
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkRepertoryActivity extends BaseActivity {
    @BindView(R.id.igv_ewm)
    ImageView igvEwm;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;

    private WorkModule2Adapter mWorkModule2Adapter;
    private WorkModuleBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_repertory);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, "库存管理", true);

        initData();
    }

    private void initData() {
        moduleBean = DataCenter.getWorkRepertoryModuleData();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvContent.setLayoutManager(layoutManager);
        rlvContent.addItemDecoration(new RecycleViewDivider(mAPPApplication));
        mWorkModule2Adapter = new WorkModule2Adapter(this, moduleBean.getBody());
        rlvContent.setAdapter(mWorkModule2Adapter);
    }

    @OnClick({R.id.igv_ewm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.igv_ewm:
                showToast("去扫一扫");
                break;
        }
    }
}
