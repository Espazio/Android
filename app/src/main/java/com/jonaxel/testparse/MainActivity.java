package com.jonaxel.testparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jonathan on 24/10/14.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnPost = (Button) findViewById(R.id.btnPost);
        Button btnGet = (Button) findViewById(R.id.btnGet);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Get();
            }
        });
    }

        public void Post() {
            Intent i = new Intent(this, Post.class);
            startActivity(i);
        }
        public void Get() {
            Intent i = new Intent(this, Get.class);
            startActivity(i);
        }
}
