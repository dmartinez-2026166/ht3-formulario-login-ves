package org.diegomartinez.controller;

import org.diegomartinez.errores.ErroresPersonalizados;
import org.diegomartinez.view.RegistroView;
import java.util.ArrayList;
import org.diegomartinez.model.Persona;
import org.diegomartinez.model.Estudiante;
import org.diegomartinez.model.Maestro;
import org.diegomartinez.view.ResumenView;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class RegistroController {
    
    private final RegistroView registroView;
    private ArrayList<Persona> listaPersonas;
    private static ArrayList<Persona> listaRegistroPersonas;

    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        cargarDatos();
        construirComboBox();
        construirAcciones();
    }

    public void cargarDatos() {
        Estudiante objetoEstudiante = new Estudiante();
        Maestro objetoMaestro = new Maestro();

        listaPersonas = new ArrayList<>();

        listaPersonas.add(objetoEstudiante);
        listaPersonas.add(objetoMaestro);

        listaRegistroPersonas = new ArrayList<>();

    }

    public void construirComboBox() {
        this.registroView.getCmbTipoPersona().setItems(
                FXCollections.observableArrayList(listaPersonas)
        );
    }

    public void construirAcciones() {
        this.registroView.getCmbTipoPersona().setOnAction(
                (evento) -> {
                    validarCampos(this.registroView.getCmbTipoPersona().getValue());
                }
        );

        this.registroView.getBtnGuardar().setOnAction(
                (evento) -> {
                    guardarPersona();
                    limpiarCampos();
                }
        );

        this.registroView.getBtnLimpiar().setOnAction(
                (evento) -> {
                    limpiarCampos();
                    mostrarCampos();
                }
        );
    }

    public void limpiarCampos() {
        this.registroView.getTxtNombres().clear();
        this.registroView.getTxtApellidos().clear();
        this.registroView.getTxtCurso().clear();
        this.registroView.getTxtNumeroCarne().clear();
        this.registroView.getTxtGradoEstudiante().clear();
        this.registroView.getTxtGradoMaestro().clear();
        this.registroView.getRbAprabado().setSelected(false);
        this.registroView.getCbActivo().setSelected(false);
        this.registroView.getCmbTipoPersona().getSelectionModel().select(null);
    }

    public void mostrarCampos() {
        boolean seleccion = true;
        cambiarVisibilidadCampos(this.registroView.getLblGradoEstudiante(),
                this.registroView.getTxtGradoEstudiante(), seleccion);

        cambiarVisibilidadCampos(this.registroView.getLblNumeroCarne(),
                this.registroView.getTxtNumeroCarne(), seleccion);

        cambiarVisibilidadCampos(this.registroView.getLblCurso(), this.registroView.getTxtCurso(),
                seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblGradoMaestro(),
                this.registroView.getTxtGradoMaestro(),
                seleccion);
    }

    public void guardarPersona() {
        if (this.registroView.getCmbTipoPersona().getValue() == null) {
            JOptionPane.showMessageDialog(null, "TIENES QUE ELEGIR EL OBJETO A REGISTRAR");
            return;
        }
        if (this.registroView.getCmbTipoPersona().getValue() instanceof Estudiante) {
            try {
                ErroresPersonalizados objetoErrores = new ErroresPersonalizados();
                Estudiante nuevoEstudiante = new Estudiante();
                
                objetoErrores.validarCampoNumericoEntero(this.registroView.getTxtNumeroCarne().getText()) ;
                
                objetoErrores.validarLongitudTexto(this.registroView.getTxtNombres().getText(), 15);
                objetoErrores.validarLongitudTexto(this.registroView.getTxtApellidos().getText(), 5);
                
                nuevoEstudiante.setNombres(this.registroView.getTxtNombres().getText());
                nuevoEstudiante.setApellidos(this.registroView.getTxtApellidos().getText());
                nuevoEstudiante.setEsAprobado(this.registroView.getRbAprabado().isSelected());
                nuevoEstudiante.setNumeroCarne(Integer.parseInt(this.registroView.getTxtNumeroCarne().getText()));
                nuevoEstudiante.setGrado(this.registroView.getTxtGradoEstudiante().getText());
                
                listaRegistroPersonas.add(nuevoEstudiante);
            } catch (ErroresPersonalizados miExcepcion) {
                JOptionPane.showMessageDialog(null, miExcepcion.getMessage());
                miExcepcion.printStackTrace();
            }
        } else {
            Maestro nuevoMaestro = new Maestro();
            nuevoMaestro.setNombres(this.registroView.getTxtNombres().getText());
            nuevoMaestro.setApellidos(this.registroView.getTxtApellidos().getText());
            nuevoMaestro.setActivo(this.registroView.getCbActivo().isSelected());
            nuevoMaestro.setCurso(this.registroView.getTxtCurso().getText());
            nuevoMaestro.setGrado(this.registroView.getTxtGradoMaestro().getText());

            listaRegistroPersonas.add(nuevoMaestro);
        }
        JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL REGISTRO");
        //Cada que agrego a la lista, independientemente del objeto actualizare la lista en el resument
        new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();

    }

    public void validarCampos(Persona objetoPersonaSeleccionado) {
        if (objetoPersonaSeleccionado == null) {
            return;
        }
        String claseSeleccionada = objetoPersonaSeleccionado.toString();
        boolean seleccion = claseSeleccionada.equals("Estudiante");

        cambiarVisibilidadCampos(this.registroView.getLblGradoEstudiante(),
                this.registroView.getTxtGradoEstudiante(), seleccion);

        cambiarVisibilidadCampos(this.registroView.getLblNumeroCarne(),
                this.registroView.getTxtNumeroCarne(), seleccion);

        cambiarVisibilidadCampos(this.registroView.getLblCurso(), this.registroView.getTxtCurso(),
                !seleccion);
        cambiarVisibilidadCampos(this.registroView.getLblGradoMaestro(),
                this.registroView.getTxtGradoMaestro(),
                !seleccion);
    }

    public void cambiarVisibilidadCampos(Label etiqueta, TextField cajaTexto, boolean visible) {
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        cajaTexto.setVisible(visible);
        cajaTexto.setManaged(visible);

    }

    public void cambiarVisibilidadCampos(Label etiqueta, CheckBox cajaSeleccion, boolean visible) {
        etiqueta.setVisible(visible);
        cajaSeleccion.setVisible(visible);

    }

    public void cambiarVisibilidadCampos(Label etiqueta, RadioButton radioSeleccion, boolean visible) {

    }

    public static ArrayList<Persona> getListaRegistroPersonas() {
        return listaRegistroPersonas;
    }
    
}
