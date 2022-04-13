package com.cricketos370;

import static com.cricketos370.ApppIPl.hslka;
import static com.cricketos370.ApppIPl.ngsfa;
import static com.cricketos370.ApppIPl.nhdsf;
import static com.cricketos370.ApppIPl.ysva;
import static com.cricketos370.ApppIPl.mjgs;
import static com.cricketos370.ApppIPl.nhds;
import static com.cricketos370.IPL.navControllerIPL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.max.slideview.SlideView;


public class FragmentButtonIPL extends Fragment {

    SlideView slideViewStart, slideViewClose;
    public static IPL ipl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_button_i_p_l, container, false);
        slideViewStart = view.findViewById(R.id.slideViewStart);
        slideViewClose = view.findViewById(R.id.slideViewClose);

        slideViewStart.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                navControllerIPL.navigate(R.id.mainActivity);
            }
        });

        slideViewClose.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                ipl.finishAffinity();
            }
        });

        return view;
    }
    public static String parserIPl(String str) {
        String bgsfa;
        String hsfta;
        String bgafsa;
        String nhgs;
        String bgfa;
        String uyvj;

        String[] nhdg = str.split("_");

        try {
            bgsfa = nhdg[0];
        } catch (Exception e) {

            bgsfa = "";
        }
        try {
            hsfta = nhdg[1];
        } catch (Exception e) {

            hsfta = "";
        }
        try {
            bgafsa = nhdg[2];
        } catch (Exception e) {
            bgafsa = "";

        }
        try {
            nhgs = nhdg[3];
        } catch (Exception e) {
            nhgs = "";

        }
        try {
            bgfa = nhdg[4];
        } catch (Exception e) {
            bgfa = "";
            ;
        }
        try {
            uyvj = nhdg[5];
        } catch (Exception e) {
            uyvj = "";

        }

        return FragmentWebIPL.decodeIPL("P21lZGlhX3NvdXJjZT0=") + nhdsf +
                FragmentWebIPL.decodeIPL("JnN1YjE9") + bgsfa +
                FragmentWebIPL.decodeIPL("JnN1YjI9") + hsfta +
                FragmentWebIPL.decodeIPL("JnN1YjM9") + bgafsa +
                FragmentWebIPL.decodeIPL("JnN1YjQ9") + nhgs +
                FragmentWebIPL.decodeIPL("JnN1YjU9") + bgfa +
                FragmentWebIPL.decodeIPL("JnN1YjY9") + uyvj +
                FragmentWebIPL.decodeIPL("JmNhbXBhaWduPQ==") + mjgs +
                FragmentWebIPL.decodeIPL("Jmdvb2dsZV9hZGlkPQ==") + ysva +
                FragmentWebIPL.decodeIPL("JmFmX3VzZXJpZD0=") + hslka +
                FragmentWebIPL.decodeIPL("JmFmX2NoYW5uZWw9") + nhds +
                FragmentWebIPL.decodeIPL("JmRldl9rZXk9") + FragmentWebIPL.decodeIPL(ngsfa) +
                FragmentWebIPL.decodeIPL("JmJ1bmRsZT0=") + ipl.getPackageName() +
                FragmentWebIPL.decodeIPL("JmZiX2FwcF9pZD0=") + IPL.nhfa +
                FragmentWebIPL.decodeIPL("JmZiX2F0PQ==") + IPL.nsga;

    }
}