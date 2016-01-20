package com.it1224.demos.psretrofit.activity;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.it1224.demos.base.ABaseAdapter;
import com.it1224.demos.global.AppConfig;
import com.it1224.demos.psretrofit.ClientAPI.APIClient;
import com.it1224.demos.psretrofit.entity.Contributor;
import com.it1224.demos.psretrofit.respinterface.IGitHub;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitActivity extends ListActivity {

    ListView mListView;
    Callback<List<Contributor>> callback = new Callback<List<Contributor>>() {

        @Override
        public void success(List<Contributor> contributors, Response response) {
            mListView.setAdapter(new GitHubAdapter(RetrofitActivity.this, contributors));
        }

        @Override
        public void failure(RetrofitError error) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        APIClient.createConvertApi(this, IGitHub.class, AppConfig.DemoHost.RETROFIT_ENDPOINT).contributors("square", "retrofit", callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    class GitHubAdapter extends ABaseAdapter<Contributor> {

        public GitHubAdapter(Context context, List<Contributor> data) {
            super(context, data);
        }

        @Override
        public View convert(int position, View convertView, ViewGroup parent) {
            ViewHolder h = null;
            if (convertView == null) {
                convertView = getView(android.R.layout.simple_list_item_1);
                h = new ViewHolder();
                h.tv = getTextView(convertView, android.R.id.text1);
                convertView.setTag(h);
            } else {
                h = (ViewHolder) convertView.getTag();
            }
            h.tv.setTextColor(Color.parseColor("#333333"));
            h.tv.setText(getItem(position).toString());
            return convertView;
        }

        class ViewHolder {
            TextView tv;
        }
    }
}
