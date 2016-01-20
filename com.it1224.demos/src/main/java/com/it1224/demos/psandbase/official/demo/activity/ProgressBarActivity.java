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
 * 名称：ProgressBarActivity
 * 描述：2种漂亮的进度条
 *
 * @author 还如一梦中
 * @date 2011-12-13
 */
public class ProgressBarActivity extends AbActivity {

    private BaseApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAbContentView(R.layout.progress_bar_main);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.progressbar_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        application = (BaseApplication) abApplication;
        Button mCircleView = (Button) this.findViewById(R.id.mCircleView);
        Button mHorizontalView = (Button) this.findViewById(R.id.mHorizontalView);

        mCircleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressBarActivity.this, ProgressBarCircleActivity.class);
                startActivity(intent);
            }
        });

        mHorizontalView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressBarActivity.this, ProgressBarHorizontalActivity.class);
                startActivity(intent);
            }
        });

    }

}
