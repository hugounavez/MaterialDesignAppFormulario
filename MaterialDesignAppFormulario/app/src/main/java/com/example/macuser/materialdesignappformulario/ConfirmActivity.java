package com.example.macuser.materialdesignappformulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.macuser.materialdesignappformulario.Model.User;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle bundle = getIntent().getExtras();
        String objAsJson = bundle.getString("user");

        User user = User.fromJson(objAsJson);

        System.out.println(user.getFullname());

    }
}
