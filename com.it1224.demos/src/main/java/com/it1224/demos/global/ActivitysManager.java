package com.it1224.demos.global;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Stack;

public class ActivitysManager {
	private static Stack<WeakReference<Activity>> mActivityStack;
	private static ActivitysManager mAppManager;

	private ActivitysManager() {
	}

	/**
	 * 单一实例
	 */
	public static ActivitysManager getInstance() {
		if (mAppManager == null) {
			mAppManager = new ActivitysManager();
		}
		
		return mAppManager;
	}
	
	/**
	 * 
	 * @return 返回Activity的个数
	 */
	public int getCount(){
		return mActivityStack.size();
	}
	/**
	 * 
	 * @return 返回Activity的管理站
	 */
	public Stack<WeakReference<Activity>> getActivityStack(){
		return mActivityStack;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		WeakReference<Activity> a = new WeakReference<Activity>(activity);
		if (mActivityStack == null) {
			mActivityStack = new Stack<WeakReference<Activity>>();
		}
		mActivityStack.add(a);
		removeNoValidActivity();
	}

	// 移除无效对象,防止数组持续增大
	private void removeNoValidActivity() {
		if (mActivityStack != null && mActivityStack.size() > 0) {
			ArrayList<WeakReference<Activity>> l = new ArrayList<WeakReference<Activity>>();
			for (int i = 0, size = mActivityStack.size(); i < size; i++) {
				if (null == mActivityStack.get(i)
						|| mActivityStack.get(i).get() == null) {

					l.add(mActivityStack.get(i));
				}
			}
			if (l.size() > 0)
				mActivityStack.removeAll(l);
		}
	}
	
	/**
	 * 获取栈顶Activity（堆栈中最后一个压入的）
	 */
	public WeakReference<Activity> getTopActivity() {
		WeakReference<Activity> activity = mActivityStack.lastElement();
		return activity;
	}

	/**
	 * 结束栈顶Activity（堆栈中最后一个压入的）
	 */
	public void killTopActivity() {
		WeakReference<Activity> activity = mActivityStack.lastElement();
		killActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void killActivity(WeakReference<Activity> activity) {
		if (activity != null && activity.get() != null
				&& !activity.get().isFinishing()) {
			mActivityStack.remove(activity);
			Activity a = activity.get();
			a.finish();
			activity.clear();
			a = null;
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void killActivity(Class<?> cls) {
		for (WeakReference<Activity> activity : mActivityStack) {

			if (activity == null || activity.get() == null
					|| activity.get().isFinishing()) {
				continue;
			}

			if (activity.get().getClass().equals(cls)) {
				killActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void killAllActivity() {
		for (int i = 0, size = mActivityStack.size(); i < size; i++) {
			if (null != mActivityStack.get(i)
					&& mActivityStack.get(i).get() != null
					&& !mActivityStack.get(i).get().isFinishing()) {
				Activity a = mActivityStack.get(i).get();
				mActivityStack.get(i).clear();
				a.finish();
				a = null;

			}
		}
		mActivityStack.clear();
	}

	/**
	 * 退出应用程序
	 */
	public void AppExit(Context context) {
		try {
			killAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
		}
	}
}
