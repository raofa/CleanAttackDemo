package com.sunyard.util;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.example.cleanattackdemo.MainActivity;
import com.example.cleanattackdemo.R;


public class KeyboardUtil {
		private Activity ctx;
        private KeyboardView keyboardView;
        private Keyboard k;
        public boolean isnun = false;
        public boolean isupper = false;

        private EditText ed;

        public void setEditText(EditText edit){
        	this.ed = edit;
        }


        public KeyboardUtil(int Keyboard_id,Activity ctx) {
//                this.view = view;
                this.ctx = ctx;
                k = new Keyboard(ctx,Keyboard_id);
                keyboardView = (KeyboardView) ctx.findViewById(R.id.keyboard_view);
                keyboardView.setKeyboard(k);
                keyboardView.setEnabled(true);
                keyboardView.setPreviewEnabled(true);
                keyboardView.setLongClickable(true);
                keyboardView.setVisibility(View.VISIBLE);
                keyboardView.setOnKeyboardActionListener(listener);
        }

        private OnKeyboardActionListener listener = new OnKeyboardActionListener() {
                @Override
                public void swipeUp() {
                }

                @Override
                public void swipeRight() {
                }

                @Override
                public void swipeLeft() {
                }

                @Override
                public void swipeDown() {
                }

                @Override
                public void onText(CharSequence text) {
                }

                @Override
                public void onRelease(int primaryCode) {
                }

                @Override
                public void onPress(int primaryCode) {
                }

                @Override
                public void onKey(int primaryCode, int[] keyCodes) {
	                	if(ed==null){
	                		return;
	                	}
	                	if(!ed.isFocused()){
	                		ed.requestFocus();
	                	}
                        Editable editable = ed.getText();
                        int start = ed.getSelectionStart();
                        if (primaryCode == Keyboard.KEYCODE_CANCEL) {
                               if(ctx instanceof MainActivity){
                                   ((MainActivity)ctx).go();
                               }
                        } else if (primaryCode == Keyboard.KEYCODE_DELETE) {
                                if (editable != null && editable.length() > 0) {
                                        if (start > 0) {
                                                editable.delete(start - 1, start);
                                        }
                                }
                        } else if (primaryCode == 57419) { // go left
                                if (start > 0) {
                                        ed.setSelection(start - 1);
                                }
                        } else if (primaryCode == 57421) { // go right
                                if (start < ed.length()) {
                                        ed.setSelection(start + 1);
                                }
                        } else {
                                editable.insert(start, Character.toString((char) primaryCode));
                        }
                }
        };


    public void showKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
        }
    }

    public void hideKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.VISIBLE) {
            keyboardView.setVisibility(View.GONE);
        }
    }


}

