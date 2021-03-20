package hu.kormany.milan.lifecycleapplication;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {

    private static final String TAG = "MyLifecycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start(){
        Log.d(TAG, "started ...");
    };

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop(){
        Log.d(TAG, "stop");
    };
}
