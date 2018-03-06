package com.gzmantis.tyassistant.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzmantis.tyassistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class PayFragment extends BasicFragment implements View.OnClickListener {

    public PayFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(Bundle paramBundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void processLogic(Bundle paramBundle) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }

}
