package co.edu.uniquindio.programacion3.taller1almacen;

public class Cliente {

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;

// prueba githab 2
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

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
