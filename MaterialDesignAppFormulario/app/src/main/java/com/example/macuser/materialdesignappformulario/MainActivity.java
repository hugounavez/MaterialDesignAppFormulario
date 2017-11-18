package com.example.macuser.materialdesignappformulario;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    // Global variables
    TextInputLayout et_fullname;
    Button btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_next = (Button) findViewById(R.id.btn_next);

    }
}
