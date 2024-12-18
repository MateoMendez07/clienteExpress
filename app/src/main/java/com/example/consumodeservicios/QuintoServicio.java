package com.example.consumodeservicios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class QuintoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quinto_servicio);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        TextView txtLado = findViewById(R.id.txtLado);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lado = txtLado.getText().toString();
                enviarLado(lado, txtRespuesta);
            }
        });
    }
    private void enviarLado(String lado, TextView txtRespuesta) {
        // URL del servidor
        String url = "http://10.10.13.65:3000/cuadrado/areayperimetro/" + lado;
        // Crear la solicitud HTTP usando Volley
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtRespuesta.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(QuintoServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}