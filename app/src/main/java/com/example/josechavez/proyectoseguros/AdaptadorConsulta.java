package com.example.josechavez.proyectoseguros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
    public void onBindViewHolder(AdaptadorConsulta.ConsultaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.nombre.setText(p.getNombre());
        holder.apeliido.setText(p.getApellido());


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
        private TextView nombre;
        private TextView apeliido;
        private View v;

        public ConsultaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            nombre=v.findViewById(R.id.lblNombre);
            apeliido=v.findViewById(R.id.lblApellido);



        }

    }
    public interface OnConsultaClickListener{
        void onConsultaClick(Persona p);
    }
}
