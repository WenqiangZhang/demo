package com.it1224.demos.psandbase.official.login;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ab.activity.AbActivity;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

public class AboutActivity extends AbActivity {

    private BaseApplication application;
    String version = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.about);

        AbTitleBar mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.about);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);
        //mAbTitleBar.setVisibility(View.GONE);
        //设置AbTitleBar在最上
        this.setTitleBarOverlay(true);
        application = (BaseApplication) abApplication;
        mAbTitleBar.getLogoView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView version_val = ((TextView) findViewById(R.id.version_val));

        try {
            PackageInfo pinfo = getPackageManager().getPackageInfo("com.andbase", PackageManager.GET_CONFIGURATIONS);
            version = pinfo.versionName;
            version_val.setText("V" + version);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


