package owl.app.elsalmon.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import owl.app.elsalmon.R;
import owl.app.elsalmon.adapters.ProductoAdapter;
import owl.app.elsalmon.models.Menu;
import owl.app.elsalmon.models.Producto;

public class ProductosFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Producto> productos;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewProductos);
        this.productos = listProductos();

        // crear el adaptador y configurarlo en la vista de lista
        mLayoutManager = new LinearLayoutManager(getActivity());

        mAdapter = new ProductoAdapter(productos, R.layout.card_view_producto);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<Producto> listProductos(){
        List<Producto> producto = new ArrayList<Producto>() {{

            add(new Producto(getString(R.string.filetes), R.drawable.filetes));
            add(new Producto(getString(R.string.rubias), R.drawable.rubias));
            add(new Producto(getString(R.string.jaiba), R.drawable.jaibas));
            add(new Producto(getString(R.string.cangrejo), R.drawable.cangrejo));
            add(new Producto(getString(R.string.ostiones), R.drawable.ostiones));
            add(new Producto(getString(R.string.pulpo), R.drawable.pulpo));
            add(new Producto(getString(R.string.salmon), R.drawable.salmones));
            add(new Producto(getString(R.string.surimi), R.drawable.surimi));
            add(new Producto(getString(R.string.tintaCalamar), R.drawable.calamar));
            add(new Producto(getString(R.string.almejas), R.drawable.almejas));
            add(new Producto(getString(R.string.atun), R.drawable.atun));
            add(new Producto(getString(R.string.bacalao), R.drawable.bacalao));
            add(new Producto(getString(R.string.calamares), R.drawable.calamares));
            add(new Producto(getString(R.string.camarones), R.drawable.camarones));
        }};
        return producto;
    }

}
