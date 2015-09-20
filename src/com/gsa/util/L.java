package com.gsa.util;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public final class L {
	public static void  m(String msg){
		Log.d("TAGG", msg);
	}
	
	public static void t(Context context, String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	

}
