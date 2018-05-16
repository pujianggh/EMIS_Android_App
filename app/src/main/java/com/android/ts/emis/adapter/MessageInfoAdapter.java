package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.MessageInfoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 消息列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageInfoAdapter extends CommonBaseAdapter<MessageInfoBean.BodyBean.DataBean> {

    public MessageInfoAdapter(Context context, List<MessageInfoBean.BodyBean.DataBean> data) {
        super(context);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message_info, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MessageInfoBean.BodyBean.DataBean bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.viewLine.setVisibility(View.VISIBLE);
            if ((position + 1) == getCount()) {
                viewHolder.viewLine.setVisibility(View.GONE);
            }
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.igv_icon)
        ImageView igvIcon;
        @BindView(R.id.view_line)
        View viewLine;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
