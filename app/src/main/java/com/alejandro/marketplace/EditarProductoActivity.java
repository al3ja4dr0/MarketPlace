package com.alejandro.marketplace;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alejandro.marketplace.model.Producto;

public class EditarProductoActivity extends AppCompatActivity {

    EditText editTitulo, editPrecio, editDescripcion;
    Button btnGuardar;
    Producto productoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarproducto);

        editTitulo = findViewById(R.id.editTitulo);
        editPrecio = findViewById(R.id.editPrecio);
        editDescripcion = findViewById(R.id.editDescripcion);
        btnGuardar = findViewById(R.id.btnGuardarCambios);

        int id = getIntent().getIntExtra("id", -1);
        productoActual = Producto.buscarPorId(id);

        if (productoActual != null) {
            editTitulo.setText(productoActual.getTitulo());
            editPrecio.setText(String.valueOf(productoActual.getPrecio()));
            editDescripcion.setText(productoActual.getDescripcion());
        }

        btnGuardar.setOnClickListener(v -> {
            productoActual.setTitulo(editTitulo.getText().toString());
            productoActual.setPrecio(Integer.parseInt(editPrecio.getText().toString()));
            productoActual.setDescripcion(editDescripcion.getText().toString());
            finish();
        });
    }
}
