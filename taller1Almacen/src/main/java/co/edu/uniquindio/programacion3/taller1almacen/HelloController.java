package co.edu.uniquindio.programacion3.taller1almacen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label labePrueba;
    private Label labelDatosPrueba;
    @FXML
    private TextField nombreCliente;


    @FXML
    protected void hacerClick() {
        labePrueba.setText("Funciona!");
        String textoNombre = nombreCliente.getText();
       // labelDatosPrueba.setText(textoNombre);
        labePrueba.setText(textoNombre);

    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}