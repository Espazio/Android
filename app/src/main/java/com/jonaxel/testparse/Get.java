package com.jonaxel.testparse;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


/**
 * Created by jonathan on 24/10/14.
 */
public class Get extends Fragment {

    public TextView textView;
    public Button btnObtener;
    public EditText editTextNombre;
    String strNombre;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_activity);

        Parse.initialize(this, "5WuiPSAi4muY3pCKIW7MtsB8Y33imI4zrK0fLxA7", "WN7W7Y2FZo0khvdD9PGiQNjxC0Iq27x0czCIsQ3P");

        textView = (TextView) findViewById(R.id.Nombre);
        btnObtener = (Button) findViewById(R.id.button);

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
                query.getInBackground("CofixcfvGfJogAXWkPHQg44lhIlgv1uEeHizUZBt", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            // object will be your game score

                            textView.setText(object.getString("foo"));

                            Toast.makeText(getApplicationContext(), "Funciono el ParseQuery", Toast.LENGTH_SHORT).show();

                        } else {
                            // something went wrong
                            
                            Toast.makeText(getApplicationContext(), "NO Funciono el ParseQuery", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.get_activity, container, false);

        Parse.initialize(getActivity(), "CofixcfvGfJogAXWkPHQg44lhIlgv1uEeHizUZBt", "wo0lZyD1DpzhcyhvM2tyMsMi5hR7klpfCKsmiD0H");

        textView = (TextView) rootView.findViewById(R.id.textView);
        btnObtener = (Button) rootView.findViewById(R.id.button);
        editTextNombre = (EditText) rootView.findViewById(R.id.editTextNombre);

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*final ParseQuery<ParseObject> query = ParseQuery.getQuery("Registro");
                query.getInBackground("qsI3HmEpUf", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            // object will be your game score
                            textView.setText(object.getString("nombre"));

                            Toast.makeText(getActivity(), "Funciono el ParseQuery", Toast.LENGTH_SHORT).show();

                        } else {
                            // something went wrong

                            Toast.makeText(getActivity(), "NO Funciono el ParseQuery", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Registro");
                query.whereEqualTo("nombre", editTextNombre.getText().toString());
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> scoreList, ParseException e) {
                        if (e == null) {
                            Log.d("score", "Retrieved " + scoreList.size() + " scores");
                            scoreList.get(1);
                        } else {
                            Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });
            }
        });

        return rootView;
    }
}


