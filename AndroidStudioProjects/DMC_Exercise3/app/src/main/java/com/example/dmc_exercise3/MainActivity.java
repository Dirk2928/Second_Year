package com.example.dmc_exercise3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCompute;
    EditText tnMass, tnVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tnMass = findViewById(R.id.tnMass);
        tnVolume = findViewById(R.id.tnVolume);
        btnCompute = findViewById(R.id.btnCompute);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void DoCompute(View view){
        String MassInput = tnMass.getText().toString();
        String VolumeInput = tnVolume.getText().toString();
        double Mass = Double.parseDouble(MassInput);
        double Volume = Double.parseDouble(VolumeInput);

        double Density = Mass / Volume;

        Toast.makeText(this, "Density is " + Density, Toast.LENGTH_LONG).show();
    }
}