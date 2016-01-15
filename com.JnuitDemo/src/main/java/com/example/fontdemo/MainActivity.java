package com.example.fontdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	boolean flag = true;
	private ImageView mMain_Img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView text = (TextView) findViewById(R.id.main_text);
		this.mMain_Img = (ImageView) findViewById(R.id.main_img);
		final Typeface hwxk = Typeface.createFromAsset(getAssets(), "simkai.ttf");
		final Typeface lis = Typeface.createFromAsset(getAssets(), "lskai.TTF");
		final Typeface en1 = Typeface.createFromAsset(getAssets(), "quietinfinity.TTF");
		text.setTypeface(hwxk);
		text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(flag){
					text.setTypeface(en1);
					flag = false;
				}else{
					text.setTypeface(hwxk);
					flag = true;
				}
			}
		});
		
	}
	
	public void showToast(Context context,String msg){
		Toast.makeText(context, msg , Toast.LENGTH_LONG).show();
		int a = android.R.style.Animation;
	}
}
