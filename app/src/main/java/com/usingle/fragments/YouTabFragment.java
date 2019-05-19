/**
 * Class: ReceiversTabFragment
 * Author: Robert Ciborowski
 * Date: 03/06/2018
 * Description: A tab for selecting receivers of a message.
 */

package com.usingle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.usingle.R;
import com.usingle.adapters.EthnicityAdapter;
import com.usingle.adapters.SexualPreferenceAdapter;
import com.usingle.adapters.TypeOfRelationshipAdapter;

public class YouTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.you_tab_fragment, container, false);
    }
}
