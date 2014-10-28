package com.jonaxel.testparse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;


public class Post extends Activity {

    EditText Nombre, Password, email, pais;
    String strNombre, strPassword, strEmail, strPais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);

        Parse.initialize(this, "5WuiPSAi4muY3pCKIW7MtsB8Y33imI4zrK0fLxA7", "WN7W7Y2FZo0khvdD9PGiQNjxC0Iq27x0czCIsQ3P");


        Button btn = (Button) findViewById(R.id.btnPost);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Nombre = (EditText) findViewById(R.id.Nombre);
                Password = (EditText) findViewById(R.id.Password);
                email = (EditText) findViewById(R.id.email);
                pais = (EditText) findViewById(R.id.Pais);

                strNombre = Nombre.getText().toString();
                strPassword = Password.getText().toString();
                strEmail = email.getText().toString();
                strPais = pais.getText().toString();

                ParseObject user = new ParseObject("Registro");
                user.put("nombre", strNombre);
                user.put("email", strEmail);
                user.put("servicio", strPais);

                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Mal", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
