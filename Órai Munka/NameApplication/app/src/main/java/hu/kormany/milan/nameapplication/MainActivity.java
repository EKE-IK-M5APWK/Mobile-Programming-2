package hu.kormany.milan.nameapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewName);
        EditText editText = findViewById(R.id.editTextName);
        Button button = findViewById(R.id.buttonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editText.getText().toString();
                myViewModel.getName().setValue( newName );
            }
        });

        myViewModel = new ViewModelProvider(this, new MyViewModelFactory("Hello World!")).get(MyViewModel.class);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText( s );
            }
        };
        myViewModel.getName().observe(this,nameObserver);
    }
}