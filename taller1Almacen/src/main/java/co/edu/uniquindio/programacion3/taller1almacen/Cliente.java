package co.edu.uniquindio.programacion3.taller1almacen;

public class Cliente {

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;


    public Cliente(java.lang.String nombre, java.lang.String apellido, java.lang.String identificacion, java.lang.String direccion, java.lang.String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
