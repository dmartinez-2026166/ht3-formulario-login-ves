package org.diegomartinez.controller;

import org.diegomartinez.model.Persona;
import org.diegomartinez.view.ResumenView;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

public class ResumenController {
    private final ResumenView resumenView;
    private ObservableList<Persona> listaObservablePersonas;

    public ResumenController(ResumenView resumenView) {
        this.resumenView = resumenView;
        construirColumnas();
        cargarDatos();
        construirAcciones();
    }

    public void construirColumnas() {
        this.resumenView.getColNombres().setCellValueFactory(
                new PropertyValueFactory<Persona, String>("nombres")
        );
        this.resumenView.getColApellidos().setCellValueFactory(
                new PropertyValueFactory<Persona, String>("apellidos")
        );
    }

    public void cargarDatos() {
        ArrayList<Persona> listaRegistroPersonas
                = RegistroController.getListaRegistroPersonas(); //trae la lista registro del registro Controller
        //CONVERTIR lista registro en conjunto de objetos
        listaObservablePersonas = FXCollections.observableArrayList(listaRegistroPersonas);

        //Pasar lista observable a la tabla
        this.resumenView.getTblPersonas().setItems(listaObservablePersonas);
    }

    public void construirAcciones() {
        this.resumenView.getBtnVerInformacion().setOnAction(
                (evento) -> {
                    verInformacion();
                }
        );
    }

    public void verInformacion() {        
        SelectionModel modeloSeleccionado = this.resumenView.getTblPersonas().getSelectionModel();
        Persona personaSeleccionada = (Persona) modeloSeleccionado.getSelectedItem();
    
        if (personaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO");
        } else {
            JOptionPane.showMessageDialog(null, personaSeleccionada.presentacionPersona());
        }
    }
}
