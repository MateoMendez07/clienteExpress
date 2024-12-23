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

public class SegundoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segundo_servicio);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            hacerSolicitud(txtRespuesta);
            }
        });
    }

    private void hacerSolicitud(TextView txtRespuesta) {
        // URL del servidor
        String url = "http://10.10.13.65:3000/Mateo";

        // Crear la solicitud HTTP usando Volley
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String respuesta) { //parametro respuesta almacena la respuesta del servidor
                        // Si la solicitud es exitosa
                        txtRespuesta.setText(respuesta); // Mostrar la respuesta en el TextView
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Si hay un error en la solicitud
                        Toast.makeText(SegundoServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}