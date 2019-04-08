package com.example.dayone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PassingData extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_AGE = "AGE";

    // TODO 2.1 Deklarasi widget yg ingin di gunakan
    TextView tvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);

        // TODO 2.2 inisialisasi/hub dengan idnya masing"
        tvDataReceived = findViewById(R.id.tv_pass_data);

        // TODO 2.4 get data nya sesuai dengan type datanya
        String name = getIntent().getStringExtra(KEY_NAME);
        int age = getIntent().getIntExtra(KEY_AGE, 0);

        // TODO 2.5 show to view
        String temp = "Name : " + name
                + "\n Age : " + age;

        tvDataReceived.setText(temp);
    }
}
