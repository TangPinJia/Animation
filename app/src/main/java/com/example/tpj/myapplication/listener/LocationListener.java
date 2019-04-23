package com.example.tpj.myapplication.listener;

import android.content.Context;

import com.example.tpj.myapplication.interfaces.Callback;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


/**
 * Created by TPJ on 2019/4/19.
 * Describe:
 */
public class LocationListener implements LifecycleObserver {
    private boolean enabled=false;
    private Lifecycle lifecycle;
    public LocationListener(Context context,Lifecycle lifecycle,Callback callback){
        this.lifecycle=lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start(){
        if(enabled){
            //connect
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop(){
        //disconnect if connect
    }

    public void setEnabled(){
        enabled=true;
        if(lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)){
            //connect if not connected
        }
    }
}
