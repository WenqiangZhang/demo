package org.goodev.retrofitdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by lenovo on 2016/1/13.
 */
public abstract class ABaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> data;
    protected LayoutInflater inflater;
    protected BitmapUtils bitmapUtils;
    private int location;

    public ABaseAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        location = position;
        return convert(position, convertView, parent);
    }

    public void add(T t) {
        data.add(t);
        notifyDataSetChanged();
    }

    public void addAll(List<T> ts) {
        data.addAll(ts);
        notifyDataSetChanged();
    }

    public void remove(T t) {
        data.remove(t);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void set(T t) {
        data.set(location, t);
        notifyDataSetChanged();
    }

    public void set(int location, T t) {
        data.set(location, t);
        notifyDataSetChanged();
    }

    public final TextView getTextView(View view, int id) {
        return (TextView) view.findViewById(id);
    }

    public final ImageView getImageView(View view, int id) {
        return (ImageView) view.findViewById(id);
    }

    public final View getView(int layoutId) {
        return inflater.inflate(layoutId, null);
    }

    public abstract View convert(int position, View convertView, ViewGroup parent);
}
