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
 * 名称：ChartActivity
 * 描述：图表
 *
 * @author 还如一梦中
 * @date 2011-12-13
 */
public class ChartActivity extends AbActivity {

    private BaseApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAbContentView(R.layout.chart_main);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.chart_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        application = (BaseApplication) abApplication;
        Button xyLineChart = (Button) this.findViewById(R.id.xyLineChart);
        Button xyBarChart = (Button) this.findViewById(R.id.xyBarChart);
        Button pieChart = (Button) this.findViewById(R.id.pieChart);
        Button timeChart = (Button) this.findViewById(R.id.timeChart);
        Button areaChart = (Button) this.findViewById(R.id.areaChart);
        Button levelChart = (Button) this.findViewById(R.id.levelChart);

        levelChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, LevelChartActivity.class);
                startActivity(intent);
            }
        });


        xyLineChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, XYLineChartActivity.class);
                startActivity(intent);
            }
        });

        xyBarChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, XYBarChartActivity.class);
                startActivity(intent);
            }
        });

        pieChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, PieChartActivity.class);
                startActivity(intent);
            }
        });

        timeChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, TimeChartActivity.class);
                startActivity(intent);
            }
        });

        areaChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, XYAreaChartActivity.class);
                startActivity(intent);
            }
        });
    }

}
