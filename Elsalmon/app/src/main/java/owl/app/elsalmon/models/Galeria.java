package owl.app.elsalmon.models;

import android.content.Context;

import java.util.ArrayList;

import owl.app.elsalmon.R;

/**
 * Created by Giusseppe on 30/12/2017.
 */

public class Galeria {
    private int imagen;
    private String titulo;

    public Galeria(){}

    public Galeria(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Galeria>ListaMenu(){

        Galeria galeria;
        ArrayList<Galeria> lista = new ArrayList<Galeria>();

        Integer[]idImagenes = new Integer[]{R.drawable.salmon1,R.drawable.salmon2,R.drawable.salmon3
                ,R.drawable.salmon4,R.drawable.salmon5,R.drawable.salmon6,R.drawable.salmon7
                ,R.drawable.salmon8,R.drawable.salmon9,R.drawable.salmon10,R.drawable.salmon11
                ,R.drawable.salmon12,R.drawable.salmon13,R.drawable.salmon14,R.drawable.salmon15
                ,R.drawable.salmon16,R.drawable.salmon17,R.drawable.salmon18};
        String[]titulos = new String[]{"SALMON","SALMON","SALMON","SALMON","SALMON","SALMON",
                "SALMON","SALMON","SALMON","SALMON","SALMON","SALMON","SALMON","SALMON","SALMON",
                "SALMON","SALMON","SALMON"};

        for(int i=0; i<idImagenes.length; i++){
            galeria = new Galeria(idImagenes[i], titulos[i]);

            lista.add(galeria);
        }

        return lista;
    }
}
