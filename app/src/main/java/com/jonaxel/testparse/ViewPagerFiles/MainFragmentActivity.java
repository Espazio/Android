package com.jonaxel.testparse.ViewPagerFiles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jonaxel.testparse.R;

import java.util.List;
import java.util.Vector;

/**
 * Created by jonathan on 29/10/14.
 */

public class MainFragmentActivity extends Fragment {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);


        initPagin();

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_layout, container,
                false);
        initPagin(view);

        return view;
    }



    private void initPagin(View inflatedLayout) {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(getActivity(), Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(getActivity(), Fragment2.class.getName()));
        fragments.add(Fragment.instantiate(getActivity(), Fragment3.class.getName()));
        PagerAdapter mPagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager) inflatedLayout.findViewById(R.id.viewpager);
//        pager.setPageTransformer(true, new ZoomOutTranformer());
        pager.setAdapter(mPagerAdapter);

    }
}
