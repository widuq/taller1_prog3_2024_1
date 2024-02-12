package co.edu.uniquindio.programacion3.taller1almacen;

public class ProductoRefrigerado extends Producto {
    private String codAprovacion;
    private double tempRecomendada;

    public ProductoRefrigerado(String codigo, String nombreProducto, String descripcion,
                               double valorUnitario, int cantidadExistencias, String codAprovacion,
                               double tempRecomendada, TipoProducto tipoProducto) {
        super(codigo, nombreProducto, descripcion, valorUnitario, cantidadExistencias, tipoProducto);
        this.codAprovacion = codAprovacion;
        this.tempRecomendada = tempRecomendada;
    }

    public String getCodAprovacion() {
        return codAprovacion;
    }

    public void setCodAprovacion(String codAprovacion) {
        this.codAprovacion = codAprovacion;
    }

    public double getTempRecomendada() {
        return tempRecomendada;
    }

    public void setTempRecomendada(double tempRecomendada) {
        this.tempRecomendada = tempRecomendada;
    }
}
