package com.example.macuser.materialdesignappformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.macuser.materialdesignappformulario.Model.User;

import java.io.InterruptedIOException;

public class ConfirmActivity extends AppCompatActivity {

    // Global variables
    // UI elements
    TextView    fullname;
    TextView    birthDate;
    TextView    phone;
    TextView    email;
    TextView    description;
    Button      btn;
    // Model data
    User        user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        // Bind UI elements with layout and set button
        this.initializeViews();
        // Get object passed via intent
        this.user = this.getObjectFromBundle();

        this.assignValues();
    }

    User getObjectFromBundle(){
        // Get the extras from intent
        Bundle bundle = getIntent().getExtras();
        // Parse the string to a User object
        String objAsJson = bundle.getString("user");
        return User.fromJson(objAsJson);
    }

    public void initializeViews(){
        this.fullname   = (TextView) findViewById(R.id.tv_confirm_name);
        this.birthDate  = (TextView) findViewById(R.id.tv_confirm_date);
        this.phone      = (TextView) findViewById(R.id.tv_confirm_phone);
        this.email      = (TextView) findViewById(R.id.tv_confirm_email);
        this.description = (TextView) findViewById(R.id.tv_confirm_description);
        this.btn        = (Button) findViewById(R.id.btn_edit_data);

        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Come back to main activity
                openMainActivity();
            }
        });
    }

    void assignValues(){
        // Set UI elements with user information
        this.fullname.setText(this.user.getFullname());
        this.birthDate.setText(this.user.getBirthDate());
        this.phone.setText(this.user.getPhone());
        this.email.setText(this.user.getEmail());
        this.description.setText(this.user.getContactDescription());

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // Catching the back event press button
        if (keyCode == KeyEvent.KEYCODE_BACK){
            this.openMainActivity();
        }

        return super.onKeyDown(keyCode, event);
    }

    void openMainActivity(){
        // This method open MainActivity
        Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
        String userAsJson = this.user.toJson();
        intent.putExtra("user", userAsJson);
        startActivity(intent);
        finish();

    }


}
