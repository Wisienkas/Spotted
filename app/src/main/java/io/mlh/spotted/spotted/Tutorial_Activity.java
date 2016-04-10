package io.mlh.spotted.spotted;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import io.mlh.spotted.spotted.Activities.SwipeAdapter;

public class Tutorial_Activity extends FragmentActivity {
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        vp = (ViewPager)findViewById(R.id.view_pager);
        SwipeAdapter swad = new SwipeAdapter(getSupportFragmentManager());
        vp.setAdapter(swad);
    }
}
