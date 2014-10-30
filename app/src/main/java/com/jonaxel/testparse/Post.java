package com.jonaxel.testparse;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;


public class Post extends Fragment {

    EditText Nombre, Apellido, email, Servicio;
    String strNombre, strApellido, strEmail, strServicio;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.post_activity, container, false);

       Parse.initialize(getActivity(), "CofixcfvGfJogAXWkPHQg44lhIlgv1uEeHizUZBt", "wo0lZyD1DpzhcyhvM2tyMsMi5hR7klpfCKsmiD0H");

        Button btn = (Button) rootView.findViewById(R.id.btnPost);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Nombre = (EditText) rootView.findViewById(R.id.Nombre);
                Apellido = (EditText) rootView.findViewById(R.id.Apellido);
                email = (EditText) rootView.findViewById(R.id.email);
                Servicio = (EditText) rootView.findViewById(R.id.Servicio);

                strNombre = Nombre.getText().toString();
                strApellido = Apellido.getText().toString();
                strEmail = email.getText().toString();
                strServicio = Servicio.getText().toString();

                ParseObject user = new ParseObject("Registro");
                user.put("nombre", strNombre);
                user.put("apellido", strApellido);
                user.put("email", strEmail);
                user.put("servicio", strServicio);

                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getActivity(), "Exito", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getActivity(), "Mal", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        return rootView;
    }
}