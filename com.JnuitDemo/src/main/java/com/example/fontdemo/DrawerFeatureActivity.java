package com.example.fontdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.balysv.materialmenu.MaterialMenuIcon;

public class DrawerFeatureActivity extends FragmentActivity {

    /** DrawerLayout */
    private DrawerLayout mDrawerLayout;
    /** 左边栏菜单 */
    private ListView mMenuListView;
    /** 右边栏 */
    private RelativeLayout right_drawer;
    /** 菜单列表 */
    private String[] mMenuTitles;
    /** Material Design风格 */
    private MaterialMenuIcon mMaterialMenuIcon;
    /** 菜单打开/关闭状态 */
    private boolean isDirection_left = false;
    /** 右边栏打开/关闭状态 */
    private boolean isDirection_right = false;
    private View showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dawer_feature);
    }

    /**
     * 加载菜单 
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
