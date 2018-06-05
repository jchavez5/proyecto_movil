package com.example.josechavez.proyectoseguros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePoliza extends AppCompatActivity {
    private TextView txtNplaca;
    private TextView txtNPoliza;
    private TextView txtFechai;
    private TextView txtFechaf;
    private TextView txtCosto;
    private ImageView fot;
    private String id,marca,ram,color,tipo,sistema;
    private int foto;
    private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_poliza);
        txtNplaca = findViewById(R.id.txtNplaca);
        txtNPoliza = findViewById(R.id.txtPoliza);
        txtFechai = findViewById(R.id.txtFechai);
        txtFechaf = findViewById(R.id.txtFechaf);
        txtCosto=findViewById(R.id.txtValor);
        fot = findViewById(R.id.foto_mostrar);

    }
}
