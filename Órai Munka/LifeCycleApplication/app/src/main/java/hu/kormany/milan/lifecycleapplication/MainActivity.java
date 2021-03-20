package hu.kormany.milan.lifecycleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyLifecycleObserver myLifecycleObserver;
    Lifecycle lifecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLifecycleObserver = new MyLifecycleObserver();

        lifecycle = getLifecycle();

        lifecycle.addObserver(myLifecycleObserver);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycle.removeObserver(myLifecycleObserver);
    }
}