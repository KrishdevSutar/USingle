package com.usingle.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.usingle.R;
import com.usingle.adapters.ConnectionsAdapter;
import com.usingle.adapters.EthnicityAdapter;
import com.usingle.adapters.HomePagerAdapter;
import com.usingle.adapters.MatchesAdapter;
import com.usingle.adapters.SexualPreferenceAdapter;
import com.usingle.adapters.TypeOfRelationshipAdapter;
import com.usingle.fragments.ConnectionsTabFragment;
import com.usingle.fragments.MatchesTabFragment;
import com.usingle.fragments.YouTabFragment;
import com.usingle.models.BitMapProvider;
import com.usingle.models.DataBase;
import com.usingle.util.ContextBoundMethod;

import java.io.File;

public class HomeActivity extends AppCompatActivity {
    private static final int GET_FROM_GALLERY = 3;
    private Toolbar toolbar;
    private RecyclerView recyclerView, recyclerView2;
    private RecyclerView.LayoutManager recyclerViewLayoutManager, recyclerViewLayoutManager2;
    private TabLayout tabLayout;
    public static MatchesAdapter matchesAdapter;
    public static ConnectionsAdapter connectionsAdapter;

    // For the "You" tab:
    private NumberPicker minNumberPicker, maxNumberPicker;
    private RecyclerView ethnicityRecyclerView, sexualPreferenceRecyclerView, typeOfRelationshipRecyclerView;
    private LinearLayoutManager ethnicityViewLayoutManager, sexualPreferenceViewLayoutManager,
            typeOfRelationshipViewLayoutManager;
    EthnicityAdapter ethnicityAdapter;
    SexualPreferenceAdapter sexualPreferenceAdapter;
    TypeOfRelationshipAdapter typeOfRelationshipAdapter;

    // These are the tabs inside of the activity.
    private MatchesTabFragment tab0;
    private ConnectionsTabFragment tab1;
    private YouTabFragment tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupViewObjects();
    }

    private void setupViewObjects() {
        // The following sets up the toolbar.
        toolbar = (Toolbar) findViewById(R.id.home_activity_toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        // The following sets up the tab layout.
        tabLayout = (TabLayout) findViewById(R.id.home_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("New Matches"));
        tabLayout.addTab(tabLayout.newTab().setText("People"));
        tabLayout.addTab(tabLayout.newTab().setText("You"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // The following sets up the ViewPager, which is used in conjunction with the tab layout.
        final ViewPager viewPager = (ViewPager) findViewById(R.id.home_view_pager);
        final HomePagerAdapter adapter = new HomePagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // This gets the tabs.
        tab0 = (MatchesTabFragment) adapter.getItem(0);
        tab1 = (ConnectionsTabFragment) adapter.getItem(1);
        tab2 = (YouTabFragment) adapter.getItem(2);

        // These are the listeners for the tabs.
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // This hides the search option if the tab that is going to be visible is not 0.
                // menu.findItem(R.id.action_search).setVisible(tab.getPosition() != 0);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // This configures the tabs of the activity.
    void configureTabs() {
        setupMatchesRecyclerView();
        setupConnectionsRecyclerView();
        setupYouTab();
    }

    // This runs when the options menu is created.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        configureTabs();
        // this.menu = menu;

        // This inflates the menu and adds items to the run bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_new_notification, menu);

        // This associates searchable configuration with the SearchView.
        /*SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);*/

        // This listens to search query text changes.
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // This filters the recycler view when the query is submitted.
                adapter.getFilter().filter(query);
                InputMethodManager imm = (InputMethodManager) searchView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // This filters the recycler view when text is submitted.
                adapter.getFilter().filter(query);
                return true;
            }
        });*/

        // This occurs when the SearchView is closed by the user.
        /*searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                contacts.applyNameFilter("");
                adapter.notifyDataSetChanged();
                return false;
            }
        });*/
        return true;
    }

    // This runs when the "back" button is pressed on the Android bottom bar.
    @Override
    public void onBackPressed() {
        /*DiscardMessageDialogFragment dialogue = new DiscardMessageDialogFragment();
        dialogue.setActivity(this);
        dialogue.show(getFragmentManager(), "DiscardMessageDialogFragment");*/
    }

    // This sets up the RecyclerView.
    private void setupMatchesRecyclerView() {
        recyclerView = (RecyclerView) tab0.getView().findViewById(R.id.matches_list);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        ContextBoundMethod onSelect = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect.setContext(this);

        matchesAdapter = new MatchesAdapter(onSelect);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(matchesAdapter);
    }

    private void setupConnectionsRecyclerView() {
        recyclerView2 = (RecyclerView) tab1.getView().findViewById(R.id.connections_list);
        recyclerView2.setHasFixedSize(true);
        recyclerViewLayoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(recyclerViewLayoutManager2);

        ContextBoundMethod onSelect = new ContextBoundMethod() {
            @Override
            public void run() {
                Intent intent = new Intent(getContext(), MessagingActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);
            }
        };
        onSelect.setContext(this);

        connectionsAdapter = new ConnectionsAdapter(onSelect);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(connectionsAdapter);
    }

    private void setupYouTab() {
        TextView name = findViewById(R.id.youName);
        name.setText(DataBase.getUser().getRealName());

        ImageView avatar = (ImageView) findViewById(R.id.youAvatar);
        avatar.setImageBitmap(BitMapProvider.getBitmap(DataBase.getUser().getAvatarID()));

        minNumberPicker = (NumberPicker) findViewById(R.id.you_min_age_picker);
        minNumberPicker.setMinValue(16);
        minNumberPicker.setMaxValue(200);

        maxNumberPicker = (NumberPicker) findViewById(R.id.you_max_age_picker);
        maxNumberPicker.setMinValue(16);
        maxNumberPicker.setMaxValue(200);

        ethnicityRecyclerView = (RecyclerView) findViewById(R.id.you_ethnicity_list);
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

        sexualPreferenceRecyclerView = (RecyclerView) findViewById(R.id.you_sexual_preference_list);
        sexualPreferenceRecyclerView.setHasFixedSize(true);
        sexualPreferenceViewLayoutManager = new LinearLayoutManager(this);
        sexualPreferenceRecyclerView.setLayoutManager(sexualPreferenceViewLayoutManager);

        ContextBoundMethod onSelect2 = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect2.setContext(this);

        sexualPreferenceAdapter = new SexualPreferenceAdapter(onSelect2);
        sexualPreferenceRecyclerView.setAdapter(sexualPreferenceAdapter);

        typeOfRelationshipRecyclerView = (RecyclerView) findViewById(R.id.you_type_of_relationship_list);
        typeOfRelationshipRecyclerView.setHasFixedSize(true);
        typeOfRelationshipViewLayoutManager = new LinearLayoutManager(this);
        typeOfRelationshipRecyclerView.setLayoutManager(typeOfRelationshipViewLayoutManager);

        ContextBoundMethod onSelect3 = new ContextBoundMethod() {
            @Override
            public void run() {
                /*Intent intent = new Intent(getContext(), ViewEventActivity.class);
                intent.putExtra("activity_id", (Integer) getData());
                startActivity(intent);*/
            }
        };
        onSelect3.setContext(this);

        typeOfRelationshipAdapter = new TypeOfRelationshipAdapter(onSelect3);
        typeOfRelationshipRecyclerView.setAdapter(typeOfRelationshipAdapter);
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
            DataBase.getUser().setAvatarID(id);
            // bitmap = getResizedBitmap(bitmap, 400);
        }
    }
}
