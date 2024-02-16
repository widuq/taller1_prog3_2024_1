/*
    Clase que controla los eventos y acciones del proyecto, realiza:
    - Lectura de datos
    - Escucha de botones que ejecuta acciones segun el boton presionado
    - Presentacion de los datos guardados
 */
package co.edu.uniquindio.programacion3.taller1almacen;

//paquetes necesarios para trabajar:
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.time.LocalDate;


public class HelloController {

    //Capturar los datos del cliente:
    @FXML private TextField nombreCliente;
    @FXML private TextField apellidoCliente;
    @FXML private TextField idCliente;
    @FXML private TextField direccionCliente;
    @FXML private TextField telefonoCliente;
    @FXML private TextField emailCliente;
    @FXML private TextField diaNacimientoCliente;
    @FXML private TextField mesNacimientoCliente;
    @FXML private TextField yearNacimientoCliente;
    @FXML private TextField nitCliente;
    @FXML private RadioButton clienteNatural;
    @FXML private RadioButton clienteJuridico;
    @FXML private ToggleGroup tipoCliente;

    //Para capturar Los datos del producto:
    @FXML private TextField codigoProducto;
    @FXML private TextField productoNombre;
    @FXML private TextField productoDescripcion;
    @FXML private TextField valorProducto;
    @FXML private TextField cantidadProducto;
    @FXML private RadioButton productoPerecedero;
    @FXML private RadioButton productoRefrigerado;
    @FXML private RadioButton productoEnvasado;
    @FXML private TextField diaVencimiento;
    @FXML private TextField mesVencimiento;
    @FXML private TextField anoVencimiento;
    @FXML private TextField aprobacionCodigo;
    @FXML private TextField productoTemperatura;
    @FXML private TextField diaEnvasado;
    @FXML private TextField mesEnvasado;
    @FXML private TextField anoEnvasado;
    @FXML private TextField productoPeso;

    // ratio buttons
    @FXML private RadioButton colombiaOrigen;
    @FXML private RadioButton chileOrigen;
    @FXML private RadioButton peruOrigen;
    @FXML private RadioButton argentinaOrigen;
    @FXML private RadioButton ecuadorOrigen;
    @FXML private ToggleGroup tipoProducto;

    @FXML private ToggleGroup tipoPais;
    @FXML private Almacen almacen = new Almacen();


    //Campos para presentar los datos de los clientes en una tabla:
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
    ObservableList<Cliente> clientes; //Lista observable que contiene objetos tipo cliente

    //Campos para presentar los productos de los clientes en una tabla:
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn codigoProductoTabla;
    @FXML private TableColumn nombreProductoTabla;
    @FXML private TableColumn descripcionProductoTabla;
    @FXML private TableColumn valorProductoTabla;
    @FXML private TableColumn cantidadProductoTabla;
    @FXML private TableColumn tipoProductoTabla;
    @FXML private TableColumn fechaVencimientoProductoTabla;
    @FXML private TableColumn codigoAprobacionProductoTabla;
    @FXML private TableColumn temperaturaProductoTabla;
    @FXML private TableColumn fechaEnvasadoProductoTabla;
    @FXML private TableColumn pesoProductoTabla;
    @FXML private TableColumn paisOrigenProductoTabla;
    ObservableList<Producto> productos; //Lista observable que contiene objetos tipo producto

    @FXML private Button btnRegistrarCliente;
    @FXML private Button btnclienteActualizar;
    @FXML private Button btnclienteEliminar;
    @FXML private Button productoAgregar;
    @FXML private Button productoActualizar;
    @FXML private Button productoEliminar;

    //controlador boton Registrar Cliente
    @FXML
    protected void hacerClick() {
        //obtener los datos del cliente ingresados
        String textoNombre = nombreCliente.getText();
        String textoApellido = apellidoCliente.getText();
        String textoId = idCliente.getText();
        String textoDireccion = direccionCliente.getText();
        String textoTelefono = telefonoCliente.getText();
        //Obtener datos de las clases hijas de cliente:
        String textoEmail = ""; //inicializados con un string vacio para evitar conlfictos
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
        almacen.agregarCliente(cliente); //Se agrega ese cliente a la lista de clientes del almacen

        // Se crea una lista observable a partir de la lista de clientes de la clase almacen
        clientes = FXCollections.observableArrayList(almacen.getListaClientes());
        tablaClientes.setItems(clientes); //se coloca los elementos en la tabla
        // En cada celda se extrae la informacion de cada cliente:
        nombreClienteTabla.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        idClienteTabla.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        direccionClienteTabla.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        telefonoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));

        //Para los atributos de las clases hijas:
        TipoCliente tipoCliente = cliente.getTipoCliente();
        if(tipoCliente == TipoCliente.NATURAL){ //mostrar los datos de un cliente natural
            emailClienteTabla.setCellValueFactory(new PropertyValueFactory<>("email"));
            fechaNacimientoClienteTabla.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
            nitClienteTabla.setCellValueFactory(null);
        }else{//mostrar los datos del cliente juridico
            emailClienteTabla.setCellValueFactory(null);
            fechaNacimientoClienteTabla.setCellValueFactory(null);
            nitClienteTabla.setCellValueFactory(new PropertyValueFactory<>("nit"));
        }
    }



    //Seccion de control de la ventana productos

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
        PaisOrigen pais;
        LocalDate fechaEnvasado;
        LocalDate fechaVencimiento;

        Producto producto = null; //El tipo de Producto se asigna con los ratio buttons

        if (productoPerecedero.isSelected()) { //cuando de registra un producto perecedero:
            textoDiaVencimiento = diaVencimiento.getText();
            textoMesVencimiento = mesVencimiento.getText();
            textoAnoVencimiento = anoVencimiento.getText();
            //Se transforma los campos String a datos tipo entero
            // Para convertirlos a una fecha de tipo Local Date
            fechaVencimiento = LocalDate.of(Integer.parseInt(textoAnoVencimiento),
                    Integer.parseInt(textoMesVencimiento),
                    Integer.parseInt(textoDiaVencimiento));
            //se construye un producto perecedero con los datos obtenidos
            producto = new ProductoPerecedero(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, fechaVencimiento,TipoProducto.PERECEDERO);

        }
        if (productoRefrigerado.isSelected()) {//cuando de registra un producto refrigerado:
            textoCodAprobacion = aprobacionCodigo.getText();
            tempProducto = Double.parseDouble(productoTemperatura.getText());
            producto = new ProductoRefrigerado(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, textoCodAprobacion, tempProducto,TipoProducto.REFRIGERADO);
        }
        if (productoEnvasado.isSelected()) { //cuando de registra un producto envasado:
            textoDiaEnvasado = diaEnvasado.getText();
            textoMesEnvasado = mesEnvasado.getText();
            textoAnoEnvasado = anoEnvasado.getText();
            //Se transforma los campos String a datos tipo entero
            // Para convertirlos a una fecha de tipo Local Date
            fechaEnvasado = LocalDate.of(Integer.parseInt(textoAnoEnvasado),
                    Integer.parseInt(textoMesEnvasado),
                    Integer.parseInt(textoDiaEnvasado));
            pesoEnvase = Double.parseDouble(productoPeso.getText());

            //asignacion del pais de origen
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
            //se cres un producto envasdado
            producto = new ProductoEnvasado(textoCodigoProd, textoNombreProd, textoDescripcionProd,
                    valorProductoDouble, cantidadProdInt, fechaEnvasado, pesoEnvase, pais,TipoProducto.ENVASADO);

        }

        almacen.agregarProducto(producto); //Agregar el producto a la lista del almacen

        // Se crea una lista observable a partir de la lista de productos de la clase almacen
        productos = FXCollections.observableArrayList(almacen.getListaProductos());
        tablaProductos.setItems(productos); //se coloca los elementos en la tabla de productos
        // En cada celda se extrae la informacion de cada producto:
        codigoProductoTabla.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nombreProductoTabla.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        descripcionProductoTabla.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        valorProductoTabla.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        cantidadProductoTabla.setCellValueFactory(new PropertyValueFactory<>("cantidadExistencias"));
        tipoProductoTabla.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
        //Para los atributos de las clases hijas:
        TipoProducto tipoProducto = producto.getTipoProducto();
        if(tipoProducto == TipoProducto.PERECEDERO){ //mostrar los datos de un producto perecedero
            fechaVencimientoProductoTabla.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
            codigoAprobacionProductoTabla.setCellValueFactory(null);
            temperaturaProductoTabla.setCellValueFactory(null);
            fechaEnvasadoProductoTabla.setCellValueFactory(null);
            pesoProductoTabla.setCellValueFactory(null);
            paisOrigenProductoTabla.setCellValueFactory(null);

        } else if (tipoProducto == TipoProducto.REFRIGERADO){
            fechaVencimientoProductoTabla.setCellValueFactory(null);
            codigoAprobacionProductoTabla.setCellValueFactory(new PropertyValueFactory<>("codAprovacion"));
            temperaturaProductoTabla.setCellValueFactory(new PropertyValueFactory<>("tempRecomendada"));
            fechaEnvasadoProductoTabla.setCellValueFactory(null);
            pesoProductoTabla.setCellValueFactory(null);
            paisOrigenProductoTabla.setCellValueFactory(null);

        }
        else{//mostrar los datos del cliente juridico
            fechaVencimientoProductoTabla.setCellValueFactory(null);
            codigoAprobacionProductoTabla.setCellValueFactory(null);
            temperaturaProductoTabla.setCellValueFactory(null);
            fechaEnvasadoProductoTabla.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
            pesoProductoTabla.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));
            paisOrigenProductoTabla.setCellValueFactory(new PropertyValueFactory<>("paisOrigen"));
        }
    }

    @FXML
    protected void hacerClickBtnEliminarCliente() {
        //apagar botones
        btnRegistrarCliente.setDisable(false);
        // Obtener el ítem seleccionado de la tabla observable
        Cliente clienteSeleccionado = tablaClientes.getSelectionModel().getSelectedItem();

        // Verificar si hay un ítem seleccionado
        if (clienteSeleccionado != null) {
            // Eliminar el ítem seleccionado de la lista observable
            clientes.remove(clienteSeleccionado); //se elimina el cliente mostrado de la tabla
            almacen.eliminarCliente(clienteSeleccionado); //se elimina el cliente de la lista del almacen
            btnclienteActualizar.setDisable(true);
            btnclienteEliminar.setDisable(true);
        }
    }

    //Super codigo actualizador de clientes :)
    @FXML
    protected void hacerClickBtnActualizarCliente() {
        hacerClick();
        hacerClickBtnEliminarCliente();
    }


    @FXML
    protected void hacerClickBtnEliminarProducto() {
        // Obtener el ítem seleccionado de la tabla observable
        Producto productoSeleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        // Verificar si hay un ítem seleccionado
        if (productoSeleccionado != null) {
            // Eliminar el ítem seleccionado de la lista observable
            productos.remove(productoSeleccionado); //se elimina el cliente mostrado de la tabla
            almacen.eliminarProducto(productoSeleccionado); //se elimina el cliente de la lista del almacen
        }
        productoActualizar.setDisable(true);
        productoEliminar.setDisable(true);
    }

    //Super codigo actualizador de clientes :)
    @FXML
    protected void hacerClickBtnActualizarProducto() {
        hacerClickBtnAgregarProducto();
        hacerClickBtnEliminarProducto();

    }


    //escuchador de eventos
    @FXML
    protected void initialize() {
        //Se crea un grupo de dos botones para optimizar la seleccion de opciones
        // solo permite activar un ratiobutton a la vez dependiendo del tipo de cliente seleccionado
        tipoCliente = new ToggleGroup();
        clienteNatural.setToggleGroup(tipoCliente);
        clienteJuridico.setToggleGroup(tipoCliente);

        //Por defecto se apagan los botones:
        btnclienteActualizar.setDisable(true);
        btnclienteEliminar.setDisable(true);
        productoActualizar.setDisable(true);
        productoEliminar.setDisable(true);
        //Por defecto se deshabilitan los campos de ingreso de texto para:
        //Datos cliente
        emailCliente.setDisable(true);
        diaNacimientoCliente.setDisable(true);
        mesNacimientoCliente.setDisable(true);
        yearNacimientoCliente.setDisable(true);
        nitCliente.setDisable(true);

        //Pais de origen
        colombiaOrigen.setDisable(true);
        chileOrigen.setDisable(true);
        peruOrigen.setDisable(true);
        argentinaOrigen.setDisable(true);
        ecuadorOrigen.setDisable(true);

        //tipo de producto
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

        // Habilitar o deshabilitar los rattioio buttons de los productos:
        tipoProducto.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue == productoPerecedero) { //producto perecedero:
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

                } else if (newValue == productoRefrigerado) { // producto refrigerado
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

                } else if (newValue == productoEnvasado) { //producto envasado
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
                btnclienteActualizar.setDisable(false);
                btnclienteEliminar.setDisable(false);
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

        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                productoActualizar.setDisable(false);
                productoEliminar.setDisable(false);
            }
        });



        }

}
