package com.example.fontdemo;

import com.balysv.materialmenu.MaterialMenuIcon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class DrawerFeatureActivity extends FragmentActivity {
	
	 /** DrawerLayout */  
    private DrawerLayout mDrawerLayout;  
    /** ������˵� */  
    private ListView mMenuListView;  
    /** �ұ��� */  
    private RelativeLayout right_drawer;  
    /** �˵��б� */  
    private String[] mMenuTitles;  
    /** Material Design��� */  
    private MaterialMenuIcon mMaterialMenuIcon;  
    /** �˵���/�ر�״̬ */  
    private boolean isDirection_left = false;  
    /** �ұ�����/�ر�״̬ */  
    private boolean isDirection_right = false;  
    private View showView;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dawer_feature);
	}
	
	 /** 
     * ���ز˵� 
     */  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    } 
}
