package owl.app.elsalmon.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import jp.wasabeef.blurry.Blurry;
import owl.app.elsalmon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EncuentranosFragment extends Fragment {

    private static final String ori = "Calle 2 2, Agrícola Librado Rivera, 94380 Orizaba, Ver., México";
    private static final String men = "8 de Marzo & Av. Miguel Hidalgo, Centro, 94740 Cd Mendoza, Ver., México";
    private static final String ver1 = "Av. Miguel Hidalgo 345, Centro, 94740 Cd Mendoza, Ver., México";
    private static final String ver2 = "Diego de Ordaz & Av Cristóbal Colón, poligono 1, Reforma, 91919 Veracruz, Ver., México";

    private ImageView veracruz1, veracruz2, orizaba, mendoza;

    public EncuentranosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_encuentranos, container, false);

        view.post(new Runnable() {
            @Override
            public void run() {
                long startMs = System.currentTimeMillis();
                Blurry.with(getContext())
                        .radius(25)
                        .sampling(2)
                        .async()
                        .animate(500)
                        .capture(getView().findViewById(R.id.imageEncuentra))
                        .into((ImageView)getView().findViewById(R.id.imageEncuentra));
            }
        });

        veracruz1 = (ImageView)view.findViewById(R.id.ubiveracruz1);
        veracruz2 = (ImageView)view.findViewById(R.id.ubiveracruz2);
        mendoza = (ImageView)view.findViewById(R.id.ubimendoza);
        orizaba = (ImageView)view.findViewById(R.id.ubiorizaba);

        veracruz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubicacion(ver1);
            }
        });

        veracruz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubicacion(ver2);
            }
        });

        mendoza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubicacion(men);
            }
        });

        orizaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubicacion(ori);
            }
        });

        return view;
    }

    private void ubicacion(String local){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+""+"&daddr="+local)); //o la direccion/consulta que quiera "http://maps.google.com/maps?q="+ myLatitude  +"," + myLongitude +"("+ labLocation + ")&iwloc=A&hl=es"
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
}