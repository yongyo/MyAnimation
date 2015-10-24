package com.example.trial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bean.People;
import com.example.myanimation.myanimation.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2015/10/7.
 */
public class MyAdapter extends BaseAdapter {
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    private List<People> list;
    Context mContext;

    public MyAdapter(List<People> list, Context mContext) {

        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
//        return 5;
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if ( convertView==null){

            convertView=LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
            viewHolder=new ViewHolder();
            convertView.setTag(viewHolder);
            viewHolder.mane= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.phoneNumber= (TextView) convertView.findViewById(R.id.tv_number);
            viewHolder.address= (TextView) convertView.findViewById(R.id.tv_address);
        }else{
        viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.mane.setText(list.get(position).getName());
        viewHolder.phoneNumber.setText(list.get(position).getPhoneNumber());
        viewHolder.address.setText(list.get(position).getAddress());
        return convertView;
    }
//    class MyCompartor implements Comparator {
//        @Override
//        public int compare(Object lhs, Object rhs) {
//            return (getSortKey(((People) lhs).getSort_key())).compareTo (getSortKey(((People) rhs).getSort_key()));
//        }
//    };

     static class ViewHolder{
        TextView mane;
         TextView phoneNumber;
         TextView address;
    }
}
