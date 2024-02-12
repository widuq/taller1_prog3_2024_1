package co.edu.uniquindio.programacion3.taller1almacen;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{
    private LocalDate fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombreProducto, String descripcion,
                              double valorUnitario, int cantidadExistencias,
                              LocalDate fechaVencimiento, TipoProducto tipoProducto) {
        super(codigo, nombreProducto, descripcion, valorUnitario, cantidadExistencias, tipoProducto);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}

