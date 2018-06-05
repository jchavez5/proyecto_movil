package com.example.josechavez.proyectoseguros;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CrearPoliza extends AppCompatActivity implements View.OnClickListener {
    private TextView txtNombrePersona,txtCedulaPersona;
    private String idPersona,NombrePersona,CedulaPersona;

    private Intent i;
    private Bundle bundle;
    private EditText txtNumeroPoliza,txtNumeroPlaca,txtFechaI,txtFechaF,txtNombreAsesor,txtvalorp;
    private Button bfechai,bfechaf;
    private int dia , mes, año,dia2 , mes2, año2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_poliza);

        txtNombrePersona=findViewById(R.id.txtNombrePersona);
        txtCedulaPersona=findViewById(R.id.txtCedulaPersona);

        txtNumeroPoliza=findViewById(R.id.txtPoliza);
        txtNumeroPlaca=findViewById(R.id.txtPlaca);
        txtFechaI=findViewById(R.id.txtFechai);
        txtFechaF=findViewById(R.id.txtFechaf);
        txtNombreAsesor=findViewById(R.id.txtAsesor);
        txtvalorp=findViewById(R.id.txtValor);


        //datos de la persona
        i =getIntent();
        bundle = i.getBundleExtra("datos");
        idPersona=bundle.getString("id");
        NombrePersona=bundle.getString("nombre");
        CedulaPersona=bundle.getString("cedula");

        txtNombrePersona.setText(NombrePersona);
        txtCedulaPersona.setText(CedulaPersona);

        //botones de la fecha
        bfechai=findViewById(R.id.fechai);
        bfechaf=findViewById(R.id.fechaf);
        bfechai.setOnClickListener(this);
        bfechaf.setOnClickListener(this);


    }
    public boolean  validacion(EditText[] editTexts,String error){
        for (int i = 0; i < editTexts.length; i++) {
            if (editTexts[i].getText().toString().equals("")){
                Toast.makeText(this,""+error,Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }



    public void guardar(View view){
        if (validacion(new EditText[]{txtNumeroPoliza,txtNumeroPlaca,txtFechaI,txtFechaF,txtNombreAsesor,txtvalorp},getResources().getString(R.string.error))){

            String Placa,id,fechaI,fechaF,Asesor,Npoliza,valop;
            Npoliza=txtNumeroPoliza.getText().toString();
            Placa=txtNumeroPlaca.getText().toString();
            fechaI=txtFechaI.getText().toString();
            fechaF=txtFechaF.getText().toString();
            Asesor=txtNombreAsesor.getText().toString();
            valop=txtNumeroPoliza.getText().toString();
            id=Datos.getIdPoliza();
            Poliza poliza = new Poliza(id,Npoliza,Placa,fechaI,fechaF,Asesor,idPersona,valop);
            poliza.guardar();
            Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }
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
        txtvalorp.setText("");
    }
    //FECHAS
    @Override
    public void onClick(View view) {
        if (view==bfechai){
            final Calendar calendar= Calendar.getInstance();
            dia=calendar.get(Calendar.DAY_OF_MONTH);
            mes=calendar.get(Calendar.MONTH);
            año=calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int dayOfMonth, int monthOfYear, int year) {
                    txtFechaI.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,año);
            datePickerDialog.show();
        }
        if (view==bfechaf){
            final Calendar calendar= Calendar.getInstance();
            dia2=calendar.get(Calendar.DAY_OF_MONTH);
            mes2=calendar.get(Calendar.MONTH);
            año2=calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int dayOfMonth, int monthOfYear, int year) {
                    txtFechaF.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia2,mes2,año2);
            datePickerDialog.show();
        }

    }
}