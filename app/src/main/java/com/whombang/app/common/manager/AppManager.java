package com.whombang.app.common.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * title AppManager.java
 * description 用于activity的管理和应用程序的退出   
 * author Sundy
 * created 2015年9月24日 下午3:30:21
 */
public class AppManager {
	private static Stack<AppCompatActivity> mActivityStack;
	private static AppManager mInstance;
	
	private AppManager(){}
	
	/**
	 * @return 得到AppManager
	 */
	public static AppManager getAppManager(){
		if(mInstance==null){
			mInstance=new AppManager();
		}
		return mInstance;
	}
	
	/**
	 * 
	 */
	public void addActivity(AppCompatActivity activity){
		if(mActivityStack==null){
			mActivityStack=new Stack<>();
		}
		mActivityStack.add(activity);
	}
	
	/**
	 * 获取当前的activity（堆栈中最后一个压入）
	 * @return 返回一个activity
	 */
	public AppCompatActivity currentActivity(){
		AppCompatActivity activity=mActivityStack.lastElement();
		return activity;
	}
	
	/**
	 * 结束当前的activity（堆栈中最后一个压入）
	 */
	public void finishActivity(){
		AppCompatActivity activity=mActivityStack.lastElement();
		finishActivity(activity);
	}
    
	/**
	 * 结束指定的actiivty
	 * @param activity
	 */
	public void finishActivity(AppCompatActivity activity) {
	    if(activity!=null)
	    	mActivityStack.remove(activity);
	        activity.finish();
	        activity=null;
		
	}
	
	/**
	 * 结束指定类名的actiivty
	 */
	public void finisActivity(Class<?> cls){
		for(AppCompatActivity activity:mActivityStack){
			if(activity.getClass().equals(cls)){
				finishActivity(activity);
				break;
			}
		}
		
	}
	
	/**
	 * 结束所有的Activity
	 */
	public void finishAllActivity(){
		for(int i=0,size=mActivityStack.size();i<size;i++){
			if(null!=mActivityStack.get(i)){
				mActivityStack.get(i).finish();
			}
		}
		mActivityStack.clear();
	}
	
	/**
	 * 退出应用程序
	 * @param context 上下文场景
	 */
	@SuppressWarnings("deprecation")
	public void AppExit(Context context){
		try {
			finishAllActivity();
			ActivityManager activityManager=(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			activityManager.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
