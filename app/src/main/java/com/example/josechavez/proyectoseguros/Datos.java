package com.example.josechavez.proyectoseguros;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Josechavez on 25/05/2018.
 */

public class Datos {
    private static String db ="persona";
    private static String db_poliza="poliza";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Persona> personas =new ArrayList<>();
    private static ArrayList<Poliza> polizas =new ArrayList<>();

//personas
    public static void guardar(Persona p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public static ArrayList<Persona> obtener(){
        return personas;
    }
    public static String getId(){
        return databaseReference.push().getKey();
    }
    public static void setPersonas(ArrayList<Persona> personas){
        Datos.personas = personas;
    }




    public static void eliminarPersona(Persona p){
        databaseReference.child(db).child(p.getId()).removeValue();
    }
   public static void modificarPersona(Persona p) {
       databaseReference.child(db).child(p.getId()).setValue(p);
   }


//polizas
    public static void guardarPoliza(Poliza poliza) {
        databaseReference.child(db_poliza).child(poliza.getId()).setValue(poliza);

    }
    public static ArrayList<Poliza> obtenerPoliza(){
        return polizas;
    }
    public static String getIdPoliza(){
        return databaseReference.push().getKey();
    }
    public static void setPoliza(ArrayList<Poliza> poliza){
        Datos.polizas = poliza;
    }
}
