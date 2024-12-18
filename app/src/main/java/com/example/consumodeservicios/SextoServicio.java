package com.example.consumodeservicios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SextoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sexto_servicio);

        Button btnCalcularAyP = findViewById(R.id.btnCalcularAyP);
        EditText txtRadio = findViewById(R.id.txtRadio);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnCalcularAyP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radio = txtRadio.getText().toString();
                enviarRadio(radio, txtRespuesta);
            }
        });
    }

    private void enviarRadio(String radio, TextView txtRespuesta) {
        // URL del servidor
        String url = "http://10.10.13.65:3000/circulo/areayperimetro/" + radio;
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
                        Toast.makeText(SextoServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}