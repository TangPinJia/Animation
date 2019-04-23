package com.example.tpj.myapplication.activity;

import android.os.Bundle;

import com.example.tpj.myapplication.interfaces.Callback;
import com.example.tpj.myapplication.interfaces.Statusback;
import com.example.tpj.myapplication.listener.LocationListener;
import com.example.tpj.myapplication.observer.LocationObserver;
import com.example.tpj.myapplication.util.CheckUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by TPJ on 2019/4/19.
 * Describe:
 */
public class LifecycleActivity extends AppCompatActivity {
    private LocationListener locationListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AppcompatActivity本身就已经实现了LifecycleOwner
        getLifecycle().addObserver(new LocationObserver());
        locationListener = new LocationListener(this,getLifecycle(), new Callback() {
            @Override
            public void onBack() {
                //update UI
            }
        });
        CheckUtil.checkStatus(new Statusback() {
            @Override
            public void onStatus(boolean b) {
                if(b)
                    locationListener.setEnabled();//开启位置监听，这样写是为了防止当checkStatus完成后activity已经销毁导致空指针
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckUtil.checkStatus(new Statusback() {//这个写法让checkStatus()持有了locationListener对象，置监听对象属于Lifecycleactivity，如果活动销毁，导致空指针
            @Override
            public void onStatus(boolean b) {
                locationListener.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationListener.stop();
    }
}
