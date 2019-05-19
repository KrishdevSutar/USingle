package com.usingle.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.usingle.R;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an exit transition
        getWindow().setExitTransition(new Slide(Gravity.LEFT));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void loginAction(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("from_start_screen_activity", true);

        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Apply activity transition
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            // Swap without transition
            startActivity(intent);
        }
    }

    public void signUpAction(View view) {
        Intent intent = new Intent(this, SignUpEssentialsActivity.class);
        intent.putExtra("from_start_screen_activity", true);

        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Apply activity transition
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            // Swap without transition
            startActivity(intent);
        }
    }
}
