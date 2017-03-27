package com.example.msk.alldemo10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {
    private Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        buttonback = (Button) findViewById(R.id.backshow);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(Help.this, MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(it);

            }

        });

    }

}
