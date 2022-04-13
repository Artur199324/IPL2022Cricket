package com.cricketos370;

import android.app.Application;
import android.os.CountDownTimer;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.onesignal.OneSignal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class ApppIPl extends Application {

    public static String hslka;
    public static String nggai = "-";
    public static String ysva;
    public static String nhsva;
    public static String ngsfa = "RFpUYmZjRU1QMkZ4ckxNc25iYWFF";
    public static String mjgs;
    public static String nhdsf;
    public static String nhds;
    public String bdgs = "ZmFmZTQxOTEtMWMwNy00Nzg0LTkwZjgtMzQ1MzY4MjYwOThj";


    @Override
    public void onCreate() {
        super.onCreate();

        hslka = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ysva = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        AppsFlyerLib.getInstance().init(FragmentWebIPL.decodeIPL(ngsfa), new AppsFlyerConversionListener() {

            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {

                nggai = map.get(FragmentWebIPL.decodeIPL("YWZfc3RhdHVz")).toString();
                if (nggai.equals(FragmentWebIPL.decodeIPL("Tm9uLW9yZ2FuaWM="))) {

                    try {
                        mjgs = map.get(FragmentWebIPL.decodeIPL("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        nhdsf = map.get(FragmentWebIPL.decodeIPL("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        nhds = map.get(FragmentWebIPL.decodeIPL("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    nhsva = FragmentButtonIPL.parserIPl(mjgs);

                }
            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, getApplicationContext());
        AppsFlyerLib.getInstance().start(getApplicationContext());

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(ApppIPl.this);
        OneSignal.setAppId(FragmentWebIPL.decodeIPL(bdgs));

    }


}
