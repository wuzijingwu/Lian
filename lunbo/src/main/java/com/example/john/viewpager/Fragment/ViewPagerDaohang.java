package com.example.john.viewpager.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.viewpager.R;


public class ViewPagerDaohang extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private String mParam2;


    public ViewPagerDaohang() {

    }


    public static ViewPagerDaohang newInstance(String param1) {
        ViewPagerDaohang fragment = new ViewPagerDaohang();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_view_pager_daohang, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
