package owl.app.elsalmon.models;

/**
 * Created by giusseppe on 18/01/2018.
 */

public class Producto {
    private String titulo;
    private int imagen;

    public Producto(String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
