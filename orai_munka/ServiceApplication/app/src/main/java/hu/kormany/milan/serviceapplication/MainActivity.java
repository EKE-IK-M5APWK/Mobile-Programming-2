package hu.kormany.milan.serviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.putExtra("data", 1);

        MyJobIntentService.enqueueWork(MainActivity.this, intent);

        Intent intent1 = new Intent(this, MyService.class);
        startService(intent1);


    }
}