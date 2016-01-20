package com.it1224.demos.psandbase.official.demo.activity;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ab.activity.AbActivity;
import com.ab.view.app.AbCalendar;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

import java.util.ArrayList;
import java.util.List;

public class DeskCalendarActivity extends AbActivity {

    private BaseApplication application;
    private AbTitleBar mAbTitleBar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.desk_calendar);
        application = (BaseApplication) abApplication;

        mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.desk_calendar_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        initTitleRightLayout();

        Drawable caleBg = this.getResources().getDrawable(R.mipmap.desk_calendar);
        Drawable caleDot = null;
        Point posYear = new Point(60, 80);
        List<Drawable> dYearArray = new ArrayList<Drawable>();
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year0));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year1));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year2));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year3));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year4));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year5));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year6));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year7));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year8));
        dYearArray.add(this.getResources().getDrawable(R.mipmap.year9));


        Point posMonth = new Point(300, 80);
        List<Drawable> dMonthArray = new ArrayList<Drawable>();
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month1));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month2));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month3));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month4));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month5));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month6));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month7));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month8));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month9));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month10));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month11));
        dMonthArray.add(this.getResources().getDrawable(R.mipmap.month12));

        Point posDate = new Point(90, 180);
        List<Drawable> dDateArray = new ArrayList<Drawable>();
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date0));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date1));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date2));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date3));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date4));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date5));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date6));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date7));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date8));
        dDateArray.add(this.getResources().getDrawable(R.mipmap.date9));

        Point posWeek = new Point(322, 235);
        List<Drawable> dWeekArray = new ArrayList<Drawable>();

        AbCalendar view = new AbCalendar(this, caleBg, caleDot, posYear, dYearArray,
                posMonth, dMonthArray, posDate, dDateArray, posWeek,
                dWeekArray);

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


