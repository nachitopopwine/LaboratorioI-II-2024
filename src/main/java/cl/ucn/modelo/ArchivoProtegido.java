package cl.ucn.main;

public class ArchivoProtegido implements Archivo {
    private String nombre;

    public ArchivoProtegido(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void abrirArchivo() {
        System.out.println("Abriendo el archivo protegido: " + nombre);
    }
}