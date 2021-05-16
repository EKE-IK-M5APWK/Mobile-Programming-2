package hu.m5apwk.beadando;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifeCycleObserver implements LifecycleObserver {

    private static final String TAG = "MyLifeCycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start(){
        Log.d(TAG, "Started ...");
    };

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop(){
        Log.d(TAG, "Stoped ...");
    };
}
