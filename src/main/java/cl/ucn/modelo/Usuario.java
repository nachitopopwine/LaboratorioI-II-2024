package cl.ucn.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private int rut;
    private String nombre;
    @Column(name = "permiso")
    private boolean tienePermiso;
    @ManyToOne
    @JoinColumn(name = "recursos_multimedia_id")
    private RecursosMultimedia recursosMultimedia;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTienePermiso() {
        return tienePermiso;
    }

    public void setTienePermiso(boolean tienePermiso) {
        this.tienePermiso = tienePermiso;
    }

    public RecursosMultimedia getRecursosMultimedia() {
        return recursosMultimedia;
    }

    public void setRecursosMultimedia(RecursosMultimedia recursosMultimedia) {
        this.recursosMultimedia = recursosMultimedia;
    }
}