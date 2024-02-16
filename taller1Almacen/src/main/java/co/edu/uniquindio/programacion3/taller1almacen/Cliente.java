package co.edu.uniquindio.programacion3.taller1almacen;

public class Cliente {
    //Se declaran lso atributos de la clase cliente

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private TipoCliente tipoCliente;

    //constructor
    public Cliente(String nombre, String apellido, String identificacion, String direccion,
                   String telefono, TipoCliente tipoCliente) {//Se crea el constructor
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }

    //Se crean los getters y setters

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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
