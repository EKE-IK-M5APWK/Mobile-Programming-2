package hu.m5apwk.mobilprog2_beadando.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import hu.m5apwk.mobilprog2_beadando.R;
import hu.m5apwk.mobilprog2_beadando.viewmodel.UserDataViewModel;
import hu.m5apwk.mobilprog2_beadando.viewmodel.UserDataViewModelFactory;

public class DataManageFragment extends AppCompatActivity {

    Button btn_okay,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_manage_fragment);
        UserDataViewModel myModel;
        EditText name, id;
        name = findViewById(R.id.editTextPersonName);
        id = findViewById(R.id.editTextPersonId);
        btn_okay = findViewById(R.id.btn_Okay);
        btn_cancel = findViewById(R.id.btn_Cancel);
        myModel = new ViewModelProvider(this, new UserDataViewModelFactory("")).get(UserDataViewModel.class);
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataManageFragment.this , UserDataFragment.class);
                startActivity(intent);
                String newName = name.getText().toString();
                Sti
                myModel.getName().setValue(name.getText().toString());
                UserDataFragment.addUser(myModel);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataManageFragment.this , UserDataFragment.class);
                startActivity(intent);
            }
        });
    }

}