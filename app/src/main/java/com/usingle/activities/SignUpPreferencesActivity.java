package com.usingle.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.NumberPicker;

import com.usingle.R;
import com.usingle.adapters.EthnicityAdapter;
import com.usingle.adapters.SexualPreferenceAdapter;
import com.usingle.adapters.TypeOfRelationshipAdapter;
import com.usingle.models.Account;
import com.usingle.util.ContextBoundMethod;

public class SignUpPreferencesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NumberPicker minNumberPicker, maxNumberPicker;
    private RecyclerView ethnicityRecyclerView, sexualPreferenceRecyclerView, typeOfRelationshipRecyclerView;
    private LinearLayoutManager ethnicityViewLayoutManager, sexualPreferenceViewLayoutManager,
        typeOfRelationshipViewLayoutManager;
    EthnicityAdapter ethnicityAdapter;
    SexualPreferenceAdapter sexualPreferenceAdapter;
    TypeOfRelationshipAdapter typeOfRelationshipAdapter;
    static Account newAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an exit transition
        getWindow().setExitTransition(new Slide(Gravity.LEFT));

        newAccount = SignUpDetailsActivity.newAccount;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_preferences);
        setupViewObjects();
    }

    private void setupViewObjects() {
        toolbar = (Toolbar) findViewById(R.id.sign_up_preferences_activity_toolbar);
        toolbar.setTitle("Sign Up: Preferences");
        setSupportActionBar(toolbar);

        minNumberPicker = (NumberPicker) findViewById(R.id.sign_up_preferences_min_age_picker);
        minNumberPicker.setMinValue(16);
        minNumberPicker.setMaxValue(200);

        maxNumberPicker = (NumberPicker) findViewById(R.id.sign_up_preferences_max_age_picker);
        maxNumberPicker.setMinValue(16);
        maxNumberPicker.setMaxValue(200);

        setupEthnicityRecyclerView();
        setupSexualPreferenceRecyclerView();
        setupTypeOfRelationshipRecyclerView();
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
                newAccount.setMinAge(((NumberPicker) findViewById(R.id.sign_up_preferences_min_age_picker)).getValue());
                newAccount.setMaxAge(((NumberPicker) findViewById(R.id.sign_up_preferences_max_age_picker)).getValue());

                // newAccount.getBiography().addRacialPreference();



                // This starts the activity for a new notification.
                Intent intent = new Intent(this, SignUpAvatarSnapchatActivity.class);
                intent.putExtra("from_sign_up_preferences_activity", true);

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

    public void setupEthnicityRecyclerView() {
        ethnicityRecyclerView = (RecyclerView) findViewById(R.id.ethnicity_list);
        ethnicityRecyclerView.setHasFixedSize(true);
        ethnicityViewLayoutManager = new LinearLayoutManager(this);
        ethnicityRecyclerView.setLayoutManager(ethnicityViewLayoutManager);

        ContextBoundMethod onSelect = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect.setContext(this);

        ethnicityAdapter = new EthnicityAdapter(onSelect);
        ethnicityRecyclerView.setAdapter(ethnicityAdapter);
    }

    public void setupSexualPreferenceRecyclerView() {
        sexualPreferenceRecyclerView = (RecyclerView) findViewById(R.id.sexual_preference_list);
        sexualPreferenceRecyclerView.setHasFixedSize(true);
        sexualPreferenceViewLayoutManager = new LinearLayoutManager(this);
        sexualPreferenceRecyclerView.setLayoutManager(sexualPreferenceViewLayoutManager);

        ContextBoundMethod onSelect = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect.setContext(this);

        sexualPreferenceAdapter = new SexualPreferenceAdapter(onSelect);
        sexualPreferenceRecyclerView.setAdapter(sexualPreferenceAdapter);
    }

    public void setupTypeOfRelationshipRecyclerView() {
        typeOfRelationshipRecyclerView = (RecyclerView) findViewById(R.id.type_of_relationship_list);
        typeOfRelationshipRecyclerView.setHasFixedSize(true);
        typeOfRelationshipViewLayoutManager = new LinearLayoutManager(this);
        typeOfRelationshipRecyclerView.setLayoutManager(typeOfRelationshipViewLayoutManager);

        ContextBoundMethod onSelect = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect.setContext(this);

        typeOfRelationshipAdapter = new TypeOfRelationshipAdapter(onSelect);
        typeOfRelationshipRecyclerView.setAdapter(typeOfRelationshipAdapter);
    }
}
