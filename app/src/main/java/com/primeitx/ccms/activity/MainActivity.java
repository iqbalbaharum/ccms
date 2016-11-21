package com.primeitx.ccms.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.primeitx.ccms.R;
import com.primeitx.ccms.data.SharedPrefs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPrefs prefs = new SharedPrefs(getApplicationContext());
        if(prefs.getString(SharedPrefs.Type.USERNAME).isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
    }
}
