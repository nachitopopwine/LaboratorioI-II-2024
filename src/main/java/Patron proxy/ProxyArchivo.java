package cl.ucn.main;

import cl.ucn.modelo.Usuario;

public class ProxyArchivo implements Archivo {
    private ArchivoProtegido archivoProtegido;
    private Usuario usuario;

    public ProxyArchivo(String nombre, Usuario usuario) {
        this.archivoProtegido = new ArchivoProtegido(nombre);
        this.usuario = usuario;
    }

    @Override
    public void abrirArchivo() {
        if (usuario.isTienePermiso()) {
            archivoProtegido.abrirArchivo();
        } else {
            System.out.println("Acceso denegado. El usuario no tiene permisos.");
        }
    }
}