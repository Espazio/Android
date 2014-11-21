package com.jonaxel.testparse;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by jonathan on 13/11/14.
 */
public class SearchResultActivity extends FragmentActivity {

    private final LatLng UPV = new LatLng(39.481106, -0.340987);
    private LatLng positionDinamic;

    private TextView txtQuery;

    String querySearch = null;

    private double lat;
    private double lng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Parse.initialize(this, "CofixcfvGfJogAXWkPHQg44lhIlgv1uEeHizUZBt", "wo0lZyD1DpzhcyhvM2tyMsMi5hR7klpfCKsmiD0H");

        // get the action bar
        ActionBar actionBar = getActionBar();

        // Enabling Back navigation on Action Bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtQuery = (TextView) findViewById(R.id.txtQuery);


        GoogleMap mapa = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        mapa.getUiSettings().setZoomControlsEnabled(false);
        mapa.getUiSettings().setCompassEnabled(true);
        mapa.addMarker(new MarkerOptions()
                .position(UPV)
                .title("Test")
                .snippet(querySearch)
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.ic_launcher))
                .anchor(0.5f, 0.5f));
        handleIntent(getIntent());

        //handleMap();
    }

    private void handleMap() {

        Log.d("handleMap LatLng", positionDinamic.toString());

    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handling intent data
     */
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            querySearch = intent.getStringExtra(SearchManager.QUERY);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("Mexico");
            query.whereEqualTo("Nombre", querySearch);
            query.getFirstInBackground(new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (object == null) {
                        Log.d("score", "Error: " + e.getMessage());
                    } else {
                        Log.d("Nombre: ", "Retrieved " + object.getString("Precio") + " scores");
                        txtQuery.setText("El precio de es de: " + object.getString("Precio"));
                        lat = Double.parseDouble(object.getString("Lat"));
                        lng = Double.parseDouble(object.getString("Lnt"));

                        positionDinamic = new LatLng(lat, lng);

                        Log.d("LatLng", positionDinamic.toString());
                    }
                }
            });

        }
    }
}
