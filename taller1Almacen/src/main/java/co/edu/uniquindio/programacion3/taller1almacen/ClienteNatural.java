package co.edu.uniquindio.programacion3.taller1almacen;

import java.time.LocalDate;

public class ClienteNatural extends Cliente{
    private String email;
    private LocalDate fechaNacimiento;

    public ClienteNatural(String nombre, String apellido, String identificacion, String direccion,
                          String telefono, String email, LocalDate fechaNacimiento, TipoCliente tipoCliente) {
        super(nombre, apellido, identificacion, direccion, telefono, tipoCliente);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {

        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;
    }
}
