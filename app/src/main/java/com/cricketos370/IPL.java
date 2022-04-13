package com.cricketos370;

import static com.cricketos370.ApppIPl.nggai;
import static com.cricketos370.FragmentWebIPL.zzzx;
import static com.cricketos370.FragmentWebIPL.nnbx;
import static com.cricketos370.FragmentWebIPL.nhds;
import static com.cricketos370.FragmentWebIPL.vcvcx;
import static com.cricketos370.FragmentWebIPL.bnfs;
import static com.cricketos370.FragmentWebIPL.webIpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class IPL extends AppCompatActivity {

    public static NavController navControllerIPL;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != nhds || vcvcx == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                if (bnfs != null) {
                    results = new Uri[]{Uri.parse(bnfs)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        vcvcx.onReceiveValue(results);
        vcvcx = null;
        if (nnbx == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) {
                result = null;
            } else {
                result = data == null ? zzzx : data.getData();
            }
        } catch (Exception e) {
        }
        nnbx.onReceiveValue(result);
        nnbx = null;
    }

    String jjhj;
    public static String nnhx;
    public static String nnhkd = null;
    public static String hfsa = "-";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipl);
        jjhj = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(FragmentWebIPL.decodeIPL("c2F2ZWRVcmw="), FragmentWebIPL.decodeIPL("bnVsbA=="));
        FragmentButtonIPL.ipl = this;
        FragmentWebIPL.ipl = this;
        FragmentNoINIPL.ipl = this;
        navControllerIPL = Navigation.findNavController(this, R.id.nav_host_fragmentIPL);


        if (oinn()) {

            if (!jjhj.equals(FragmentWebIPL.decodeIPL("bnVsbA=="))) {
                nnhx = jjhj;
                navControllerIPL.navigate(R.id.fragmentWebIPL);
            } else {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectIPL();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    FacebookSdk.setApplicationId(nhfa);
                                    FacebookSdk.setAdvertiserIDCollectionEnabled(true);
                                    FacebookSdk.sdkInitialize(getApplicationContext());
                                    FacebookSdk.fullyInitialize();
                                    FacebookSdk.setAutoInitEnabled(true);
                                    FacebookSdk.setAutoLogAppEventsEnabled(true);

                                    AppEventsLogger.activateApp(getApplication());
                                    AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), new AppLinkData.CompletionHandler() {
                                        @Override
                                        public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {

                                            if (appLinkData == null) {
                                                appLinkData = AppLinkData.createFromActivity(IPL.this);

                                            }
                                            if (appLinkData != null) {

                                                String[] as = appLinkData.getTargetUri().toString().split("://");
                                                nnhkd = as[1];
                                                hfsa = FragmentButtonIPL.parserIPl(nnhkd);

                                            } else {

                                            }
                                        }
                                    });


                                    new CountDownTimer(20000,15000){

                                        @Override
                                        public void onTick(long l) {
                                            if (!nggai.equals("-") || !hfsa.equals("-")) {
                                                cancel();
                                                FragmentWebIPL.startWeIPL(jdgs, jsaa);
                                            } else {

                                            }
                                        }

                                        @Override
                                        public void onFinish() {
                                            FragmentWebIPL.startWeIPL(jdgs, jsaa);
                                        }
                                    }.start();
                                }
                            });

                        } catch (Exception e) {
                            navControllerIPL.navigate(R.id.fragmentNoINIPL);
                        }
                    }
                }).start();
            }


        } else {
            navControllerIPL.navigate(R.id.fragmentNoINIPL);
        }

    }


    private boolean oinn() {
        String asxa = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager vcz = (ConnectivityManager) getSystemService(asxa);
        if (vcz.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (webIpl.isFocused() && webIpl.canGoBack()) {
            webIpl.goBack();
        }
    }

    public static String jsaa;
    public static String jdgs;
    public static String nsga;
    public static String nhfa;

    public void connectIPL() throws Exception {
        Document doc = Jsoup.connect(FragmentWebIPL.decodeIPL("aHR0cDovLzg4Ljg1LjgxLjc1L0lQTC5odG1s")).get();
        String str = doc.select("p").text();
        String[] stringsIPL = str.split("-");
        jsaa = stringsIPL[0];
        jdgs = stringsIPL[1];
        nsga = stringsIPL[2];
        nhfa = stringsIPL[3];

        Log.d("weq", jsaa);
        Log.d("weq", jdgs);
        Log.d("weq", nsga);
        Log.d("weq", nhfa);
    }


}
