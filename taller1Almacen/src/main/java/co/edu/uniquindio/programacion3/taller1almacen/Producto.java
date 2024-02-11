package co.edu.uniquindio.programacion3.taller1almacen;

public class Producto {
    private String codigo;
    private String nombreProducto;
    private String descripcion;
    private double valorUnitario;
    private int cantidadExistencias;

    public Producto(String codigo, String nombreProducto, String descripcion, double valorUnitario, int cantidadExistencias) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.cantidadExistencias = cantidadExistencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(int cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }
}
