package co.edu.uniquindio.programacion3.taller1almacen;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto{
    private LocalDate fechaEnvasado;
    private double pesoEnvase;
    private PaisOrigen paisOrigen;

    public ProductoEnvasado(String codigo, String nombreProducto, String descripcion, double valorUnitario,
                            int cantidadExistencias, LocalDate fechaEnvasado, double pesoEnvase,
                            PaisOrigen paisOrigen, TipoProducto tipoProducto) {
        super(codigo, nombreProducto, descripcion, valorUnitario, cantidadExistencias,tipoProducto);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public PaisOrigen getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}

