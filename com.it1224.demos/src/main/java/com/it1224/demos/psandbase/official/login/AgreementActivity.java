package com.it1224.demos.psandbase.official.login;

import android.os.Bundle;

import com.ab.activity.AbActivity;
import com.ab.view.titlebar.AbTitleBar;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;

public class AgreementActivity extends AbActivity {

    private BaseApplication application;
    private AbTitleBar mAbTitleBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.agreement);
        application = (BaseApplication) abApplication;

        mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(R.string.agreement_name);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.mipmap.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.mipmap.line);
        this.setTitleBarOverlay(true);

    }

}
