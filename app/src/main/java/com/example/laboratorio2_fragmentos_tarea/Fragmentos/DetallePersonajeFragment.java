package com.example.laboratorio2_fragmentos_tarea.Fragmentos;

import android.app.Person;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.laboratorio2_fragmentos_tarea.Entidad.PersonajeVo;
import com.example.laboratorio2_fragmentos_tarea.R;

public class DetallePersonajeFragment extends Fragment {

    TextView textDescripcion;
    ImageView imagenDetalle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_detalle_personajes, container, false);

        textDescripcion= (TextView) vista.findViewById(R.id.descripcionId);
        imagenDetalle= (ImageView) vista.findViewById(R.id.imagenDetalleId);

        Bundle objetoPersonaje = getArguments();
        PersonajeVo Personaje = null;

        if (objetoPersonaje != null) {
            Personaje = (PersonajeVo) objetoPersonaje.getSerializable("objeto");
            imagenDetalle.setImageResource(Personaje.getImagenDetalle());
            textDescripcion.setText(Personaje.getDescripcion());
        }

        return vista;
    }


}
