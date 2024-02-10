package co.edu.uniquindio.programacion3.taller1almacen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label labePrueba;
    @FXML
    private Label labelDatosPrueba;

    //Capturar los datos del cliente:
    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField apellidoCliente;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField direccionCliente;
    @FXML
    private TextField telefonoCliente;


    @FXML
    protected void hacerClick() {
        //obtener los datos del cliente
        String textoNombre = nombreCliente.getText();
        String textoApellido = apellidoCliente.getText();
        String textoId = idCliente.getText();
        String textoDireccion = direccionCliente.getText();
        String textoTelefono = telefonoCliente.getText();
        //String texto = Cliente.getText();
       // labelDatosPrueba.setText(textoNombre);
        labePrueba.setText(textoNombre);
        labelDatosPrueba.setText("bienvenido: "+textoNombre+"\n"+"");

    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}