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
import android.widget.EditText;
import android.widget.Spinner;

import com.usingle.R;
import com.usingle.models.Account;

import java.util.Arrays;
import java.util.List;

public class SignUpDetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;

    static Account newAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an exit transition
        getWindow().setExitTransition(new Slide(Gravity.LEFT));

        newAccount = SignUpEssentialsActivity.newAccount;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_details);
        setupViewObjects();
    }

    private void setupViewObjects() {
        toolbar = (Toolbar) findViewById(R.id.sign_up_details_activity_toolbar);
        toolbar.setTitle("Sign Up: About You");
        setSupportActionBar(toolbar);
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
                newAccount.getBiography().changeUni(((Spinner) findViewById(R.id.signUpUniversitySpinner)).getSelectedItem().toString());
                newAccount.setMajor(((Spinner) findViewById(R.id.signUpProgramSpinner)).getSelectedItem().toString());

                String hobbies = ((EditText) findViewById(R.id.signUpHobbiesInput)).getText().toString();
                List<String> hobbiesList = Arrays.asList(hobbies.split(", "));

                for (String hobby : hobbiesList) {
                    newAccount.getBiography().addHobby(hobby);
                }

                // This starts the activity.
                Intent intent = new Intent(this, SignUpPreferencesActivity.class);
                intent.putExtra("from_sign_up_details_activity", true);

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
