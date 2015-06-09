package com.hoollyzhang.hlib.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by brzhang on 15/6/8.
 * Description : 通用adapter
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected       Context        mContext;
    protected       List<T>        mDatas;
    protected final int            mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount()
    {
        return mDatas.size();
    }

    @Override
    public T getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder viewHolder = getViewHolder(convertView, parent);
        //赋值操作
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();

    }

    /**
     * 哪个控件需要你去赋值，在这里面自己撸吧
     * @param helper
     * @param item
     */
    public abstract void convert(ViewHolder helper, T item);

    private ViewHolder getViewHolder(View convertView, ViewGroup parent)
    {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId);
    }


}
