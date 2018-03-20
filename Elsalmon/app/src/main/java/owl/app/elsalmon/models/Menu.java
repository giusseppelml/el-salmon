package owl.app.elsalmon.models;

/**
 * Created by Giusseppe on 23/12/2017.
 */

public class Menu {
    private String titulo;
    private int icono;

    public Menu(){}

    public Menu(String titulo, int icono) {
        this.titulo = titulo;
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
