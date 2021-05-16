package hu.m5apwk.mobilprog2_beadando.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import hu.m5apwk.mobilprog2_beadando.R;
import hu.m5apwk.mobilprog2_beadando.viewmodel.UserDataViewModel;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button doitButton,usersButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.simpleEditText);
        doitButton = findViewById(R.id.button);
        usersButton = findViewById(R.id.btn_Users);
        doitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    textView.setText(editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        usersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , UserDataFragment.class);
                startActivity(intent);
            }
        });



    }


}