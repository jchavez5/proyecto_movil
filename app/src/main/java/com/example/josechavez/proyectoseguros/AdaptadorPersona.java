package com.example.josechavez.proyectoseguros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Josechavez on 02/06/2018.
 */

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {
private ArrayList<Persona> personas;
private OnPersonaClickListener clickListener;
public AdaptadorPersona(ArrayList<Persona> personas, OnPersonaClickListener clickListener) {
        this.personas = personas;
        this.clickListener = clickListener;
        }


    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_persona, parent, false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.nombre.setText(p.getNombre());
        holder.apeliido.setText(p.getApellido());
        holder.foto.setImageResource(p.getFoto());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPersonaClick(p);
            }
        });
    }
    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView apeliido;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            nombre=v.findViewById(R.id.lblNombre);
            apeliido=v.findViewById(R.id.lblApellido);



        }

    }
    public interface OnPersonaClickListener{
        void onPersonaClick(Persona p);
    }
}
