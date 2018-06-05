package com.example.josechavez.proyectoseguros;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetallePoliza extends AppCompatActivity {
    private TextView txtNplaca;
    private TextView txtNPoliza;
    private TextView txtFechai;
    private TextView txtFechaf;
    private TextView txtCosto;
    private TextView txtnomAsesor;
    private String id,placa,poliza,fechai,fechaf,costo,nomasesor;
     private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_poliza);
        txtNplaca = findViewById(R.id.txtNplaca);
        txtNPoliza = findViewById(R.id.txtNPoliza);
        txtFechai = findViewById(R.id.txtFechai);
        txtFechaf = findViewById(R.id.txtFechaf);
        txtCosto=findViewById(R.id.txtValor);
        txtnomAsesor=findViewById(R.id.txtAsesor);
        i =getIntent();
        bundle = i.getBundleExtra("datos");
        placa = bundle.getString("nplaca");
        poliza = bundle.getString("npoliza");
        fechai = bundle.getString("fechainicio");
        fechaf = bundle.getString("fechafinal");
        costo = bundle.getString("valor_poliza");
        nomasesor= bundle.getString("nombreAsesor");

        id = bundle.getString("id");

        txtNplaca.setText(placa);
        txtNPoliza.setText(poliza);
        txtFechai.setText(fechai);
        txtFechaf.setText(fechaf);
        txtCosto.setText(costo);
        txtnomAsesor.setText(nomasesor);

    }
    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Poliza p = new Poliza(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetallePoliza.this,ListaPoliza.class);
        startActivity(i);
    }
}
