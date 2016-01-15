package com.example.fontdemo;

import android.test.AndroidTestCase;

public class JunitTest extends AndroidTestCase {

	public void info(){
		MainActivity mainActivity = new MainActivity();
		mainActivity.showToast(getContext(), "行了");
	}

	public void println(){
		System.out.println("000000000");
	}

	public void methodCollection(){
		info();
		println();
	}
}
