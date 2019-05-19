/**
 * Class: NewNotificationPagerAdapter
 * Author: Robert Ciborowski
 * Date: 03/06/2018
 * Description: An adapter to the notification tabs. It sets the tabs up.
 */

package com.usingle.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.usingle.R;
import com.usingle.fragments.ConnectionsTabFragment;
import com.usingle.fragments.MatchesTabFragment;
import com.usingle.fragments.YouTabFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {
    // These are the fragments to the individual tabs.
    private MatchesTabFragment tab0 = new MatchesTabFragment();
    private ConnectionsTabFragment tab1 = new ConnectionsTabFragment();
    private YouTabFragment tab2 = new YouTabFragment();

    // This stores the activity/context of the tabs.
    private Context context;

    // This is the only constructor.
    public HomePagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    // This returns a tab based on position.
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return tab0;
            case 1:
                return tab1;
            case 2:
                return tab2;
            default:
                return null;
        }
    }

    // This returns the number of tabs, which is a constant.
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab.
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Matches";
            case 1:
                return "People";
            case 2:
                return "You";
            default:
                return null;
        }
    }
}
