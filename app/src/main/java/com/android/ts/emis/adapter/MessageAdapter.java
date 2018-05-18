package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.View;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.MessageInfoBean;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.swipeitemlayout.BGASwipeItemLayout;

/**
 * 信息中心
 *
 * @author pujiang
 * @date 2018-5-18 16:15
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageAdapter extends BGAAdapterViewAdapter<MessageInfoBean.Data> {
    //当前处于打开状态的item
    private List<BGASwipeItemLayout> mOpenedSil = new ArrayList<>();

    public MessageAdapter(Context context) {
        super(context, R.layout.item_message);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.swipe_root);
        swipeItemLayout.setDelegate(new BGASwipeItemLayout.BGASwipeItemLayoutDelegate() {
            @Override
            public void onBGASwipeItemLayoutOpened(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
                mOpenedSil.add(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutClosed(BGASwipeItemLayout swipeItemLayout) {
                mOpenedSil.remove(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutStartOpen(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
            }
        });
        viewHolderHelper.setItemChildClickListener(R.id.tv_delete);
    }

    @Override
    protected void fillData(BGAViewHolderHelper viewHolderHelper, int position, MessageInfoBean.Data model) {
        viewHolderHelper.setText(R.id.tv_date, model.getDate());
        viewHolderHelper.setText(R.id.tv_title, model.getTitle());
        viewHolderHelper.setText(R.id.tv_message, model.getMessage());
        if ("0".equals(model.getState())) {
            viewHolderHelper.getView(R.id.igv_tips).setVisibility(View.VISIBLE);
        } else {
            viewHolderHelper.getView(R.id.igv_tips).setVisibility(View.GONE);
        }
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.swipe_root);
        if (position % 3 == 0) {
            swipeItemLayout.setSwipeAble(false);
        } else {
            swipeItemLayout.setSwipeAble(true);
        }
    }

    /**
     * 关闭滑动开关
     */
    public void closeOpenedSwipeItemLayoutWithAnim() {
        for (BGASwipeItemLayout sil : mOpenedSil) {
            sil.closeWithAnim();
        }
        mOpenedSil.clear();
    }

    /**
     * 清除滑动开关
     */
    public void closeOpenedSwipeItemLayout() {
        for (BGASwipeItemLayout sil : mOpenedSil) {
            sil.close();
        }
        mOpenedSil.clear();
    }
}