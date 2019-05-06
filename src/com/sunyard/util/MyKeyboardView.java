package com.sunyard.util;

import android.content.Context;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class MyKeyboardView extends KeyboardView{
	public MyKeyboardView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public MyKeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


	@Override
	protected boolean onLongPress(Key popupKey) {

//		if(popupKey.codes[0] == Keyboard.KEYCODE_DELETE){
//			Log.e("onLongPress", "onLongPress");
//			//可使用OnKeyboardActionListener中的各种方法实现该功能
//			getOnKeyboardActionListener().onKey(Keyboard.KEYCODE_DELETE, null);
//
//		}

		return super.onLongPress(popupKey);
	}

}
