package com.statkeeperapp.stattracker;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by brand_000 on 3/19/2017.
 */
public class SubDialog extends DialogFragment{

    static SubDialog newInstance(ArrayList<Player> p) {
        SubDialog d = new SubDialog();

        Bundle args = new Bundle();
        d.setArguments(args);
        return d;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_detail, container, false);
        return v;
    }


}
