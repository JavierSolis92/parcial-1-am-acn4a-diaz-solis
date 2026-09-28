package com.example.parcial1diazsolis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spEjercicios;
    private Button btnAgregar;
    private LinearLayout layoutContenedorEjercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // mapeo de vistas
        spEjercicios = findViewById(R.id.spEjercicios);
        btnAgregar = findViewById(R.id.btnAgregar);
        layoutContenedorEjercicios = findViewById(R.id.layoutContenedorEjercicios);

        // opciones del Spinner
        String[] ejercicios = {
                "Press de Banca Plano",
                "Curl de Bíceps con Barra W",
                "Sentadilla Pesada",
                "Peso Muerto"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ejercicios);
        spEjercicios.setAdapter(adapter);

        // evento del botón para agregar ejercicio
        btnAgregar.setOnClickListener(v -> agregarEjercicio());
    }

    private void agregarEjercicio() {
        if (spEjercicios.getSelectedItem() == null) return;

        String nombreEjercicio = spEjercicios.getSelectedItem().toString();

        // inflar el CardView desde item_ejercicio.xml
        LayoutInflater inflater = LayoutInflater.from(this);
        View tarjetaView = inflater.inflate(R.layout.item_ejercicio, layoutContenedorEjercicios, false);

        // mapear elementos internos de la tarjeta inflada
        TextView tvNombre = tarjetaView.findViewById(R.id.tvNombreEjercicio);
        TextView tvDetalle = tarjetaView.findViewById(R.id.tvDetalleEjercicio);
        ImageView imgEjercicio = tarjetaView.findViewById(R.id.imgEjercicio);
        Button btnEliminar = tarjetaView.findViewById(R.id.btnEliminar);

        // asignar datos dinámicos
        tvNombre.setText(nombreEjercicio);
        tvDetalle.setText("Series de alta intensidad");

        // cambiar la imagen dinámicamente según el texto
        if (nombreEjercicio.contains("Press")) {
            imgEjercicio.setImageResource(R.drawable.img_press_banca);
        } else if (nombreEjercicio.contains("Sentadilla")) {
            imgEjercicio.setImageResource(R.drawable.img_sentadilla);
        } else if (nombreEjercicio.contains("Peso Muerto")) {
            imgEjercicio.setImageResource(R.drawable.img_peso_muerto);
        } else {
            // imagen por defecto si no coincide ninguna
            imgEjercicio.setImageResource(R.drawable.img_press_banca);
        }

        // botón Eliminar
        btnEliminar.setOnClickListener(v -> {
            layoutContenedorEjercicios.removeView(tarjetaView);
            Toast.makeText(this, "Ejercicio eliminado", Toast.LENGTH_SHORT).show();
        });

        // agregar la tarjeta al ScrollView principal
        layoutContenedorEjercicios.addView(tarjetaView);
    }
}