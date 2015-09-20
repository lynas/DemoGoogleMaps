package com.gsa.util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		L.t(this, "ServiceStarted");
		L.m("ServiceStarted");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		
		super.onDestroy();
		L.t(this, "Service Ended");
	}
	
	

}
