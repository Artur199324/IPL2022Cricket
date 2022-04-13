package com.cricketos370;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.max.slideview.SlideView;


public class FragmentNoINIPL extends Fragment {

    SlideView slideViewInternet;
    public static IPL ipl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_no_i_n_i_p_l, container, false);

        slideViewInternet = view.findViewById(R.id.slideViewInternet);
        slideViewInternet.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                ipl.startActivity(new Intent(ipl.getApplicationContext(),IPL.class));
            }
        });

        return view;
    }
}