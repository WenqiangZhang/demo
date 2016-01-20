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
 * 名称：CarouselActivity
 * 描述：旋转木马
 *
 * @author 还如一梦中
 * @date 2011-12-13
 */
public class CarouselActivity extends AbActivity {

    private BaseApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAbContentView(R.layout.carousel_main);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.carousel_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        application = (BaseApplication) abApplication;
        Button btn1 = (Button) this.findViewById(R.id.btn1);
        Button btn2 = (Button) this.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarouselActivity.this, CarouselImageActivity.class);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarouselActivity.this, CarouselViewActivity.class);
                startActivity(intent);
            }
        });


    }

}
