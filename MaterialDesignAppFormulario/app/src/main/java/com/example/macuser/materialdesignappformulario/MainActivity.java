package com.example.macuser.materialdesignappformulario;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.macuser.materialdesignappformulario.Model.User;

import java.util.ArrayList;
import java.util.Calendar;

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


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            // Parse the string to a User object
            String objAsJson = bundle.getString("user");
            this.assignValues(User.fromJson(objAsJson));
        }


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
                String datepickerString     = getStringDateFromDatePicker(datePicker);

                if (fullname.trim().isEmpty() || phone.trim().isEmpty() ||
                        email.trim().isEmpty() || contact.trim().isEmpty()
                        || datepickerString.trim().isEmpty()){

                    Snackbar.make(v, "Complete the requested information", Snackbar.LENGTH_LONG).show();
                    return;
                }

                User user = new User(fullname, datepickerString, phone, email, contact);
                String objAsJson = user.toJson();

                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("user", objAsJson);
                startActivity(intent);
                finish();


            }
        });
   }


    void assignValues(User user){
        // Set UI elements with user information
        this.et_fullname.setText(user.getFullname());
        this.et_email.setText(user.getEmail());
        this.et_phone.setText(user.getPhone());
        this.et_contact.setText(user.getContactDescription());



    }

   public static String getStringDateFromDatePicker (DatePicker datePicker){
       int day = datePicker.getDayOfMonth();
       int month = datePicker.getMonth();
       int year =  datePicker.getYear();

       return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
   }

//    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
//        int day = datePicker.getDayOfMonth();
//        int month = datePicker.getMonth();
//        int year =  datePicker.getYear();
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
//
//        return calendar.getTime();
//    }


}
