package com.jonaxel.testparse.MenuFiles;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jonaxel.testparse.FragmentTestClass;
import com.jonaxel.testparse.ViewPagerFiles.MainFragmentActivity;
import com.jonaxel.testparse.R;

public class NavigationDrawerTest extends FragmentActivity {

    private DrawerLayout mDrawerLayout;

    private DrawerLayout myDrawerLayout;

    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    CustomDrawerAdapter adapter;

    FragmentManager frgManager;
    FragmentManager fragmentManager;

    Fragment fragment = null;
    Fragment fragment2 = null;

    ActionBar actionBar;

    List<DrawerItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_test);

        // Initializing
        actionBar = getActionBar();

        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        myDrawerLayout = (DrawerLayout) findViewById(R.id.test_drawerlayout);

        /*myDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);*/

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);

        // Add Drawer Item to dataList

        dataList.add(new DrawerItem(true)); // adding a spinner to the list

        dataList.add(new DrawerItem("My Favorites")); // adding a header to the list
        dataList.add(new DrawerItem("Mapa", R.drawable.ic_action_email));
        dataList.add(new DrawerItem("¿Cómo funciona?", R.drawable.ic_action_good));
        dataList.add(new DrawerItem("Acerca de", R.drawable.ic_action_about));
        dataList.add(new DrawerItem("Caracterízticas del espacio", R.drawable.ic_action_labels));

        dataList.add(new DrawerItem("Main Options"));// adding a header to the list
        dataList.add(new DrawerItem("Reservar", R.drawable.ic_action_search));
        dataList.add(new DrawerItem("Ayuda", R.drawable.ic_action_help));
        dataList.add(new DrawerItem("Camara", R.drawable.ic_action_camera));
        dataList.add(new DrawerItem("Video", R.drawable.ic_action_video));
        dataList.add(new DrawerItem("Groups", R.drawable.ic_action_group));
        dataList.add(new DrawerItem("Import & Export",
                R.drawable.ic_action_import_export));

        dataList.add(new DrawerItem("Other Option")); // adding a header to the list
        dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
        dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
        dataList.add(new DrawerItem("Help", R.drawable.ic_action_help));

        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true); //Sirve para darle click a el menu y se abra el Drawer

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()

                Log.i("Drawer: ", "DrawerClosed");
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()

                Log.i("Drawer: ", "DrawerOpen");
            }
        };

        if (savedInstanceState == null) {

            if (dataList.get(0).isSpinner()
                    & dataList.get(1).getTitle() != null) {
                SelectItem(2);
            } else if (dataList.get(0).getTitle() != null) {
                SelectItem(1);
            } else {
                SelectItem(0);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_drawer, menu);
        return true;
    }

    public void SelectItem(int possition) {


        Bundle args = new Bundle();
        Bundle args2 = new Bundle();

        switch (possition) {

            case 2:
                fragment = new FragmentThree();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
                        .get(possition).getImgResID());

                fragment.setArguments(args);

                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 3:

                fragment = new MainFragmentActivity();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
                        .get(possition).getImgResID());

                fragment.setArguments(args);

                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;

                //TODO: Use a fragment instead!
                //startActivity(new Intent(this, MainFragmentActivity.class));



            case 4:
                fragment = new FragmentTwo();
                actionBar.show();
                args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 5:
                fragment = new FragmentThree();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
                        .get(possition).getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 7:
                fragment = new FragmentTwo();
                actionBar.show();
                args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 8:

                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com")));

                /*fragment = new FragmentThree();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
                        .get(possition).getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();*/
                break;
            case 9:

                fragment = new FragmentOne();
                actionBar.show();
                args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 10:
                fragment = new FragmentTwo();
                actionBar.show();
                args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 11:
                fragment = new FragmentThree();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
                        .get(possition).getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 12:
                fragment = new FragmentOne();
                actionBar.show();
                args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 14:
                fragment = new FragmentThree();
                actionBar.show();
                args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 15:
                fragment = new FragmentOne();
                actionBar.show();
                args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 16:
                fragment = new FragmentTwo();
                actionBar.show();
                args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());

                fragment.setArguments(args);
                frgManager = getSupportFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            default:
                break;
        }


        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }

        return false;
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if (dataList.get(position).getTitle() == null) {
                SelectItem(position);
            }

        }
    }

}