package com.cricketos370;

import static com.cricketos370.ApppIPl.hslka;
import static com.cricketos370.ApppIPl.ngsfa;
import static com.cricketos370.ApppIPl.ysva;
import static com.cricketos370.IPL.nnhkd;
import static com.cricketos370.IPL.nhfa;
import static com.cricketos370.IPL.nsga;
import static com.cricketos370.IPL.nnhx;
import static com.cricketos370.IPL.navControllerIPL;
import static com.cricketos370.IPL.hfsa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class FragmentWebIPL extends Fragment {

    public static WebView webIpl;
    public static IPL ipl;
    public static ValueCallback<Uri> nnbx;
    public static Uri zzzx = null;
    public static ValueCallback<Uri[]> vcvcx;
    public static String bnfs;
    public static final int nhds = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_i_p_l, container, false);
        webIpl = view.findViewById(R.id.webIpl);
        setWebIPl(webIpl);
        webIpl.loadUrl(nnhx);

        return view;
    }

    private void setWebIPl(WebView webIpl){
        webIpl.getSettings().setMixedContentMode(0);
        webIpl.setFocusable(true);
        webIpl.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webIpl.getSettings().setJavaScriptEnabled(true);
        webIpl.getSettings().setAllowContentAccess(true);
        webIpl.getSettings().setLoadWithOverviewMode(true);
        webIpl.getSettings().setEnableSmoothTransition(true);
        webIpl.getSettings().setUseWideViewPort(true);
        webIpl.getSettings().setSaveFormData(true);
        webIpl.getSettings().setAllowFileAccess(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webIpl, true);
        CookieManager.getInstance().setAcceptCookie(true);
        webIpl.setVisibility(View.VISIBLE);
        webIpl.getSettings().setAllowFileAccessFromFileURLs(true);
        webIpl.getSettings().setSavePassword(true);
        webIpl.getSettings().setDatabaseEnabled(true);
        webIpl.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        webIpl.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_DEFAULT);
        webIpl.getSettings().setAppCacheEnabled(true);
        webIpl.getSettings().setLoadsImagesAutomatically(true);
        webIpl.setSaveEnabled(true);
        webIpl.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webIpl.getSettings().setDomStorageEnabled(true);
        webIpl.setFocusableInTouchMode(true);
        webIpl.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(decodeIPL("ZXJyb3I9YXBwYWZBczNm")) || url.contains(decodeIPL("ZGlzYWJsZWQuaHRtbA=="))){

                    navControllerIPL.navigate(R.id.fragmentButtonIPL);
                    Log.d("weq","bot");
                }
            }
        });
        webIpl.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (vcvcx != null) {
                    vcvcx.onReceiveValue(null);
                }
                vcvcx = filePath;
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("*/*");
                Intent[] intentArray = new Intent[0];
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE, decodeIPL("U2VsZWN0IE9wdGlvbjo="));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                ipl.startActivityForResult(chooserIntent, 1);
                return true;
            }
        });

    }

    public static String decodeIPL(String str){

        byte[] decoded = android.util.Base64.decode(str, Base64.DEFAULT);
        return new String(decoded);
    }

    public static void startWeIPL(String link, String status){

        if (ApppIPl.nggai.equals(decodeIPL("Tm9uLW9yZ2FuaWM="))) {
            nnhx = link + ApppIPl.nhsva;
            ipl.getSharedPreferences(ipl.getPackageName(), ipl.MODE_PRIVATE).edit().putString(decodeIPL("c2F2ZWRVcmw="), nnhx).apply();
            navControllerIPL.navigate(R.id.fragmentWebIPL);
            Log.d("weq","App"+ nnhx);
        } else if (nnhkd != null) {
            nnhx = link + hfsa;

            ipl.getSharedPreferences( ipl.getPackageName(),  ipl.MODE_PRIVATE).edit().putString(decodeIPL("c2F2ZWRVcmw="), nnhx).apply();
            navControllerIPL.navigate(R.id.fragmentWebIPL);
            Log.d("weq","Dipp"+ nnhx);

        } else {
            if (status.equals("0")) {

                navControllerIPL.navigate(R.id.fragmentButtonIPL);
                Log.d("weq","game");
            } else {

                nnhx = link + decodeIPL("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                        decodeIPL("Jmdvb2dsZV9hZGlkPQ==") + ysva +
                        decodeIPL("JmFmX3VzZXJpZD0=") + hslka +
                        decodeIPL("JmRldl9rZXk9") + FragmentWebIPL.decodeIPL(ngsfa) +
                        decodeIPL("JmJ1bmRsZT0=") + ipl.getPackageName() +
                        decodeIPL("JmZiX2FwcF9pZD0=") + nhfa +
                        decodeIPL("JmZiX2F0PQ==") + nsga;

                ipl.getSharedPreferences( ipl.getPackageName(),  ipl.MODE_PRIVATE).edit().putString(decodeIPL("c2F2ZWRVcmw="), nnhx).apply();
                navControllerIPL.navigate(R.id.fragmentWebIPL);
                Log.d("weq","Organic"+ nnhx);
            }
        }

    }
}