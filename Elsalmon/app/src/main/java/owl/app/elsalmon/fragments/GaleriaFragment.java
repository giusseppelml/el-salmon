package owl.app.elsalmon.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jp.wasabeef.blurry.Blurry;
import owl.app.elsalmon.R;
import owl.app.elsalmon.adapters.GaleriaAdapter;
import owl.app.elsalmon.models.Galeria;

public class GaleriaFragment extends DialogFragment {

    private TextView titulo;
    private ImageView imagen;
    private RecyclerView recyclerView;
    private View view;

    ArrayList<Galeria> listaGaleria;
    GaleriaAdapter adapter;

    public GaleriaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_galeria, container, false);

        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagenGaleria);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewGaleria);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        listaGaleria = new Galeria().ListaMenu();

        adapter = new GaleriaAdapter(listaGaleria, new GaleriaAdapter.OnClickRecycler() {
            @Override
            public void OnClickItemRecycler(Galeria galeria) {
                Glide.with(getContext()).load(galeria.getImagen()).into(imagen);
                titulo.setText(galeria.getTitulo());
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

}
