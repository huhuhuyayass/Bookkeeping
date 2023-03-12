package com.example.jizhangben;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {    //给ListView添加适配器
    List<costList> mList;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(List<costList> list){
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();  //获取数据长度
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);   //适配器放了很多条数据，获取数据所在的位置
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.list_item,null);
        //取出数据赋值
        costList item = mList.get(position);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_date = view.findViewById(R.id.tv_date);
        TextView tv_money = view.findViewById(R.id.tv_money);
        //绑定
        tv_title.setText(mList.get(position).getTitle());
        tv_date.setText(mList.get(position).getDate());
        tv_money.setText(mList.get(position).getMoney());
        return view;
    }

    public ListAdapter(Context context,List<costList> list){
        mList = list;
        //通过外部传来的Context初始化LayoutInflater对象
        mLayoutInflater = LayoutInflater.from(context);
    }
}
