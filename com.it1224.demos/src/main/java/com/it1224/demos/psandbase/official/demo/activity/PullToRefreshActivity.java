package com.it1224.demos.psandbase.official.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ab.activity.AbActivity;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

/**
 * 名称：PullToRefreshActivity 描述：下拉刷新分页
 *
 * @author 还如一梦中
 * @date 2011-12-13
 */
public class PullToRefreshActivity extends AbActivity {

    private BaseApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAbContentView(R.layout.pull_to_refresh_main);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.pull_list_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        application = (BaseApplication) abApplication;
        Button mListView = (Button) this.findViewById(R.id.mListView);
        Button mSampleView = (Button) this.findViewById(R.id.mSampleView);
        Button mGridView = (Button) this.findViewById(R.id.mGridView);
        Button mMultiListView = (Button) this.findViewById(R.id.mMultiListView);

        mSampleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PullToRefreshActivity.this,
                        PullToRefreshViewActivity.class);
                startActivity(intent);
            }
        });

        mListView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PullToRefreshActivity.this,
                        PullToRefreshListActivity.class);
                startActivity(intent);
            }
        });

        mGridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PullToRefreshActivity.this,
                        PullToRefreshGridActivity.class);
                startActivity(intent);
            }
        });

        mMultiListView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PullToRefreshActivity.this,
                        PullToRefreshMultiColumnListActivity.class);
                startActivity(intent);
            }
        });

    }

}
