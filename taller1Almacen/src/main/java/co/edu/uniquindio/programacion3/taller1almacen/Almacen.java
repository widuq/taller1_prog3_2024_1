package co.edu.uniquindio.programacion3.taller1almacen;

import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class Almacen {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;

    //Creacion de un almacen con dos ArrayList vacios
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

    // Método para agregar un cliente a la lista
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    //Método para agrgegra un producto:
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

        //Guia para acceder a los datos de los arraylist

    //Por ahora se imprime en consola y muesra los datos
    public void mostrarClientes() {
        System.out.println("La cantidad de clientes es: " + listaClientes.size());
        for (Cliente cliente : listaClientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("ID: " + cliente.getIdentificacion());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Tipo de Cliente: "+cliente.getTipoCliente());
            //Mostrar los datos cuando es un cliente Natural:
            if(cliente instanceof ClienteNatural){
                System.out.println("Email:"+((ClienteNatural) cliente).getEmail());
                System.out.println("Fecha Nacimiento: "+((ClienteNatural) cliente).getFechaNacimiento());
            }
            // Si ClienteJuridico es una subclase de Cliente, puedes comprobar y mostrar el NIT
            if (cliente instanceof ClienteJuridico) {
                System.out.println("NIT: " + ((ClienteJuridico) cliente).getNit());
            }
            System.out.println("----------------------------------------");
        }
    }

    public void mostrarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("Valor Unitario: " + producto.getValorUnitario() );
            System.out.println("Cantidad: " + producto.getCantidadExistencias());
            System.out.println("Tipo de Producto: "+producto.getTipoProducto());
            /// hace falta agregar el TIPO DE PRODUCTO //////////////

            //Mostrar los datos cuando es un perecedero:
            if(producto instanceof ProductoPerecedero){
                System.out.println("Fecha vencimiento:"+ ((ProductoPerecedero) producto).getFechaVencimiento());

            }
            // Si es un producto Refrigerado
            if (producto instanceof ProductoRefrigerado) {
                System.out.println("Codigo Aprobacion: " + ((ProductoRefrigerado) producto).getCodAprovacion());
                System.out.println("Temperatura Recomendada: " + ((ProductoRefrigerado) producto).getTempRecomendada());
            }
            if (producto instanceof ProductoEnvasado){
                System.out.println("Fecha envasado: "+((ProductoEnvasado) producto).getFechaEnvasado());
                System.out.println("Peso envase: "+ ((ProductoEnvasado) producto).getPesoEnvase());
                System.out.println("Pais de Orígen: " + ((ProductoEnvasado) producto).getPaisOrigen());
            }
            System.out.println("----------------------------------------");
        }
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
