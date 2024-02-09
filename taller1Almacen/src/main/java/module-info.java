module co.edu.uniquindio.programacion3.taller1almacen {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens co.edu.uniquindio.programacion3.taller1almacen to javafx.fxml;
    exports co.edu.uniquindio.programacion3.taller1almacen;
}