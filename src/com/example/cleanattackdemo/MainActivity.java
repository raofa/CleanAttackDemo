package com.example.cleanattackdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sunyard.util.KeyboardUtil;

public class MainActivity extends Activity {
    
    private EditText work_key_et,pin;
    private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        work_key_et = (EditText) findViewById(R.id.work_key_et);
        hideSoftInputMethod(work_key_et);
        pin = (EditText) findViewById(R.id.pin_et);
        go = (Button) findViewById(R.id.go_bt);
        KeyboardUtil keyboard = new KeyboardUtil(R.layout.my_keyborder_numb,this);
        keyboard.showKeyboard();
        keyboard.setEditText(work_key_et);
        go.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                go();
            }
        });
    }
    
    public void go(){
        pin.setText("");
        String s = work_key_et.getText().toString();
        if(s !=null && !s.equals("") && s.length()==6){
            int i = Integer.valueOf(s);
            i = getvalue(i);
            String res = String.valueOf(i);
            if(res.length()<6){
                int len=res.length();
                for(int j=0;j<6-len;j++)
                    res="0"+res;
            }
            pin.setText(res);
        }else {
            Toast.makeText(MainActivity.this, "请在\"提示码\"栏中输入6位数字", Toast.LENGTH_SHORT).show();
        }
    }
    
    public int getvalue(int num){
        int res;
        int last2num=num%100+12;
        res=last2num*10000+last2num*100+last2num;
        res&=num;
        return res;
    }
    
    public void hideSoftInputMethod(EditText ed){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if(currentVersion >= 16){
            // 4.2
            methodName = "setShowSoftInputOnFocus";
        }else if(currentVersion >= 14){
                // 4.0
            methodName = "setSoftInputShownOnFocus";
        }
        if(methodName == null){
            ed.setInputType(InputType.TYPE_NULL);
        }else{
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(ed, false);
                } catch (NoSuchMethodException e) {
                    ed.setInputType(InputType.TYPE_NULL);
                    e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                    } catch (InvocationTargetException e) {
                                e.printStackTrace();
                    }
            }
    }
}
