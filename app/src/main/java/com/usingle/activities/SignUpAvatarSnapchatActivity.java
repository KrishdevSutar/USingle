package com.usingle.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.usingle.R;
import com.usingle.models.Account;
import com.usingle.models.Biography;
import com.usingle.models.BitMapProvider;
import com.usingle.models.DataBase;
import com.usingle.models.RelationshipProvider;
import com.usingle.models.Relationships;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class SignUpAvatarSnapchatActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public static final int GET_FROM_GALLERY = 3;
    static Account newAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // set an exit transition
        getWindow().setExitTransition(new Slide(Gravity.LEFT));

        newAccount = SignUpPreferencesActivity.newAccount;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_avatar_snapchat);
        setupViewObjects();
    }

    private void setupViewObjects() {
        toolbar = (Toolbar) findViewById(R.id.sign_up_avatar_snapchat_activity_toolbar);
        toolbar.setTitle("Sign Up: Avatar");
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
                //account for testing purposes only
                doSomeFinalStuff();
                return true;
        }

        return false;
    }

    private void doSomeFinalStuff() {
        Biography bio = new Biography("male", "Single", newAccount.getBiography().getLooks(), newAccount.getBiography().getUni(), 20, "Both");
        Account match = new Account("Human", "Hue Man", "Password", "human@person.com", "Computer Science", 2000, 1, 18, bio);
        DataBase.addAccount(match);

        // Add in the new user.
        int userID = DataBase.addAccount(newAccount);
        DataBase.setWhichOneIsUser(userID);
        Relationships relationships = new Relationships(newAccount);
        Collection<Account> accountCollection = DataBase.getDataBase().values();
        ArrayList<Account> accountsArrayList = new ArrayList(accountCollection);
        relationships.checkCompatibility(accountsArrayList);
        RelationshipProvider.putNewRelationShip(relationships, newAccount);

        // This starts the activity for a new notification.
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("from_sign_up_avatar_snapchat_activity", true);

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

    public void uploadAvatar(View view) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            /*Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/

            File f = new File(Environment.getExternalStorageDirectory().toString());
            Bitmap bitmap;
            BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
            int id = BitMapProvider.addBitmap(bitmap);
            newAccount.setAvatarID(id);
            // bitmap = getResizedBitmap(bitmap, 400);
        }
    }
}
