package com.sunyard.util;

import android.content.Context;
import android.widget.Toast;

public class ToastTool {
	public static Toast toast = null;

	public static void longShow(Context context, String message) {
		if (null == toast) {

			toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
		}
		toast.setText(message);
		toast.show();
	}

	public static void shortShow(Context context, String message) {
		if (null == toast) {

			toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		}
		toast.setText(message);
		toast.show();
	}

	/**
	 *  toast取消显示
	 */
	public static void cancel() {
		if (null != toast) {
			toast.cancel();
		}
	}
}
