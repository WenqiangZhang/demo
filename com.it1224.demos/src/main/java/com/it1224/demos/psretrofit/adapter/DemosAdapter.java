package com.it1224.demos.psretrofit.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.it1224.demos.R;
import com.it1224.demos.base.ABaseAdapter;
import com.it1224.demos.entity.DemoInfo;

import java.util.List;

/**
 * Created by lenovo on 2016/1/18.
 */
public class DemosAdapter extends ABaseAdapter<DemoInfo> {

    public DemosAdapter(Context context, List<DemoInfo> data) {
        super(context, data);
    }

    @Override
    public View convert(int position, View convertView, ViewGroup parent) {
        ViewHolder h = null;
        if(convertView == null){
            convertView = getView(R.layout.item_ls_demos);
            h = new ViewHolder();
            h.time = getTextView(convertView,R.id.time);
            h.name = getTextView(convertView,R.id.name);
            h.decription = getTextView(convertView,R.id.description);
            convertView.setTag(h);
        }else{
            h = (ViewHolder) convertView.getTag();
        }
        DemoInfo demo = getItem(position);
        h.time.setText("创建时间："+demo.getTime());
        h.name.setText("范例名称："+demo.getName());
        h.decription.setText("范例内容：\n"+demo.getDescription());

        return convertView;
    }

    class ViewHolder {
        public TextView time,name,decription;
    }
}
