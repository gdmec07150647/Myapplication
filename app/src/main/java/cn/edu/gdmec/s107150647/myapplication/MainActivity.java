package cn.edu.gdmec.s107150647.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        tv1 = new TextView(this);
        tv1.setText("手动");
        setContentView(tv1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessages("大键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessages("小键");
                break;
            case KeyEvent.KEYCODE_HOME:
                return true;
            default:
                SetMessages("键值错");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessages("松开大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessages("松开小键");
                break;
            default:
                SetMessages("松开"+keyCode);
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessages("返回");
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessages("长按键");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        if(action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE){
            return false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessages("坐标：（"+x+","+y+"）");
        return super.onTouchEvent(event);
    }

    private void SetMessages(String str){
        String oldstr=tv1.getText().toString();
        String newstr=oldstr+"\n"+str;
        tv1.setText(newstr);
    }
}
