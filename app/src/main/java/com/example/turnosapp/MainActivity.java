package com.example.turnosapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText campoNombre;
    EditText campoEspecialidad;
    Button botonAgregar;
    LinearLayout contenedorTurnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = findViewById(R.id.campoNombre);
        campoEspecialidad = findViewById(R.id.campoEspecialidad);
        botonAgregar = findViewById(R.id.botonAgregar);
        contenedorTurnos = findViewById(R.id.contenedorTurnos);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = campoNombre.getText().toString();
                String especialidad = campoEspecialidad.getText().toString();

                if (nombre.isEmpty() || especialidad.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.mensaje_vacio), Toast.LENGTH_SHORT).show();
                    return;
                }

                TextView nuevoTurno = new TextView(MainActivity.this);
                nuevoTurno.setText("• " + nombre + " - " + especialidad);
                nuevoTurno.setTextSize(16);
                nuevoTurno.setTextColor(getResources().getColor(R.color.azul));
                nuevoTurno.setPadding(8, 12, 8, 12);

                contenedorTurnos.addView(nuevoTurno);

                campoNombre.setText("");
                campoEspecialidad.setText("");
            }
        });
    }
}