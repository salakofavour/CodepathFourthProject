package com.example.codepathproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class general extends AppCompatActivity {
    TextView gtitle, gbody, gpicture;
    Button Previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("Title");
        String body = bundle.getString("Body");
        String picture = bundle.getString("Picture");

        gtitle.setText(title);
        gbody.setText(body);
        gpicture.setText(picture);

        Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}