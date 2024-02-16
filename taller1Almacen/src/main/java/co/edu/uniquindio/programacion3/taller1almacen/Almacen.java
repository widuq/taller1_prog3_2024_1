package co.edu.uniquindio.programacion3.taller1almacen;

import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class Almacen {
    //Se declaran las variables de tipo Arraylist que almacenara objetos de la clase cliente y lista productos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;

    //Creacion de un almacen con dos ArrayList vacios
    //Se define un constructor que inicializa las dos listas como ArrayList
    // vacíos cuando se crea una instancia de la clase Almacen.
    public Almacen() {
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    //métodos getters y setters
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // Método para agregar un cliente a  la lista
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    //Método para agrgegra un producto:
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
    // Método para eliminar un cliente de la lista
    public void eliminarCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    // Método para eliminar un producto de la lista
    public void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
    }
}
