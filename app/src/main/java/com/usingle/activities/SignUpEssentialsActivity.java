package com.usingle.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;

import com.usingle.R;
import com.usingle.models.Account;

public class SignUpEssentialsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DatePicker datePicker;
    static Account newAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an exit transition
        getWindow().setExitTransition(new Slide(Gravity.LEFT));

        newAccount = new Account();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_essentials);
        setupViewObjects();
    }

    private void setupViewObjects() {
        toolbar = (Toolbar) findViewById(R.id.sign_up_essentials_activity_toolbar);
        toolbar.setTitle("Sign Up: The Essentials");
        setSupportActionBar(toolbar);

        datePicker = (DatePicker) findViewById(R.id.signUpDatePicker);
        // 150 years before now:
        long minDate = System.currentTimeMillis() - (long) 1000 * 60 * 60 * 24 * 7 * 52 * 200;
        datePicker.setMaxDate(System.currentTimeMillis());
        datePicker.setMinDate(minDate);
    }

    // This runs on the creation of the options menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // This inflates the menu and adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_finished_sign_up:
                newAccount.setUserName(((EditText) findViewById(R.id.signUpUsernameInput)).getText().toString());
                newAccount.setRealName(((EditText) findViewById(R.id.signUpRealNameInput)).getText().toString());
                newAccount.setEmail(((EditText) findViewById(R.id.signUpEmailInput)).getText().toString());
                newAccount.setPassword(((EditText) findViewById(R.id.signUpPasswordInput)).getText().toString());
                newAccount.setBirthDate(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

                // This starts the activity for a new notification.
                Intent intent = new Intent(this, SignUpDetailsActivity.class);
                intent.putExtra("from_sign_up_essentials_activity", true);

                // Check if we're running on Android 5.0 or higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Apply activity transition
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    // Swap without transition

                    startActivity(intent);
                }
                return true;
        }

        return false;
    }
}
