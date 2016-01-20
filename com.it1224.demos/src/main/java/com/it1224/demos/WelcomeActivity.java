package com.it1224.demos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WelcomeActivity extends Activity {


    private TextView text1;

    private void assignViews() {
        text1 = (TextView) findViewById(android.R.id.text1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    class WelcomeAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(WelcomeActivity.this,R.layout.app_btn,null);

            return view;

        }
    }
}
