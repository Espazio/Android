package com.jonaxel.testparse;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jonathan on 10/11/14.
 */
public class FragmentTestClass extends Fragment {

    ImageView ivIcon;
    TextView tvItemName;

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public FragmentTestClass() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_fragmentlayout, container,
                false);

        //ivIcon = (ImageView) view.findViewById(R.id.frag3_icon);
        //tvItemName = (TextView) view.findViewById(R.id.frag3_text);

        //tvItemName.setText(getArguments().getString(ITEM_NAME));
        /*ivIcon.setImageDrawable(view.getResources().getDrawable(
                getArguments().getInt(IMAGE_RESOURCE_ID)));*/
        return view;
    }
}
