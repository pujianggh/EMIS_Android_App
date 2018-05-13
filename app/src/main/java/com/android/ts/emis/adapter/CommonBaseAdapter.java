package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 基类Adapter
 *
 * @author pujiang
 * @date 2018-5-13 22:22
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class CommonBaseAdapter<T> extends BaseAdapter {
    protected List<T> data = new ArrayList<T>();
    protected Context context;

    public CommonBaseAdapter(Context context) {
        this.context = context;
    }

    public CommonBaseAdapter(Context context, List<T> datas) {
        this(context);
        this.data = datas;
    }

    public int getCount() {
        return data == null ? 0 : data.size();
    }

    public T getItem(int position) {
        return data == null ? null : data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);
}
