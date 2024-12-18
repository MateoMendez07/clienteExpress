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

public class SeptimoServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_septimo_servicio);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        EditText txtBase = findViewById(R.id.txtBase);
        EditText txtAltura = findViewById(R.id.txtAltura);
        EditText txtLado = findViewById(R.id.txtLado);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base = txtBase.getText().toString();
                String altura = txtAltura.getText().toString();
                String lado = txtLado.getText().toString();
                enviarDatos(base, altura, lado, txtRespuesta);
            }
        });
    }

    private void enviarDatos(String base, String altura, String lado, TextView txtRespuesta) {
        // URL del servidor
        String url = "http://10.10.13.65:3000/paralelogramo/areayperimetro/" + base + "/" + altura + "/" + lado;
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
                        Toast.makeText(SeptimoServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
    }