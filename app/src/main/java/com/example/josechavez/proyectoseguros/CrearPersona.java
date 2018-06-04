package com.example.josechavez.proyectoseguros;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtNombre,txtApellido,txtCedula,txtCelular,txtDireccion;
    private RadioButton txtHombre,txtMujer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        txtNombre=findViewById(R.id.txtNombre);
        txtApellido=findViewById(R.id.txtApellido);
        txtCedula=findViewById(R.id.txtCedula);
        txtCelular=findViewById(R.id.txtCelular);
        txtDireccion=findViewById(R.id.txtDireccion);
        txtHombre=findViewById(R.id.hombre);
        txtMujer=findViewById(R.id.mujer);


    }

    public String obtenerSexo(RadioButton hombre,RadioButton mujer){
        String cadena="";
        if (txtHombre.isChecked()){
            cadena=hombre.getText().toString();
        }
        if (txtMujer.isChecked()){
            cadena=mujer.getText().toString();
        }
        return cadena;
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
        if (validacion(new EditText[]{txtNombre,txtApellido,txtCedula,txtCelular,txtDireccion},getResources().getString(R.string.error))){
            String nombre,apellido,id,cedula,direccion,sexo;
            int celular;
            nombre=txtNombre.getText().toString();
            apellido=txtApellido.getText().toString();
            cedula=txtCedula.getText().toString();
            direccion=txtDireccion.getText().toString();
            celular=Integer.parseInt(txtCelular.getText().toString());
            sexo=obtenerSexo(txtHombre,txtMujer);
            id=Datos.getId();
            Persona p = new Persona(id,cedula,nombre,apellido,sexo,celular,direccion);
            p.guardar();
            Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }



    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtApellido.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");

    }
}

