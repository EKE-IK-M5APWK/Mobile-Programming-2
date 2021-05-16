package hu.m5apwk.beadando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class FragmentingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmenting);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new FragmentA())
                .add(R.id.container_b, new FragmentB())
                .commit();
        MyLifeCycleObserver myLifeCycleObserver = new MyLifeCycleObserver();
        Lifecycle lifecycle = getLifecycle();
        lifecycle.addObserver(myLifeCycleObserver);
        if(getLifecycle().getCurrentState() == Lifecycle.State.CREATED)
        {
            Log.d("FragmentingActivity","onCreate:STARTED");
        }
        Intent intent = new Intent();
        intent.putExtra("data", 1);

        MyJobIntentService.enqueueWork(FragmentingActivity.this, intent);

        Intent intent1 = new Intent(this, MyService.class);
        startService(intent1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
        {
            Log.d("FragmentingActivity","onDestroy:STARTED");
        }
    }
}
