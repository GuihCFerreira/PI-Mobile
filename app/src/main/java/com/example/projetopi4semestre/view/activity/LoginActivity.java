package com.example.projetopi4semestre.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.projetopi4semestre.R;
import com.example.projetopi4semestre.constants.Strings;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioLogado();
    }

    public void usuarioLogado(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(Strings.KEY_SHARED_PREFERENCES, MODE_PRIVATE);

        String userName = preferences.getString(Strings.KEY_USER_NAME, null);
        String userEmail = preferences.getString(Strings.KEY_USER_EMAIL, null);
        String userToken = preferences.getString(Strings.KEY_USER_TOKEN, null);

        if(userName != null && userEmail != null && userToken != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}