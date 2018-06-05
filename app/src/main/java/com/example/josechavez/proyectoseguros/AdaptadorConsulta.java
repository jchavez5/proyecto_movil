package com.example.josechavez.proyectoseguros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Josechavez on 03/06/2018.
 */

public class AdaptadorConsulta extends RecyclerView.Adapter<AdaptadorConsulta.ConsultaViewHolder> {
    private ArrayList<Persona> personas;
    private AdaptadorConsulta.OnConsultaClickListener clickListener;

    public AdaptadorConsulta(ArrayList<Persona> personas, AdaptadorConsulta.OnConsultaClickListener clickListener) {
        this.personas = personas;
        this.clickListener = clickListener;
    }


    @Override
    public AdaptadorConsulta.ConsultaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_consultapoliza, parent, false);
        return new AdaptadorConsulta.ConsultaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AdaptadorConsulta.ConsultaViewHolder holder, final int position) {
        final Persona p = personas.get(position);

        holder.nombreCompleto.setText(p.getNombre() + " " + p.getApellido());
        holder.cedula.setText(p.getCedula());
        holder.id.setText(p.getId());






        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onConsultaClick(p);
            }
        });
    }
    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class ConsultaViewHolder extends RecyclerView.ViewHolder{
        private TextView nombreCompleto,valor,cedula,id;
        private View v;

        public ConsultaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            cedula=v.findViewById(R.id.lblCedula);
            nombreCompleto=v.findViewById(R.id.lblNombre);
            id=v.findViewById(R.id.id);





        }

    }
    public interface OnConsultaClickListener{
        void onConsultaClick(Persona p);
    }
}