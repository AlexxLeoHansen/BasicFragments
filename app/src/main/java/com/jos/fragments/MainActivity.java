package com.jos.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton bFragment;
    private FragmentTransaction ft;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFragment = (FloatingActionButton) findViewById(R.id.b_fragment);

        //fragment enter appeared
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.fragment_enter, new FragmentEnterWeb())
                .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        bFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentEnterWeb few = (FragmentEnterWeb) fm.findFragmentById(R.id.fragment_enter);
                Bundle args = new Bundle();
                args.putString("url",few.getURL());
                FragmentWeb fw = FragmentWeb.newInstance(args);
                
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_cview,fw)
                        .attach(fw)
                        .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
