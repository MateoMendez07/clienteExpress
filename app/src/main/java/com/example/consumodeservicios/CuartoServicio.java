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

public class CuartoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuarto_servicio);

        Button btnSuma = findViewById(R.id.btnSuma);
        TextView txtNumero1 = findViewById(R.id.txtNumero1);
        TextView txtResultado = findViewById(R.id.txtResultado);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numero1 = txtNumero1.getText().toString();
                enviarNumero(numero1, txtResultado);

            }
        });
    }

    private void enviarNumero(String numero1, TextView txtResultado) {
        // URL del servidor
        String url = "http://192.168.100.118:3000/sumas/" + numero1;
        // Crear la solicitud HTTP usando Volley
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Si la solicitud es exitosa
                        txtResultado.setText(response); // Mostrar la respuesta en el TextView
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Si hay un error en la solicitud
                        Toast.makeText(CuartoServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}