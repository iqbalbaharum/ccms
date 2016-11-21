package com.primeitx.ccms.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.primeitx.ccms.R;
import com.primeitx.ccms.data.SharedPrefs;

public class SignUpActivity extends AppCompatActivity {

    public final static String TAG = "SIGNUPACTIVITY";

    public final static int USERNAME_LENGTH = 4;

    private EditText mETUsername;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mETUsername = (EditText) findViewById(R.id.et_username);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mETUsername.getText().toString();
                if(validateUsername(username)) {
                    // register prefs
                    new SharedPrefs(getApplicationContext()).setPreferences(SharedPrefs.Type.USERNAME, username);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /***
     * Display error
     * @param error
     */
    private void showError(int error) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage(getResources().getString(error));
        builder.setNeutralButton(getResources().getString(R.string.button_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // create builder
        builder.create().show();
    }

    /***
     * Validate username being passed in edit text
     * @param username
     * @return
     */
    private boolean validateUsername(String username) {

        if(username.isEmpty()) {
            showError(R.string.error_username_empty);
            return false;
        }

        if(username.length() < USERNAME_LENGTH || username.length() > USERNAME_LENGTH) {
            showError(R.string.error_username_length);
            return false;
        }

        return true;
    }
}
