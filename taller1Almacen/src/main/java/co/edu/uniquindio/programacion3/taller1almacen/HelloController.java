package co.edu.uniquindio.programacion3.taller1almacen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//librerias ratio button:
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.time.LocalDate;


public class HelloController {
    @FXML
    private Label welcomeText;

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
    private TextField diaNacimientoCliente;

    @FXML
    private TextField mesNacimientoCliente;

    @FXML
    private TextField yearNacimientoCliente;

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
        //Obtener datos de las clases hijas de cliente:
        String textoEmail ="";
        String textoFechaNacimiento ="";
        String textoNit = "";
        LocalDate fechaNacimiento;
        String textoDiaNacimiento ="";
        String textoMesNacimiento ="";
        String textoYearNacimiento ="";

        //Cliente cliente = null;

        if (clienteNatural.isSelected()) {
            textoEmail = emailCliente.getText();
            textoDiaNacimiento = diaNacimientoCliente.getText();
            textoMesNacimiento = mesNacimientoCliente.getText();
            textoYearNacimiento = yearNacimientoCliente.getText();
            fechaNacimiento = LocalDate.of(Integer.parseInt(textoYearNacimiento),
                    Integer.parseInt(textoMesNacimiento),
                    Integer.parseInt(textoDiaNacimiento));
            Cliente cliente = new ClienteNatural(textoNombre,textoApellido,textoId,textoDireccion,textoTelefono,
                    textoEmail,fechaNacimiento);

        }
        if (clienteJuridico.isSelected()){
            textoNit = nitCliente.getText();
            Cliente cliente = new ClienteJuridico(textoNombre,textoApellido,textoId,textoDireccion,textoTelefono,textoNit);
        }

        labelDatosPrueba.setText("bienvenido: "+textoNombre+"\n"+textoApellido+"\n"+textoId+"\n"+
                textoDireccion+"\n"+textoTelefono+"\n"+textoEmail+"\n"+textoFechaNacimiento+"\n"+textoNit);


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
        diaNacimientoCliente.setDisable(true);
        mesNacimientoCliente.setDisable(true);
        yearNacimientoCliente.setDisable(true);
        nitCliente.setDisable(true);

        // Se escucha los cambios de los botones, con una funcion lambda se habilita
        // o deshabilita los campos de texto segun el caso
        tipoCliente.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue == clienteNatural) {
                    emailCliente.setDisable(false);
                    diaNacimientoCliente.setDisable(false);
                    mesNacimientoCliente.setDisable(false);
                    yearNacimientoCliente.setDisable(false);
                    nitCliente.setDisable(true);
                    nitCliente.clear();
                } else if (newValue == clienteJuridico) {
                    emailCliente.setDisable(true);
                    emailCliente.clear();
                    diaNacimientoCliente.setDisable(true);
                    diaNacimientoCliente.clear();
                    mesNacimientoCliente.setDisable(true);
                    mesNacimientoCliente.clear();
                    yearNacimientoCliente.setDisable(true);
                    yearNacimientoCliente.clear();
                    nitCliente.setDisable(false);
                }
            } else {
                emailCliente.setDisable(true);
                emailCliente.clear();
                diaNacimientoCliente.setDisable(true);
                diaNacimientoCliente.clear();
                mesNacimientoCliente.setDisable(true);
                mesNacimientoCliente.clear();
                yearNacimientoCliente.setDisable(true);
                yearNacimientoCliente.clear();
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
// Lógica para mostrar los datos de producto
public class HelloControler{
    @FXML
    private label welcomeText;

    @FXML
    private Label labeldatosProducto;

    //Captura los datos de producto

    @FXML
    private TextField codigoProducto;
    
    @FXML
    private TextField productoNombre;
    @FXML
    private TextField productoDescripcion;
    @FXML
    private TextField valorProducto;
    @FXML
    private TextField cantidadProducto;

    @FXML
    private RadioButton productoPerecedero;

    @FXML
    private RadioButton productoRefrigerado;

    @FXML
    private RadioButton productoEnvasado;

    private ToggleGroup tipoProducto;

    @FXML
    private TextField diaVencimiento;

    @FXML
    private TextField mesVencimiento;

    @FXML
    private TextField anoVencimiento;

    @FXML
    private TextField aprobacionCodigo;

    @FXML
    private TextField productoTemperatura;

    @FXML
    private TextField diaEnvasadoo;

    @FXML
    private TextField mesEnvasadoo;

    @FXML
    private TextField anoEnvasadoo;

    @FXML
    private RadioButton colombiaOrigen;

    @FXML
    private RadioButton chileOrigen;

    @FXML
    private RadioButton peruOrigen;

    @FXML
    private RadioButton ecuadorOrigen;

    @FXML
    private RadioButton argentinaOrigen;

    private ToggleGroup tipoOrigen;




}


