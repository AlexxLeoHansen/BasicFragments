package com.jos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by jos on 20-03-17.
 */

public class FragmentEnterWeb extends Fragment {

    private EditText etWebsite;
    private View layoutTypeWeb;
    private String url;

    public static FragmentEnterWeb newInstance(Bundle params){

        FragmentEnterWeb few = new FragmentEnterWeb();
        if(params!=null)
            few.setArguments(params);

        return few;
    }

    public FragmentEnterWeb(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layoutTypeWeb = inflater.inflate(R.layout.type_web_frag, container, false);
        etWebsite = (EditText) layoutTypeWeb.findViewById(R.id.et_web);

        return layoutTypeWeb;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public String getURL(){
        return etWebsite.getText().toString();
    }
}
