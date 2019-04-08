package com.example.dayone;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dayone.model.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 1;

    // TODO 1.1 deklarasi widget/button yg digunakan
    Button btnMove, btnPassData, btnPassObj,
            btncallback, btnEmail, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 1.2 inisialisasi/menghubungkan dengan id masing"
        btnMove = findViewById(R.id.btn_move);
        btnPassData = findViewById(R.id.btn_pass_data);
        btnPassObj = findViewById(R.id.btn_pass_obj);
        btncallback = findViewById(R.id.btn_callback);
        btnEmail = findViewById(R.id.btn_email);
        btnCall = findViewById(R.id.btn_call);

        btnMove.setOnClickListener(this);
        btnPassData.setOnClickListener(this);
        btnPassObj.setOnClickListener(this);
        btncallback.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnCall.setOnClickListener(this);

        // TODO 1.3 event click listenner/ button samething to do
//        btnMove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO 1.4 intent to move activity
//                Intent move = new Intent(MainActivity.this, MoveActivity.class);
//                startActivity(move);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move:
                move();
                break;

            case R.id.btn_pass_data:
                passData();
                break;

            case R.id.btn_pass_obj:
                passObj();
                break;

            case R.id.btn_callback:
                callBack();
                break;

            case R.id.btn_call:
                implicitCall();
                break;

            case R.id.btn_email:
                implicitEmail();
                break;


        }
    }

    // TODO 6.1
    private void implicitEmail() {
        Intent email = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "anton.candra03@gmail.com", null));

        email.putExtra(Intent.EXTRA_SUBJECT, "Ini Subject");
        email.putExtra(Intent.EXTRA_TEXT, "Ini Body Message");

        if (email.resolveActivity(getPackageManager())!= null){
            startActivity(Intent.createChooser(email, "Pilih share client"));
        }else {
            Toast.makeText(this, "Tidak ada share client", Toast.LENGTH_SHORT).show();
        }

    }

    // TODO 5.1 intent implicit call
    private void implicitCall() {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:08561668081"));
        startActivity(call);
    }

    // TODO 4.6
    private void callBack() {
        Intent callback = new Intent(MainActivity.this, Callback.class);

        startActivityForResult(callback, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // TODO 4.7 buat kondisi kalo seandainya request codenya sama dan data nya ada
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String temp = data.getStringExtra(Callback.EXTRA_DATA);
                Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // TODO 3.3
    private void passObj() {
        Intent passobj = new Intent(MainActivity.this, PassingObj.class);

        /**
         * instance class orang
         * atau buat object dari class orang
         */
        Orang objectOrang = new Orang();
        objectOrang.setName("Anton");
        objectOrang.setAge(23);
        objectOrang.setAsal("Jakarta");
        objectOrang.setJob("Kerja");
        objectOrang.setTinggal("Tangerang");

        passobj.putExtra(PassingObj.EXTRA_OBJECT, objectOrang);

        startActivity(passobj);

     }

    // TODO 2.3 kirim Datanya
    private void passData() {
        Intent passdata = new Intent(MainActivity.this, PassingData.class);

        /**
         * Intent putExtra
         * Param 1 key seb penampung data
         * param 2 value yg akan dikirim ke dalam type data apapun
         * */

        passdata.putExtra(PassingData.KEY_NAME, "Anton Candra");
        passdata.putExtra(PassingData.KEY_AGE, 23);

        startActivity(passdata);

    }

    // TODO 1.3 event click listenner/ button samething to do
    private void move(){
        //TODO 1.4 intent to move activity
        Intent move = new Intent(MainActivity.this, MoveActivity.class);
        startActivity(move);
    }
}
