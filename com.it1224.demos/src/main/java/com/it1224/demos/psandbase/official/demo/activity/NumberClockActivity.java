package com.it1224.demos.psandbase.official.demo.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ab.activity.AbActivity;
import com.ab.view.app.AbNumberClock;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

import java.util.ArrayList;
import java.util.List;

public class NumberClockActivity extends AbActivity {

    private BaseApplication application;
    private AbTitleBar mAbTitleBar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.number_clock);
        application = (BaseApplication) abApplication;

        mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.number_clock_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        initTitleRightLayout();

        Drawable timeBg = this.getResources().getDrawable(R.mipmap.timer_bg);
        Drawable timeColon = this.getResources().getDrawable(R.mipmap.timer_colon);

        List<Drawable> dTimeArray = new ArrayList<Drawable>();
        List<Drawable> dApmArray = new ArrayList<Drawable>();

        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time0));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time1));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time2));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time3));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time4));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time5));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time6));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time7));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time8));
        dTimeArray.add(this.getResources().getDrawable(R.mipmap.time9));

        //AM 和PM的图标
        //dApmArray.add(this.getResources().getDrawable(R.drawable.time0));
        //dApmArray.add(this.getResources().getDrawable(R.drawable.time1));


        AbNumberClock view = new AbNumberClock(this, timeBg, timeColon, dTimeArray, dApmArray);
        LinearLayout contentLayout = (LinearLayout) this.findViewById(R.id.contentLayout);
        contentLayout.addView(view);

    }


    private void initTitleRightLayout() {
        mAbTitleBar.clearRightView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initTitleRightLayout();
    }

    public void onPause() {
        super.onPause();
    }

}


