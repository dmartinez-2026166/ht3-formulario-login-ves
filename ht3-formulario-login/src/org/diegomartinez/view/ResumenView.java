package org.diegomartinez.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import org.diegomartinez.model.Persona;
import javafx.scene.control.Button;

public class ResumenView {
    private static ResumenView instanciaResumenView;
    private Pane instanciaPanel;
    private TableView <Persona> tblPersonas;
    private TableColumn <Persona , String> colNombres;
    private TableColumn <Persona, String> colApellidos;
    private VBox cajaVertical;
    private final String RUTA_ESTILOS = "/com/diegomartinez/styles/";
    private Button btnVerInformacion;
    
    private ResumenView(){
        construirVista();
    }
    
    public void construirVista(){
        instanciaPanel = new Pane();
        instanciaPanel.setPrefWidth(680);
        instanciaPanel.getStylesheets().add(RUTA_ESTILOS + "ResumenStyle.css");
        instanciaPanel.getStyleClass().add("panel-resumen");
        
        cajaVertical = new VBox(10);
        cajaVertical.setPrefWidth(680);
        
        btnVerInformacion = new Button("Ver informacion");
        btnVerInformacion.getStyleClass().add("btn-ver-informacion");
        
        tblPersonas = new TableView<>();
        
        colNombres = new TableColumn<>("Nombres");
        colNombres.setMinWidth(328);
        colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setMinWidth(328);
        
        tblPersonas.getColumns().add(colNombres);
        tblPersonas.getColumns().add(colApellidos);
        
        cajaVertical.getChildren().addAll(btnVerInformacion, tblPersonas);
        instanciaPanel.getChildren().add(cajaVertical);
    }

    public static ResumenView getInstanciaResumenView() {
        if( instanciaResumenView == null  )
            instanciaResumenView = new ResumenView();
        return instanciaResumenView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public TableView<Persona> getTblPersonas() {
        return tblPersonas;
    }

    public void setTblPersonas(TableView<Persona> tblPersonas) {
        this.tblPersonas = tblPersonas;
    }

    public TableColumn<Persona, String> getColNombres() {
        return colNombres;
    }

    public void setColNombres(TableColumn<Persona, String> colNombres) {
        this.colNombres = colNombres;
    }

    public TableColumn<Persona, String> getColApellidos() {
        return colApellidos;
    }

    public void setColApellidos(TableColumn<Persona, String> colApellidos) {
        this.colApellidos = colApellidos;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public Button getBtnVerInformacion() {
        return this.btnVerInformacion;
    }

    public void setBtnVerInformacion(Button btnVerInformacion) {
        this.btnVerInformacion = btnVerInformacion;
    }
    
}
