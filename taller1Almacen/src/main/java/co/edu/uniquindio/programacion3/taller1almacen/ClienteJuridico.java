package co.edu.uniquindio.programacion3.taller1almacen;

public class ClienteJuridico extends Cliente{
    private String nit;

    public ClienteJuridico(String nombre, String apellido, String identificacion,
                           String direccion, String telefono, String nit, TipoCliente tipoCliente) {
        super(nombre, apellido, identificacion, direccion, telefono, tipoCliente);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
