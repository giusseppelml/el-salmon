package owl.app.elsalmon.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.blurry.Blurry;
import owl.app.elsalmon.R;
import owl.app.elsalmon.adapters.MenuAdapter;
import owl.app.elsalmon.email.Config;
import owl.app.elsalmon.models.Menu;

public class MenuPrincipalFragment extends Fragment {

    private GridView gridView;
    private MenuAdapter menuAdapter;

    private List<Menu> menu;

    private Fragment nuevoFragmento;
    private String titulo;

    private Button button;

    public MenuPrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_principal, container, false);

        gridView = (GridView)view.findViewById(R.id.gridView);
        button = (Button)view.findViewById(R.id.btnGaleria);
        this.menu = menus();


        //evento para dar click en cada objeto del list view
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        nuevoFragmento = new TabsFragment();
                        titulo = getString(R.string.quienesSomos);
                        fragmentsOn(nuevoFragmento, titulo);
                        break;
                    case 1:
                        nuevoFragmento = new ServiciosBeneficiosFragment();
                        titulo = getString(R.string.servyBeneficios);
                        fragmentsOn(nuevoFragmento, titulo);
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        nuevoFragmento = new EncuentranosFragment();
                        titulo = getString(R.string.encuentranosSalmon);
                        fragmentsOn(nuevoFragmento, titulo);
                        break;
                    case 4:
                        nuevoFragmento = new ValoresFragment();
                        titulo = getString(R.string.nuestrosValores);
                        fragmentsOn(nuevoFragmento, titulo);
                        break;
                    case 5:
                        nuevoFragmento = new ProductosFragment();
                        titulo = getString(R.string.productos);
                        fragmentsOn(nuevoFragmento, titulo);
                        break;
                }
            }
        });

        //enlazamos con nuestro adaptador personalizado
        menuAdapter = new MenuAdapter(getActivity(), R.layout.card_view_menu, menu);
        gridView.setAdapter(menuAdapter);
        registerForContextMenu(gridView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                GaleriaFragment galeriaFragment = new GaleriaFragment();
                galeriaFragment.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.transparente);
                galeriaFragment.show(manager,"");
            }
        });

        return view;
    }

    private List<Menu> menus(){
        List<Menu> menu = new ArrayList<Menu>() {{
            add(new Menu(getString(R.string.quienesSomos), R.mipmap.ic_quienes_somos));
            add(new Menu(getString(R.string.servyBeneficios), R.mipmap.ic_servicios));
            add(new Menu(getString(R.string.contactanosSalmon), R.mipmap.ic_contactanos));
            add(new Menu(getString(R.string.encuentranosSalmon), R.mipmap.ic_encuentranos));
            add(new Menu(getString(R.string.nuestrosValores), R.mipmap.ic_valores));
            add(new Menu(getString(R.string.productos), R.mipmap.ic_productp));
        }};
        return menu;
    }

    private void fragmentsOn(Fragment fragment, String titles) {
        // Crea el nuevo fragmento y la transacción.
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titles);
        transaction.addToBackStack(null);

        // Commit a la transacción
        transaction.commit();
        Config.Boolean = false;
    }
}
