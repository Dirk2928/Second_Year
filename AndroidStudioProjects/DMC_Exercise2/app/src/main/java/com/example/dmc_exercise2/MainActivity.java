package com.example.dmc_exercise2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btnViolet);
        b2 = findViewById(R.id.btnGray);
        b3 = findViewById(R.id.btnWhite);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }public void DoVIOLET(View view) {
        findViewById(R.id.main).setBackgroundColor(Color.MAGENTA);
        b1.setTextColor(Color.MAGENTA);
        b2.setTextColor(Color.BLACK);
        b3.setTextColor(Color.BLACK);

    }public void DoGRAY(View view) {
        findViewById(R.id.main).setBackgroundColor(Color.GRAY);
        b1.setTextColor(Color.BLACK);
        b2.setTextColor(Color.GRAY);
        b3.setTextColor(Color.BLACK);

    }public void DoWHITE(View view) {
    findViewById(R.id.main).setBackgroundColor(Color.WHITE);
        b1.setTextColor(Color.BLACK);
        b2.setTextColor(Color.BLACK);
        b3.setTextColor(Color.WHITE);
    }
}

