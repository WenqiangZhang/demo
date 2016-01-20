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
 * 名称：DBActivity
 * 描述：本地数据库相关
 *
 * @author 还如一梦中
 * @date 2011-12-13
 */
public class DBActivity extends AbActivity {

    private BaseApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAbContentView(R.layout.db_main);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.db_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        application = (BaseApplication) abApplication;
        Button insideSample = (Button) this.findViewById(R.id.insideSample);
        Button sdSample = (Button) this.findViewById(R.id.sdSample);
        Button one2one = (Button) this.findViewById(R.id.one2one);
        Button one2many = (Button) this.findViewById(R.id.one2many);
        Button object = (Button) this.findViewById(R.id.object);

        insideSample.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBActivity.this, DBInsideSampleActivity.class);
                startActivity(intent);
            }
        });

        sdSample.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBActivity.this, DBSDSampleActivity.class);
                startActivity(intent);
            }
        });


        one2one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBActivity.this, DBOne2OneActivity.class);
                startActivity(intent);
            }
        });

        one2many.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBActivity.this, DBOne2ManyActivity.class);
                startActivity(intent);
            }
        });

        object.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DBActivity.this, DBObjectActivity.class);
                startActivity(intent);
            }
        });


    }

}
