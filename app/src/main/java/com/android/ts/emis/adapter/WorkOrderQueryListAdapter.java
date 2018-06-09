package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.WorkOrderListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工单查询列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryListAdapter extends CommonBaseAdapter<WorkOrderListBean.Data> {

    public WorkOrderQueryListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_work_order_query_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        WorkOrderListBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvOrderCode.setText(bean.getOrderCode());
            viewHolder.tvOrderStatus.setText(bean.getOrderStatus());
            if ("0".equals(bean.getState())) {
                viewHolder.tvState.setText("已创建");
            } else if ("1".equals(bean.getState())) {
                viewHolder.tvState.setText("暂停");
            } else if ("2".equals(bean.getState())) {
                viewHolder.tvState.setText("待处理");
            } else {
                viewHolder.tvState.setText("已创建");
            }
            viewHolder.tvPfmCode.setText(bean.getPfmCode());
            viewHolder.tvOrderDescribe.setText(bean.getOrderDescribe());
            viewHolder.tvCreateTime.setText(bean.getCreateTime());
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv_orderCode)
        TextView tvOrderCode;
        @BindView(R.id.tv_orderStatus)
        TextView tvOrderStatus;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_pfmCode)
        TextView tvPfmCode;
        @BindView(R.id.tv_createTime)
        TextView tvCreateTime;
        @BindView(R.id.tv_orderDescribe)
        TextView tvOrderDescribe;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
