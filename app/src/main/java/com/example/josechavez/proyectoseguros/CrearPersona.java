package com.example.josechavez.proyectoseguros;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtNombre,txtApellido,txtCedula,txtCelular,txtDireccion;
    private Spinner spn_sexo;
    private String [] opc_sexo;
    private ArrayAdapter<String> adp_sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        txtNombre=findViewById(R.id.txtNombre);
        txtApellido=findViewById(R.id.txtApellido);
        txtCedula=findViewById(R.id.txtCedula);
        txtCelular=findViewById(R.id.txtCelular);
        txtDireccion=findViewById(R.id.txtDireccion);
        //Spinner de Sexo
        spn_sexo = findViewById(R.id.sp_sexo);
        opc_sexo = this.getResources().getStringArray(R.array.op_lista_sexo);
        adp_sexo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_sexo);
        spn_sexo.setAdapter(adp_sexo);
    }

    public String obtenerCampo(Spinner spinner){
        String cadena="";
        cadena=spinner.getSelectedItem().toString();
        //Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
        return  cadena;
    }
    public void guardar(View view){
        String nombre,apellido,id,cedula,direccion,sexo;
        int celular;
        nombre=txtNombre.getText().toString();
        apellido=txtApellido.getText().toString();
        cedula=txtCedula.getText().toString();
        direccion=txtDireccion.getText().toString();
        celular=Integer.parseInt(txtCelular.getText().toString());
        sexo=obtenerCampo(spn_sexo);
        id=Datos.getId();
        Persona p = new Persona(id,cedula,nombre,apellido,sexo,celular,direccion);
        p.guardar();
        Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtApellido.setText("");
        txtNombre.setText("");

    }
}

