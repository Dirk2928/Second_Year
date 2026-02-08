package com.example.dmc_exercise1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;
    TextView tvName;
    Button btnMagenta, btnGray, btnWhite;
    String strName, s1, s2, s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        strName = "PILI KA KULAY";
        s1 = "UBE";
        s2 = "ABO";
        s3 = "LANGIT";
        tvName = new TextView(this);
        tvName.setTextSize(40);
        tvName.setGravity(Gravity.CENTER);
        tvName.setText(strName);
        btnMagenta = new Button(this);
        btnGray = new Button(this);
        btnWhite = new Button(this);
        btnMagenta.setText(s1);
        btnGray.setText(s2);
        btnWhite.setText(s3);

        btnMagenta.setOnClickListener(v -> {
            myLayout.setBackgroundColor(Color.MAGENTA);
            btnMagenta.setTextColor(Color.MAGENTA);
            btnGray.setTextColor(Color.BLACK);
            btnWhite.setTextColor(Color.BLACK);
        });

        btnGray.setOnClickListener(v -> {
            myLayout.setBackgroundColor(Color.GRAY);
            btnMagenta.setTextColor(Color.BLACK);
            btnGray.setTextColor(Color.GRAY);
            btnWhite.setTextColor(Color.BLACK);
        });

        btnWhite.setOnClickListener(v -> {
            myLayout.setBackgroundColor(Color.WHITE);
            btnMagenta.setTextColor(Color.BLACK);
            btnGray.setTextColor(Color.BLACK);
            btnWhite.setTextColor(Color.WHITE);
        });

        myLayout.addView(tvName);
        myLayout.addView(btnMagenta);
        myLayout.addView(btnGray);
        myLayout.addView(btnWhite);


        setContentView(myLayout);
        ViewCompat.setOnApplyWindowInsetsListener(myLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}