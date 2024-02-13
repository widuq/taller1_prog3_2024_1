package co.edu.uniquindio.programacion3.taller1almacen;

//paquetes necesarios para trabajar:
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;


//librerias ratio button:

import java.time.LocalDate;


public class HelloController {

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

    //////////// Los datos del producto ////////////////
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
    private TextField diaEnvasado;
    @FXML
    private TextField mesEnvasado;
    @FXML
    private TextField anoEnvasado;
    @FXML
    private TextField productoPeso;

    @FXML
    private RadioButton colombiaOrigen;
    @FXML
    private RadioButton chileOrigen;
    @FXML
    private RadioButton peruOrigen;
    @FXML
    private RadioButton argentinaOrigen;
    @FXML
    private RadioButton ecuadorOrigen;
    @FXML
    private ToggleGroup tipoProducto;

    @FXML
    private ToggleGroup tipoPais;

    private Almacen almacen = new Almacen();


    //////////// pruebas tabla personas ///////////
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn nombreClienteTabla;
    @FXML private TableColumn apellidoClienteTabla;
    @FXML private TableColumn idClienteTabla;
    @FXML private TableColumn direccionClienteTabla;
    @FXML private TableColumn telefonoClienteTabla;
    @FXML private TableColumn tipoClienteTabla;
    @FXML private TableColumn emailClienteTabla;
    @FXML private TableColumn fechaNacimientoClienteTabla;
    @FXML private TableColumn nitClienteTabla;
    ObservableList<Cliente> clientes;



    ///////////// controlador boton Registrar Cliente /////////////////
    @FXML
    protected void hacerClick() {
        //obtener los datos del cliente ingresados
        String textoNombre = nombreCliente.getText();
        String textoApellido = apellidoCliente.getText();
        String textoId = idCliente.getText();
        String textoDireccion = direccionCliente.getText();
        String textoTelefono = telefonoCliente.getText();
        //Obtener datos de las clases hijas de cliente:
        //inicializados con un string vacio
        String textoEmail = "";
        String textoFechaNacimiento = "";
        String textoNit = "";
        LocalDate fechaNacimiento;
        String textoDiaNacimiento = "";
        String textoMesNacimiento = "";
        String textoYearNacimiento = "";

        Cliente cliente = null; //El tipo de cliente se asigna con los rtio buttons

        //Cuando se elige un cliente Natural o Juridico, se obtienen datos especificos
        // y se construye un cliente con los datos obtenidos
        if (clienteNatural.isSelected()) {
            textoEmail = emailCliente.getText();
            textoDiaNacimiento = diaNacimientoCliente.getText();
            textoMesNacimiento = mesNacimientoCliente.getText();
            textoYearNacimiento = yearNacimientoCliente.getText();
            //Se transforma los campos String a datos tipo entero
            // Para convertirlos a una fecha de nacimiento tipo Local Date
            fechaNacimiento = LocalDate.of(Integer.parseInt(textoYearNacimiento),
                    Integer.parseInt(textoMesNacimiento),
                    Integer.parseInt(textoDiaNacimiento));
            cliente = new ClienteNatural(textoNombre, textoApellido, textoId, textoDireccion, textoTelefono,
                    textoEmail, fechaNacimiento,TipoCliente.NATURAL);

        }
        if (clienteJuridico.isSelected()) {
            textoNit = nitCliente.getText();
            cliente = new ClienteJuridico(textoNombre, textoApellido, textoId,
                    textoDireccion, textoTelefono, textoNit, TipoCliente.JURIDICO);

        }

        //Ahora ya tenemos un cliente, que puede ser Natural o Juridico
        //Se agrega ese cliente a la lista de clientes del almacen
        almacen.agregarCliente(cliente);

        /////// pruebas //////////
        //cada vez que se presiona el boton, se muestra la lista de clientes agregados
        almacen.mostrarClientes();

        // Se actualiza la lista de clientes en la tabla
        clientes = FXCollections.observableArrayList(almacen.getListaClientes());
        tablaClientes.setItems(clientes);
        // Configuración de las celdas de la tabla
        nombreClienteTabla.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        idClienteTabla.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        direccionClienteTabla.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        telefonoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));

        //Para los atributos de las clases hijas:
        TipoCliente tipoCliente = cliente.getTipoCliente();
        if(tipoCliente == TipoCliente.NATURAL){
            emailClienteTabla.setCellValueFactory(new PropertyValueFactory<>("email"));
            fechaNacimientoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
            nitClienteTabla.setCellValueFactory(null);

        }else{
        //if(tipoCliente == TipoCliente.JURIDICO){
            emailClienteTabla.setCellValueFactory(null);
            fechaNacimientoClienteTabla.setCellValueFactory(null);
            nitClienteTabla.setCellValueFactory(new PropertyValueFactory<>("nit"));
        }


    }


    ////////////// controlador ratio buttons //////////////

    // Cuando se elige entre cliente Natural o cliente Juridico
    // los campos de datos que se deben completar se activan


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

        colombiaOrigen.setDisable(true);
        chileOrigen.setDisable(true);
        peruOrigen.setDisable(true);
        argentinaOrigen.setDisable(true);
        ecuadorOrigen.setDisable(true);

        tipoProducto = new ToggleGroup();
        productoPerecedero.setToggleGroup(tipoProducto);
        productoRefrigerado.setToggleGroup(tipoProducto);
        productoEnvasado.setToggleGroup(tipoProducto);

        tipoPais = new ToggleGroup();
        colombiaOrigen.setToggleGroup(tipoPais);
        argentinaOrigen.setToggleGroup(tipoPais);
        chileOrigen.setToggleGroup(tipoPais);
        peruOrigen.setToggleGroup(tipoPais);
        ecuadorOrigen.setToggleGroup(tipoPais);


        diaVencimiento.setDisable(true);
        mesVencimiento.setDisable(true);
        anoVencimiento.setDisable(true);
        aprobacionCodigo.setDisable(true);
        productoTemperatura.setDisable(true);
        diaEnvasado.setDisable(true);
        mesEnvasado.setDisable(true);
        anoEnvasado.setDisable(true);
        productoPeso.setDisable(true);

        // Se escucha los cambios de los botones, con una funcion lambda se habilita
        // o deshabilita los campos de texto segun el caso
        tipoCliente.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue == clienteNatural) {
                    //cuando selecciona el ratiobutton de clienteNatural
                    // se habilitan los siguientes campos
                    emailCliente.setDisable(false);
                    diaNacimientoCliente.setDisable(false);
                    mesNacimientoCliente.setDisable(false);
                    yearNacimientoCliente.setDisable(false);
                    //Pero desabilita el campo nit y borra su contenido
                    nitCliente.setDisable(true);
                    nitCliente.clear();
                } else if (newValue == clienteJuridico) {
                    //cuando selecciona el ratiobutton de clienteJuridico
                    // se desactivan y se borran los siguientes campos:
                    emailCliente.setDisable(true);
                    emailCliente.clear();
                    diaNacimientoCliente.setDisable(true);
                    diaNacimientoCliente.clear();
                    mesNacimientoCliente.setDisable(true);
                    mesNacimientoCliente.clear();
                    yearNacimientoCliente.setDisable(true);
                    yearNacimientoCliente.clear();
                    // se activa el campo para nit
                    nitCliente.setDisable(false);
                }
            }
        });

        // Lógica adicional para manejar la selección de los radio buttons de productos


        tipoProducto.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue == productoPerecedero) {
                    diaVencimiento.setDisable(false);
                    mesVencimiento.setDisable(false);
                    anoVencimiento.setDisable(false);
                    aprobacionCodigo.setDisable(true);
                    productoTemperatura.setDisable(true);
                    diaEnvasado.setDisable(true);
                    mesEnvasado.setDisable(true);
                    anoEnvasado.setDisable(true);
                    productoPeso.setDisable(true);

                    colombiaOrigen.setDisable(true);
                    chileOrigen.setDisable(true);
                    peruOrigen.setDisable(true);
                    argentinaOrigen.setDisable(true);
                    ecuadorOrigen.setDisable(true);

                } else if (newValue == productoRefrigerado) {
                    diaVencimiento.setDisable(true);
                    mesVencimiento.setDisable(true);
                    anoVencimiento.setDisable(true);
                    aprobacionCodigo.setDisable(false);
                    productoTemperatura.setDisable(false);
                    diaEnvasado.setDisable(true);
                    mesEnvasado.setDisable(true);
                    anoEnvasado.setDisable(true);
                    productoPeso.setDisable(true);

                    colombiaOrigen.setDisable(true);
                    chileOrigen.setDisable(true);
                    peruOrigen.setDisable(true);
                    argentinaOrigen.setDisable(true);
                    ecuadorOrigen.setDisable(true);

                } else if (newValue == productoEnvasado) {
                    diaVencimiento.setDisable(true);
                    mesVencimiento.setDisable(true);
                    anoVencimiento.setDisable(true);
                    aprobacionCodigo.setDisable(true);
                    productoTemperatura.setDisable(true);
                    diaEnvasado.setDisable(false);
                    mesEnvasado.setDisable(false);
                    anoEnvasado.setDisable(false);
                    productoPeso.setDisable(false);

                    colombiaOrigen.setDisable(false);
                    chileOrigen.setDisable(false);
                    peruOrigen.setDisable(false);
                    argentinaOrigen.setDisable(false);
                    ecuadorOrigen.setDisable(false);
                }
            }
        });

        ///Escuchar seleccionar tabla : Para seleccionar un cliente especifico
        tablaClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Obtener los datos del cliente seleccionado
                String nombre = newSelection.getNombre();
                String apellido = newSelection.getApellido();
                String id = newSelection.getIdentificacion();
                String direccion = newSelection.getDireccion();
                String telefono = newSelection.getTelefono();

                // Establecer los datos en los campos de texto
                nombreCliente.setText(nombre);
                apellidoCliente.setText(apellido);
                idCliente.setText(id);
                direccionCliente.setText(direccion);
                telefonoCliente.setText(telefono);

                // Verificar el tipo de cliente y establecer los datos adicionales si es necesario
                TipoCliente tipo = newSelection.getTipoCliente();
                if (tipo == TipoCliente.NATURAL) {
                    // Cliente natural
                    ClienteNatural clienteNatural = (ClienteNatural) newSelection;
                    String email = clienteNatural.getEmail();
                    LocalDate fechaNacimiento = clienteNatural.getFechaNacimiento(); // Convertir a String según sea necesario
                    emailCliente.setText(email);
                    diaNacimientoCliente.setText(String.valueOf(fechaNacimiento.getDayOfMonth()));
                    mesNacimientoCliente.setText(String.valueOf(fechaNacimiento.getMonthValue()));
                    yearNacimientoCliente.setText(String.valueOf(fechaNacimiento.getYear()));
                } else if (tipo == TipoCliente.JURIDICO) {
                    // Cliente jurídico
                    ClienteJuridico clienteJuridico = (ClienteJuridico) newSelection;
                    String nit = clienteJuridico.getNit();
                    nitCliente.setText(nit);
                }
            }
        });

    }

    ////////////////////// controlador ventana productos ///////////////////////

    //por completar

    @FXML
    protected void hacerClickBtnAgregarProducto() {
        //obtener los datos del producto ingresados
        String textoCodigoProd = codigoProducto.getText();
        String textoNombreProd = productoNombre.getText();
        String textoDescripcionProd = productoDescripcion.getText();
        String textoValorProdTxt = valorProducto.getText();
        Double valorProductoDouble = Double.parseDouble(textoValorProdTxt);
        String textoCantidadProdTxt = cantidadProducto.getText();
        Integer cantidadProdInt = Integer.parseInt(textoCantidadProdTxt);
        //String textoTelefono = telefonoCliente.getText();

        //Obtener datos de las clases hijas de producto:
        //inicializados con un string vacio
        String textoDiaVencimiento = "";
        String textoMesVencimiento = "";
        String textoAnoVencimiento = "";
        String textoCodAprobacion = "";
        Double tempProducto;
        String textoDiaEnvasado = "";
        String textoMesEnvasado = "";
        String textoAnoEnvasado = "";
        Double pesoEnvase;
        //String origenPais;
        PaisOrigen pais;
        LocalDate fechaEnvasado;
        LocalDate fechaVencimiento;

        Producto producto = null; //El tipo de Producto se asigna con los ratio buttons

        //Cuando se elige un cliente Natural o Juridico, se obtienen datos especificos
        // y se construye un cliente con los datos obtenidos
        if (productoPerecedero.isSelected()) {
            textoDiaVencimiento = diaVencimiento.getText();
            textoMesVencimiento = mesVencimiento.getText();
            textoAnoVencimiento = anoVencimiento.getText();
            //Se transforma los campos String a datos tipo entero
            // Para convertirlos a una fecha de nacimiento tipo Local Date
            fechaVencimiento = LocalDate.of(Integer.parseInt(textoAnoVencimiento),
                    Integer.parseInt(textoMesVencimiento),
                    Integer.parseInt(textoDiaVencimiento));
            /////////// modificar el constructor que no tiene codigo en interfaz ///////////
            producto = new ProductoPerecedero(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, fechaVencimiento,TipoProducto.PERECEDERO);

        }
        if (productoRefrigerado.isSelected()) {
            textoCodAprobacion = aprobacionCodigo.getText();
            tempProducto = Double.parseDouble(productoTemperatura.getText());
            ///7//Actualizar aqui tambien ///////////////////:
            producto = new ProductoRefrigerado(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, textoCodAprobacion, tempProducto,TipoProducto.REFRIGERADO);
        }
        if (productoEnvasado.isSelected()) {
            textoDiaEnvasado = diaEnvasado.getText();
            textoMesEnvasado = mesEnvasado.getText();
            textoAnoEnvasado = anoEnvasado.getText();
            //Se transforma los campos String a datos tipo entero
            // Para convertirlos a una fecha de nacimiento tipo Local Date
            fechaEnvasado = LocalDate.of(Integer.parseInt(textoAnoEnvasado),
                    Integer.parseInt(textoMesEnvasado),
                    Integer.parseInt(textoDiaEnvasado));
            pesoEnvase = Double.parseDouble(productoPeso.getText());

            if (colombiaOrigen.isSelected()) {
                pais = PaisOrigen.COLOMBIA;
            } else if (chileOrigen.isSelected()) {
                pais = PaisOrigen.CHILE;
            } else if (peruOrigen.isSelected()) {
                pais = PaisOrigen.PERU;
            } else if (argentinaOrigen.isSelected()) {
                pais = PaisOrigen.ARGENTINA;
            } else {
                pais = PaisOrigen.ECUADOR;
            }
            /////////// modificar el constructor que no tiene codigo en interfaz ///////////
            producto = new ProductoEnvasado(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, fechaEnvasado, pesoEnvase, pais,TipoProducto.ENVASADO);

        }

        //Ahora ya tenemos un cliente, que puede ser Natural o Juridico
        //Se agrega ese cliente a la lista de clientes del almacen
        almacen.agregarProducto(producto);

        /////// pruebas //////////
        //cada vez que se presiona el boton, se muestra la lista de clientes agregados
        almacen.mostrarProductos();


    }

    @FXML
    protected void hacerClickBtnEliminarCliente() {
        // Obtener el ítem seleccionado
        Cliente clienteSeleccionado = tablaClientes.getSelectionModel().getSelectedItem();

// Verificar si hay un ítem seleccionado
        if (clienteSeleccionado != null) {
            // Eliminar el ítem seleccionado de la lista observable
            clientes.remove(clienteSeleccionado);
            almacen.eliminarCliente(clienteSeleccionado);
        } else {
            // Mostrar un mensaje de advertencia si no hay un ítem seleccionado
            System.out.println("No se ha seleccionado ningún cliente para eliminar.");
        }
        almacen.mostrarClientes();


    }
}
