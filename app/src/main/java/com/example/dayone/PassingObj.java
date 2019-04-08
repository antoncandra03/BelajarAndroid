package com.example.dayone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dayone.model.Orang;

public class PassingObj extends AppCompatActivity {

    public static final String EXTRA_OBJECT = "OBJECT";

    // TODO 3.1 Deklarasi
    TextView tvDataReceivedObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_obj);

        // TODO 3.2 inisialisasi/ hub dengan id nya masing"
        tvDataReceivedObj = findViewById(R.id.tv_pass_obj);

        // TODO 3.4 get data object orang dengan parcelable
        Orang objectOrang = getIntent().getParcelableExtra(EXTRA_OBJECT);

        // TODO 3.5 tampung dalam variable
        String temp = "Name : " + objectOrang.getName()
                + "\n Age : " + objectOrang.getAge()
                + "\n Job : " + objectOrang.getJob()
                + "\n Asal : " + objectOrang.getAsal()
                + "\n Tinggal : " + objectOrang.getTinggal();

        // TODO 3.6 show ke TV
        tvDataReceivedObj.setText(temp);
    }
}
