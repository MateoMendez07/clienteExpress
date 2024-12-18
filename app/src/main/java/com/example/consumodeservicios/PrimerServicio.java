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

import org.json.JSONArray;
import org.json.JSONObject;

public class PrimerServicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primer_servicio);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerSolicitud(txtRespuesta);
            }
        });
    }

    private void hacerSolicitud(final TextView txtRespuesta){
        //establecer url
        String url = "http://192.168.100.118:3000/nombre/";
        // Crear la solicitud HTTP usando Volley
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Procesar la respuesta JSON
                            JSONArray jsonArray = new JSONArray(response);
                            StringBuilder nombres = new StringBuilder();

                            // Iterar sobre el JSON para obtener solo los nombres
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                nombres.append(obj.getString("nombre")).append("\n");
                            }

                            // Mostrar los nombres en el TextView
                            txtRespuesta.setText(nombres.toString().trim());
                        } catch (Exception e) {
                            // Manejar errores en el procesamiento del JSON
                            txtRespuesta.setText("Error al procesar la respuesta");
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Si hay un error en la solicitud
                        Toast.makeText(PrimerServicio.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Crear un RequestQueue y hacer la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}