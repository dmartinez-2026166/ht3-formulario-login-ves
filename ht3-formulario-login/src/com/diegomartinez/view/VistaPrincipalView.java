package com.diegomartinez.view;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;

public class VistaPrincipalView {

    private static VistaPrincipalView instanciaVistaPrincipalView;
    private Pane instanciaPanel;
    private VBox cajaVertical;
    private TabPane seccionTabs;
    private Tab tabRegistro;
    private Tab tabResumen;
    private final String RUTA_ESTILOS = "/com/diegomartinez/styles/";

    //CONSTRUCTORES
    private VistaPrincipalView() {
        construirVista();
    }

    public void construirVista() {
        /*El problema con que no se ve el formulario es por el tamaño, con css voy arreglar lo visual
            usare un archivo css para todo el contenido del panel
         */
        instanciaPanel = new Pane();
        //Como ya cree el objeto puedo agregar el css global del panel
        instanciaPanel.getStylesheets().add(RUTA_ESTILOS + "VistaPrincipalStyle.css");
        instanciaPanel.getStyleClass().add("panel-principal"); //agrego el nombre panel-principal al contenedor panel

        cajaVertical = new VBox(15);
        cajaVertical.getStyleClass().add("caja-vertical");
        // CONTENEDOR DE PESTAÑAS
        seccionTabs = new TabPane();
        seccionTabs.getStyleClass().add("seccion-tabs");
        seccionTabs.setPrefWidth(680);
        //PESTAÑAS
        tabRegistro = new Tab("Registro");
        tabRegistro.setClosable(false);
        tabResumen = new Tab("Resumen");
        tabResumen.setClosable(false);

        seccionTabs.getTabs().addAll(tabRegistro, tabResumen);

        Button btnSalir = new Button("X");
        btnSalir.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-cursor: hand;");
        btnSalir.setPrefWidth(35);
        btnSalir.setPrefHeight(25);

        btnSalir.setOnMouseEntered(e -> btnSalir.setStyle("-fx-background-color: #bd2130; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-cursor: hand;"));
        btnSalir.setOnMouseExited(e -> btnSalir.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-cursor: hand;"));

        btnSalir.setOnAction(e -> System.exit(0));

        HBox topBar = new HBox(10);
        topBar.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(seccionTabs, Priority.ALWAYS);
        topBar.getChildren().addAll(seccionTabs, btnSalir);
        
        cajaVertical.getChildren().add(topBar);
        instanciaPanel.getChildren().add(cajaVertical);
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public TabPane getSeccionTabs() {
        return seccionTabs;
    }

    public void setSeccionTabs(TabPane seccionTabs) {
        this.seccionTabs = seccionTabs;
    }

    public Tab getTabRegistro() {
        return tabRegistro;
    }

    public void setTabRegistro(Tab tabRegistro) {
        this.tabRegistro = tabRegistro;
    }

    public Tab getTabResumen() {
        return tabResumen;
    }

    public void setTabResumen(Tab tabResumen) {
        this.tabResumen = tabResumen;
    }

    public static VistaPrincipalView getInstanciaVistaPrincipalView() {
        if (instanciaVistaPrincipalView == null) {
            instanciaVistaPrincipalView = new VistaPrincipalView();
        }
        return instanciaVistaPrincipalView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }
}
