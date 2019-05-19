package com.usingle.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.usingle.R;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;

    // This is used to override what happens when the user presses enter on the keyboard.
    private View.OnKeyListener enterKeyListener;

    // These are views of the activity.
    private EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViewObjects();
    }

    // This sets up view objects.
    private void setupViewObjects() {
        usernameText = (EditText) findViewById(R.id.loginUsernameInput);
        passwordText = (EditText) findViewById(R.id.loginPasswordInput);
        toolbar = (Toolbar) findViewById(R.id.login_activity_toolbar);

        passwordText.setOnKeyListener(enterKeyListener);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);
    }

    private void setupListeners() {
        enterKeyListener = new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            loginAction(view);
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        };
    }

    public void loginAction(View view) {
        // This is what should run if the login was successful.
        /*Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("from_login_activity", true);

        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Apply activity transition
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            // Swap without transition

            startActivity(intent);
        }*/

        Toast.makeText(this, "Invalid credentials, please make a new account.", Toast.LENGTH_LONG).show();
    }
}
