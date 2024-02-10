package co.edu.uniquindio.programacion3.taller1almacen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//librerias ratio button:
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


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

    ////////////////// pruebas ratio buttons ///////////////
    @FXML
    private TextField emailCliente;

    @FXML
    private TextField nacimientoCliente;

    @FXML
    private TextField nitCliente;

    @FXML
    private RadioButton clienteNatural;

    @FXML
    private RadioButton clienteJuridico;

    private ToggleGroup tipoCliente;



    ///////////// controlador boton Registrar Cliente /////////////////
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
        String textoEmail ="";
        String textoFechaNacimiento ="";
        String textoNit = "";

        if (clienteNatural.isSelected()) {
            textoEmail = emailCliente.getText();
            textoFechaNacimiento = nacimientoCliente.getText();

        }
        if (clienteJuridico.isSelected()){
            textoNit = nitCliente.getText();
        }
        labePrueba.setText(textoNombre);
        labelDatosPrueba.setText("bienvenido: "+textoNombre+"\n"+textoApellido+"\n"+textoId+"\n"+
                textoDireccion+"\n"+textoTelefono+"\n"+textoEmail+"\n"+textoFechaNacimiento+"\n"+textoNit);

        Cliente cliente = new ClienteJuridico(textoNombre,textoApellido,textoId,textoDireccion,textoTelefono,textoNit);
    }


    ////////////// controlador ratio buttons //////////////

    @FXML
    protected void initialize() {
        //Se crea un grupo de dos botones para solo activar un ratiobutton a la vez
        tipoCliente = new ToggleGroup();
        clienteNatural.setToggleGroup(tipoCliente);
        clienteJuridico.setToggleGroup(tipoCliente);

        //Campos por defecto deshabilitados
        emailCliente.setDisable(true);
        nacimientoCliente.setDisable(true);
        nitCliente.setDisable(true);

        // Se escucha los cambios de los botones, con una funcion lambda se habilita
        // o deshabilita los campos de texto segun el caso
        tipoCliente.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue == clienteNatural) {
                    emailCliente.setDisable(false);
                    nacimientoCliente.setDisable(false);
                    nitCliente.setDisable(true);
                    nitCliente.clear();
                } else if (newValue == clienteJuridico) {
                    emailCliente.setDisable(true);
                    emailCliente.clear();
                    nacimientoCliente.setDisable(true);
                    nacimientoCliente.clear();
                    nitCliente.setDisable(false);
                }
            } else {
                emailCliente.setDisable(true);
                emailCliente.clear();
                nacimientoCliente.setDisable(true);
                nacimientoCliente.clear();
                nitCliente.setDisable(true);
                nitCliente.clear();
            }
        });
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}