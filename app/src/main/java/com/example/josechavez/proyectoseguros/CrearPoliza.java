package com.example.josechavez.proyectoseguros;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CrearPoliza extends AppCompatActivity {
    private TextView txtNombrePersona,txtIdPersona;
    private String idPersona,NombrePersona;
    private Intent i;
    private Bundle bundle;
    private EditText txtNumeroPoliza,txtNumeroPlaca,txtFechaI,txtFechaF,txtNombreAsesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_poliza);

        txtIdPersona=findViewById(R.id.txtIdPersona);
        txtNombrePersona=findViewById(R.id.txtNombrePersona);
        txtNumeroPoliza=findViewById(R.id.txtPoliza);
        txtNumeroPlaca=findViewById(R.id.txtPlaca);
        txtFechaI=findViewById(R.id.txtFecha);
        txtFechaF=findViewById(R.id.txtFechaF);
        txtNombreAsesor=findViewById(R.id.txtAsesor);

        //datos de la persona
        i =getIntent();
        bundle = i.getBundleExtra("datos");
        idPersona=bundle.getString("id");
        NombrePersona=bundle.getString("nombre");

        txtIdPersona.setText(idPersona);
        txtNombrePersona.setText(NombrePersona);

    }


    public void guardar(View view){
        String Npoliza,Placa,id,fechaI,fechaF,Asesor;
        Npoliza=txtNumeroPoliza.getText().toString();
        Placa=txtNumeroPlaca.getText().toString();
        fechaI=txtFechaI.getText().toString();
        fechaF=txtFechaF.getText().toString();
        Asesor=txtNombreAsesor.getText().toString();
        id=Datos.getIdPoliza();
        Poliza poliza = new Poliza(id,Npoliza,Placa,fechaI,fechaF,Asesor,idPersona);
        poliza.guardar();
        Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtNumeroPoliza.setText("");
        txtNumeroPlaca.setText("");
        txtFechaI.setText("");
        txtFechaF.setText("");
        txtNombreAsesor.setText("");
    }
}
