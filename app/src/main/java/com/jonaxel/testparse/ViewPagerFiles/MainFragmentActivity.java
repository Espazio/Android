package com.jonaxel.testparse.ViewPagerFiles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


import com.jonaxel.testparse.R;

import java.util.List;
import java.util.Vector;

/**
 * Created by jonathan on 29/10/14.
 */
public class MainFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);


        initPagin();

    }


    private void initPagin() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment2.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment3.class.getName()));
        PagerAdapter mPagerAdapter = new PagerAdapter(this.getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setPageTransformer(true, new ZoomOutTranformer());
        pager.setAdapter(mPagerAdapter);

    }
}
