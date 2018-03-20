package owl.app.elsalmon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import owl.app.elsalmon.R;
import owl.app.elsalmon.models.Galeria;

/**
 * Created by Giusseppe on 30/12/2017.
 */

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.MyViewHolder>{
    private ArrayList<Galeria> listaGaleria;
    private OnClickRecycler listener;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_galeria, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Galeria galeria = listaGaleria.get(position);

        holder.bind(galeria,listener);
    }

    @Override
    public int getItemCount() {
        return listaGaleria.size();
    }

    public interface OnClickRecycler {
        void OnClickItemRecycler(Galeria galeria);
    }

    public GaleriaAdapter(ArrayList<Galeria> listaGaleria, OnClickRecycler listener) {
        this.listaGaleria = listaGaleria;
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.cardImage);
        }

        public void bind(final Galeria galeria, final OnClickRecycler listener){
            Glide.with(imageView.getContext()).load(galeria.getImagen()).into(imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClickItemRecycler(galeria);
                }
            });
        }
    }
}
