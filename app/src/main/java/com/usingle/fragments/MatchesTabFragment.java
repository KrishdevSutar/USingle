/**
 * Class: ReceiversTabFragment
 * Author: Robert Ciborowski
 * Date: 03/06/2018
 * Description: A tab for selecting receivers of a message.
 */

package com.usingle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usingle.R;

public class MatchesTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.matches_tab_fragment, container, false);
    }
}
