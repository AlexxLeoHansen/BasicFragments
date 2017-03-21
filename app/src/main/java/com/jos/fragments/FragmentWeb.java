package com.jos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentWeb extends Fragment {

    private WebView wv;
    private String url;

    public static FragmentWeb newInstance(Bundle params){
        FragmentWeb fw = new FragmentWeb();

        if (params!=null)
            fw.setArguments(params);

        return fw;
    }

    public FragmentWeb(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.webview_fragment, container, false);
        wv = (WebView) v.findViewById(R.id.webview);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(getArguments()!=null){
            url = getArguments().getString("url");
        }
        else
            url = "www.elotrolado.net";

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://"+ url);
    }
}
