package com.example.macuser.materialdesignappformulario;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.macuser.materialdesignappformulario.Model.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {


    // Global variables
    TextInputEditText et_fullname;
    TextInputEditText et_phone;
    TextInputEditText et_email;
    TextInputEditText et_contact;
    DatePicker datePicker;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.initializeViews();





    }




    public void initializeViews(){
        this.et_fullname = (TextInputEditText) findViewById(R.id.et_fullname);
        this.et_phone = (TextInputEditText) findViewById(R.id.et_telefono);
        this.et_email = (TextInputEditText) findViewById(R.id.et_email);
        this.et_contact = (TextInputEditText) findViewById(R.id.et_contact);
        this.datePicker = (DatePicker) findViewById(R.id.datePicker);




        btn = (Button) findViewById(R.id.btn_next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When user clicks in this button, we get info from screen
                String fullname = et_fullname.getText().toString();
                String phone = et_phone.getText().toString();
                String email = et_email.getText().toString();
                String contact = et_contact.getText().toString();
                
                User user = new User(fullname, "Fecha de nacimiento", phone, email, contact);
                String objAsJson = user.toJson();

                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("user", objAsJson);
                startActivity(intent);


            }
        });
   }



}
