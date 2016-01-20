package com.it1224.demos.psandbase.official.demo.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.ab.activity.AbActivity;
import com.ab.fragment.AbDialogFragment.AbDialogOnLoadListener;
import com.ab.fragment.AbLoadDialogFragment;
import com.ab.task.AbTask;
import com.ab.task.AbTaskItem;
import com.ab.task.AbTaskListener;
import com.ab.util.AbDialogUtil;
import com.ab.view.pullview.AbPullToRefreshView;
import com.ab.view.pullview.AbPullToRefreshView.OnFooterLoadListener;
import com.ab.view.pullview.AbPullToRefreshView.OnHeaderRefreshListener;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

import java.util.Random;

public class PullToRefreshViewActivity extends AbActivity implements OnHeaderRefreshListener, OnFooterLoadListener {

    private BaseApplication application;
    private AbPullToRefreshView mAbPullToRefreshView = null;
    private TextView mTextView = null;
    private AbLoadDialogFragment mDialogFragment = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.pull_to_refresh_view);
        application = (BaseApplication) abApplication;

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.pull_list_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        //获取ListView对象
        mAbPullToRefreshView = (AbPullToRefreshView) this.findViewById(R.id.mPullRefreshView);
        mTextView = (TextView) this.findViewById(R.id.mTextView);

        //设置监听器
        mAbPullToRefreshView.setOnHeaderRefreshListener(this);
        mAbPullToRefreshView.setOnFooterLoadListener(this);

        //设置进度条的样式
        mAbPullToRefreshView.getHeaderView().setHeaderProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular));
        mAbPullToRefreshView.getFooterView().setFooterProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular));

        //显示进度框
        mDialogFragment = AbDialogUtil.showLoadDialog(this, R.mipmap.ic_load, "查询中,请等一小会");
        mDialogFragment
                .setAbDialogOnLoadListener(new AbDialogOnLoadListener() {

                    @Override
                    public void onLoad() {
                        // 下载网络数据
                        refreshTask();
                    }

                });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public void onFooterLoad(AbPullToRefreshView view) {
        loadMoreTask();
    }

    @Override
    public void onHeaderRefresh(AbPullToRefreshView view) {
        refreshTask();
    }


    public void refreshTask() {
        AbTask mAbTask = AbTask.newInstance();
        final AbTaskItem item = new AbTaskItem();
        item.setListener(new AbTaskListener() {

            @Override
            public void update() {
                AbDialogUtil.removeDialog(PullToRefreshViewActivity.this);
                mTextView.setText("This is " + new Random().nextInt(100));
                mAbPullToRefreshView.onHeaderRefreshFinish();
            }

            @Override
            public void get() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }

            ;
        });

        mAbTask.execute(item);
    }

    public void loadMoreTask() {
        AbTask mAbTask = AbTask.newInstance();
        final AbTaskItem item = new AbTaskItem();
        item.setListener(new AbTaskListener() {

            @Override
            public void update() {
                AbDialogUtil.removeDialog(PullToRefreshViewActivity.this);
                mTextView.append("+" + new Random().nextInt(100));
                mAbPullToRefreshView.onFooterLoadFinish();
            }

            @Override
            public void get() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }

            ;
        });

        mAbTask.execute(item);
    }

}


