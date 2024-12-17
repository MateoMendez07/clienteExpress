package com.example.consumodeservicios;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnPrimerServicio = findViewById(R.id.btnPrimerServicio);
        Button btnSegundoServicio = findViewById(R.id.btnSegundoServicio);
        Button btnTercerServicio = findViewById(R.id.btnTercerServicio);
        Button btnCuartoServicio = findViewById(R.id.btnCuartoServicio);
        Button btnQuintoServicio = findViewById(R.id.btnQuintoServicio);
        Button btnSextoServicio = findViewById(R.id.btnSextoServicio);
        Button btnSeptimoServicio = findViewById(R.id.btnSeptimoServicio);
        btnPrimerServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrimerServicio.class);
                startActivity(intent);
            }
        });

        btnSegundoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundoServicio.class);
                startActivity(intent);
            }
        });

        btnTercerServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TercerServicio.class);
                startActivity(intent);
            }
        });

        btnCuartoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CuartoServicio.class);
                startActivity(intent);
            }
        });

        btnQuintoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuintoServicio.class);
                startActivity(intent);
            }
        });

        btnSextoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SextoServicio.class);
                startActivity(intent);
            }
        });

        btnSeptimoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeptimoServicio.class);
                startActivity(intent);
            }
        });
    }
}