package com.example.josechavez.proyectoseguros;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtNombre,txtApellido,txtCedula,txtCelular,txtDireccion;
    private RadioGroup  op;
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
        //Spinner de sexo
        spn_sexo = findViewById(R.id.lst_Sexo);
        opc_sexo = this.getResources().getStringArray(R.array.lista_sexo);
        adp_sexo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_sexo);
        spn_sexo.setAdapter(adp_sexo);


    }
    public String obtenerSexoSpinner(Spinner spinner){
        String cadena="";
        cadena=spinner.getSelectedItem().toString();
        //Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
        return  cadena;
    }
    public int ColocarFoto(Spinner spinner){
        int foto=0;
        int posicion=spinner.getSelectedItemPosition();
        if (posicion==0){
            foto=R.drawable.hombre;
        }
        if (posicion==1){
            foto=R.drawable.mujer;
        }

        return foto;
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
            String nombre,apellido,id,direccion,cedula,sexo,celular;
            int foto;

            nombre=txtNombre.getText().toString();
            apellido=txtApellido.getText().toString();
            cedula=txtCedula.getText().toString();
            direccion=txtDireccion.getText().toString();
            celular=txtCelular.getText().toString();
            sexo=obtenerSexoSpinner(spn_sexo);
            foto=ColocarFoto(spn_sexo);
            id=Datos.getId();
            Persona p = new Persona(id,cedula,nombre,apellido,sexo,celular,direccion,foto);
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

