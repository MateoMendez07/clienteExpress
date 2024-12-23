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

public class Trinomio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trinomio);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        EditText txtNumero1 = findViewById(R.id.txtNumero1);
        EditText txtNumero2 = findViewById(R.id.txtNumero2);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1 = txtNumero1.getText().toString();
                String numero2 = txtNumero2.getText().toString();
                enviarDatos(numero1, numero2, txtRespuesta);
            }
        });
    }

    private void enviarDatos(String numero1, String numero2, TextView txtRespuesta) {
        // URL del servidor
        String url = "http://10.10.13.65:3000/trinomio/cuadradoPerfecto/" + numero1 + "/" + numero2;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String respuesta) { //parametro respuesta almacena la respuesta del servidor
                        txtRespuesta.setText(respuesta);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Trinomio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}