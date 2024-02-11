package co.edu.uniquindio.programacion3.taller1almacen;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Cliente> listaClientes;
/*
    public Almacen(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
*/
    public Almacen() {
        this.listaClientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // Método para agregar un cliente a la lista
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("ID: " + cliente.getIdentificacion());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("Teléfono: " + cliente.getTelefono());
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
}
