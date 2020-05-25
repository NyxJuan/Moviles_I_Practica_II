package com.example.laboratorio2_fragmentos_tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.laboratorio2_fragmentos_tarea.Entidad.PersonajeVo;
import com.example.laboratorio2_fragmentos_tarea.Fragmentos.DetallePersonajeFragment;
import com.example.laboratorio2_fragmentos_tarea.Fragmentos.ListaPersonajesFragment;
import com.example.laboratorio2_fragmentos_tarea.Interfaces.IComunicaFragments;


public class MainActivity extends AppCompatActivity implements IComunicaFragments {


    ListaPersonajesFragment listaFragment;
    DetallePersonajeFragment detalleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaFragment = new ListaPersonajesFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,listaFragment).commit();
    }

    @Override
    public void enviarPersonaje(PersonajeVo personaje) {
        detalleFragment = new DetallePersonajeFragment();
        Bundle bundleEnvio = new Bundle();
        bundleEnvio.putSerializable("objeto",personaje);
        detalleFragment.setArguments(bundleEnvio);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,detalleFragment).addToBackStack(null).commit();

    }
}
