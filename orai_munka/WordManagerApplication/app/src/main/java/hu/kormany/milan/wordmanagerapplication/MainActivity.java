package hu.kormany.milan.wordmanagerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WorkManager mWorkManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWorkManager = WorkManager.getInstance(this);

        Data inputData = new Data.Builder()
                .putString("data", "Hello from WorkManager!")
                .build();


        Constraints constraints = new Constraints.Builder().setRequiresCharging(true).build();

        final OneTimeWorkRequest mRequest =
                new OneTimeWorkRequest.Builder(MyWorker.class)
                        .setInputData(inputData)
                        .setConstraints(constraints)
                        .build();

        final OneTimeWorkRequest waitRequest =
                new OneTimeWorkRequest.Builder(WaitWorker.class).build();

        TextView textView = findViewById(R.id.textView);

        mWorkManager.getWorkInfoByIdLiveData(mRequest.getId()).observe(this,
                new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if(workInfo != null){
                            WorkInfo.State state = workInfo.getState();
                            textView.setText(state.toString() + ", " +
                                    workInfo.getOutputData().getString("result"));
                        }
                    }
                });


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // mWorkManager.enqueue(mRequest);
                WorkContinuation continuation = mWorkManager.beginWith(waitRequest);
                continuation.then(mRequest).enqueue();
            }
        });
    }
}