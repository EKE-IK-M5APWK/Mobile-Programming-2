package hu.m5apwk.mobilprog2_beadando.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import hu.m5apwk.mobilprog2_beadando.R;
import hu.m5apwk.mobilprog2_beadando.adapter.UserDataAdapter;
import hu.m5apwk.mobilprog2_beadando.viewmodel.UserDataViewModel;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class UserDataFragment extends AppCompatActivity {

    Button btn_addData;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static List<UserDataViewModel> models = new ArrayList<>();



    public static void addUser(UserDataViewModel modelView)
    {
        models.add(modelView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_fragment);

        btn_addData = findViewById(R.id.btn_addData);

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDataFragment.this , DataManageFragment.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserDataAdapter(models,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }
}