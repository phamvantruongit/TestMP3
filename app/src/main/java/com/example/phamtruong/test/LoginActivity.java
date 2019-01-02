package com.example.phamtruong.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
   EditText edEmail,edPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail= (EditText) findViewById(R.id.edEmail);
        edPass= (EditText) findViewById(R.id.edPass);
    }

    public void DangKi(View view) {
    }

    public void DangNhap(View view) {
    }
}
