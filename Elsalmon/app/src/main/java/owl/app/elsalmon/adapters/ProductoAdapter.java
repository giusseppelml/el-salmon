package owl.app.elsalmon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import owl.app.elsalmon.R;
import owl.app.elsalmon.models.Producto;

/**
 * Created by giusseppe on 18/01/2018.
 */

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    private List<Producto> producto;
    private int layout;

    private Context context;

    public ProductoAdapter(List<Producto> producto, int layout)
    {
        this.producto = producto;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(producto.get(position));
    }

    @Override
    public int getItemCount() {
        return producto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView TextViewTitulo;
        public ImageView ImageViewPortada;

        public ViewHolder(View v)
        {
            super(v);
            TextViewTitulo = (TextView)itemView.findViewById(R.id.cardViewProductoTitulo);
            ImageViewPortada = (ImageView)itemView.findViewById(R.id.cardViewProductoImagen);
        }

        public void bind(final Producto producto) {
            //procesamos los datos a renderizar

            TextViewTitulo.setText(producto.getTitulo());
            Picasso.with(context).load(producto.getImagen()).fit().into(ImageViewPortada);

        }
    }


}