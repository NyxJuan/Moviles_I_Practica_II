package com.example.laboratorio2_fragmentos_tarea.Fragmentos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.laboratorio2_fragmentos_tarea.Adaptador.AdaptadorPersonajes;
import com.example.laboratorio2_fragmentos_tarea.Entidad.PersonajeVo;
import com.example.laboratorio2_fragmentos_tarea.Interfaces.IComunicaFragments;
import com.example.laboratorio2_fragmentos_tarea.R;

public class ListaPersonajesFragment extends Fragment {

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;
    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPersonajes();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Selecciona: " +listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarPersonaje(listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)));
            }
        });

        return vista;
    }

    private void llenarListaPersonajes() {
        listaPersonajes.add(new PersonajeVo(getString(R.string.grau_nombre),getString(R.string.grau_descripcion_corta),getString(R.string.grau_descripcion_larga),R.drawable.grau_rostro,R.drawable.grau_detalle));
        listaPersonajes.add(new PersonajeVo(getString(R.string.tupac_nombre),getString(R.string.tupac_descripcion_corta),getString(R.string.tupac_descripcion_larga),R.drawable.tupac_rostro,R.drawable.tupac_detalle));
        listaPersonajes.add(new PersonajeVo(getString(R.string.hipolito_nombre),getString(R.string.hipolito_descripcion_corta),getString(R.string.hipolito_descripcion_larga),R.drawable.hipolito_rostro,R.drawable.hipolito_detalle));
        listaPersonajes.add(new PersonajeVo(getString(R.string.bolognesi_nombre),getString(R.string.bolognesi_descripcion_corta),getString(R.string.bolognesi_descripcion_larga),R.drawable.bolognesi_rostro,R.drawable.bolognesi_detalle));
        listaPersonajes.add(new PersonajeVo(getString(R.string.ugarte_nombre),getString(R.string.ugarte_descripcion_corta),getString(R.string.ugarte_descripcion_larga),R.drawable.ugarte_rostro,R.drawable.ugarte_detalle));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;
        }
    }
}
