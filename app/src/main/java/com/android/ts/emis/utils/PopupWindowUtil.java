package com.android.ts.emis.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.android.ts.emis.R;

/**
 * PopupWindow管理
 *
 * @author pujiang
 * @date 2018-6-9 18:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class PopupWindowUtil {
    private Context mContext;

    public PopupWindowUtil(Context context) {
        this.mContext = context;
    }

    //选择
    public interface OnPopuwindowClick {
        void onPopuwindowClick(int id);
    }

    /**
     * 工单详细菜单
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showWorkOrderDetailsWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_details, null);
        final ImageView igv_clwc = (ImageView) view.findViewById(R.id.igv_clwc);
        final ImageView igv_qx = (ImageView) view.findViewById(R.id.igv_qx);
        final LinearLayout llyRoot = (LinearLayout) view.findViewById(R.id.lly_window_root);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.3f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(locationView);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        igv_clwc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        igv_qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
    }

    /**
     * 创建工单对话框展示
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showWorkOrderCreateWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_select, null);
        final ImageView igvAdd = (ImageView) view.findViewById(R.id.igv_add);
        final ImageView igvEwm = (ImageView) view.findViewById(R.id.igv_ewm);
        final LinearLayout llyRoot = (LinearLayout) view.findViewById(R.id.lly_window_root);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        /**
         Resources resources = mContext.getResources();
         Drawable drawable = resources.getDrawable(android.R.color.black);
         //popupWindow.setBackgroundDrawable(new BitmapDrawable());
         //drawable.mutate().setAlpha(80);
         llyRoot.getBackground().mutate().setAlpha(80);
         popupWindow.setBackgroundDrawable(drawable);
         **/
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.3f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //popupWindow.showAtLocation(locationView, Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        popupWindow.showAsDropDown(locationView);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        igvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        igvEwm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
