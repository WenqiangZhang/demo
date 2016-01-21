package com.it1224.demos.psandbase.official.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ab.activity.AbActivity;
import com.ab.view.slidingmenu.SlidingMenu;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;

public class SlidingMenuLeftActivity extends AbActivity {

    private SlidingMenu menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.sliding_menu_content);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.sliding_menu_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_menu);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);

        //主视图的Fragment添加
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new FragmentLoad())
                .commit();

        //SlidingMenu的配置
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        //menu视图的Fragment添加
        menu.setMenu(R.layout.sliding_menu_menu);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new FragmentLoad())
                .commit();

        mAbTitleBar.getLogoView().setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (menu.isMenuShowing()) {
                    menu.showContent();
                } else {
                    menu.showMenu();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (menu.isMenuShowing()) {
            menu.showContent();
        } else {
            super.onBackPressed();
        }
    }

}