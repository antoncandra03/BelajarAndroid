package com.example.dayone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Callback extends AppCompatActivity implements View.OnClickListener {

    public  static final String EXTRA_DATA = "DATA";

    // TODO 4.1 deklarasi
    Button btnCallbackDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);

        // TODO 4.2 inisialisasi / hub dengan id nya masing"
        btnCallbackDetail = findViewById(R.id.btn_callback_detail);

        // TODO 4.3 event Click listener / button something to do
        btnCallbackDetail.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        // TODO 4.4 kirim data callbacknya
        Intent callback = new Intent();
        callback.putExtra(EXTRA_DATA, "Ini Data callback");
        setResult(RESULT_OK, callback);

        //TODO 4.5 close activity saat ini
        finish();

    }
}
