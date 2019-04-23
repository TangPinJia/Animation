package com.example.tpj.myapplication.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by TPJ on 2019/4/19.
 * Describe:
 */
public class LocationObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disConnectListener(){}
}
