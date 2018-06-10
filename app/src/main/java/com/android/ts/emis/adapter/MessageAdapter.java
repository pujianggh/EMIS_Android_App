package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.WorkOrderDetailsActivity;
import com.android.ts.emis.activity.work.WorkPollingActivity;
import com.android.ts.emis.mode.MessageInfoBean;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.swipeitemlayout.BGASwipeItemLayout;

/**
 * 多项目选择
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
    protected void fillData(BGAViewHolderHelper viewHolderHelper, final int position, final MessageInfoBean.Data model) {
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
            swipeItemLayout.setSwipeAble(false);//不能滑动
        } else {
            swipeItemLayout.setSwipeAble(true);
        }

        if (position < 2) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_pd);
            viewHolderHelper.setText(R.id.tv_state, "派工");
        } else if (position < 4) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_sh);
            viewHolderHelper.setText(R.id.tv_state, "审核");
        } else if (position < 5) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_wg);
            viewHolderHelper.setText(R.id.tv_state, "完工");
        } else {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_yz);
            viewHolderHelper.setText(R.id.tv_state, "验证");
        }

        viewHolderHelper.getView(R.id.lly_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < 3) {
                    mContext.startActivity(new Intent(mContext, WorkPollingActivity.class));
                } else {
                    mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class).putExtra(StrRes.INSTANCE.getTitle(), model.getTitle()));
                }
            }
        });

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
