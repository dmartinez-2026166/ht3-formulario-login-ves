package org.diegomartinez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import org.diegomartinez.model.Persona;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

public class RegistroView {

    private static RegistroView instanciaRegistroView;
    private Pane instanciaPanel;
    private ComboBox<Persona> cmbTipoPersona;
    private VBox cajaVertical;
    private Label lblTipoPersona;
    private final String RUTA_ESTILOS = "/com/diegomartinez/styles/";

    private GridPane formulario;
    //ATRIBUTOS PERSONA
    private Label lblNombres;
    private Label lblApellidos;
    private TextField txtNombres;
    private TextField txtApellidos;
    //ATRIBUTOS ESTUDIANTE
    private Label lblGradoEstudiante;
    private Label lblNumeroCarne;
    private Label lblAprobado;
    private TextField txtGradoEstudiante;
    private TextField txtNumeroCarne;
    private RadioButton rbAprabado;
    //ATRIBUTOS MAESTRO
    private Label lblActivo;
    private Label lblCurso;
    private Label lblGradoMaestro;
    private TextField txtGradoMaestro;
    private TextField txtCurso;
    private CheckBox cbActivo;

    private Button btnGuardar;
    private Button btnLimpiar;

    public RegistroView() {
        construirVista();
    }

    public void construirVista() {
        instanciaPanel = new Pane();
        instanciaPanel.getStylesheets().add(RUTA_ESTILOS + "RegistroStyles.css");
        instanciaPanel.getStyleClass().add("panel-registro"); //agrego el nombre panel-principal al contenedor panel

        cajaVertical = new VBox(10);
        cmbTipoPersona = new ComboBox<>();
        lblTipoPersona = new Label("Seleccione el Objeto a crear");

        formulario = new GridPane(15, 10);

        // Inicialización de atributos Persona
        lblNombres = new Label("Nombres:");
        lblApellidos = new Label("Apellidos:");
        txtNombres = new TextField();
        txtApellidos = new TextField();

        // Inicialización de atributos Estudiante
        lblGradoEstudiante = new Label("Grado Estudiante:");
        lblNumeroCarne = new Label("Número de Carné:");
        lblAprobado = new Label("Aprobado:");
        txtGradoEstudiante = new TextField();
        txtNumeroCarne = new TextField();
        rbAprabado = new RadioButton();

        // Inicialización de atributos Maestro
        lblActivo = new Label("Activo:");
        lblCurso = new Label("Curso:");
        lblGradoMaestro = new Label("Grado Maestro:");
        txtGradoMaestro = new TextField();
        txtCurso = new TextField();
        cbActivo = new CheckBox();

        // Inicialización de botones
        btnGuardar = new Button("Guardar");
        btnGuardar.getStyleClass().add("btn-guardar");
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.getStyleClass().add("btn-limpiar");

        // Agregar componentes al GridPane (2 columnas)
        formulario.add(lblNombres, 0, 0);
        formulario.add(txtNombres, 1, 0);

        formulario.add(lblApellidos, 0, 1);
        formulario.add(txtApellidos, 1, 1);

        // Estudiante
        formulario.add(lblGradoEstudiante, 0, 2);
        formulario.add(txtGradoEstudiante, 1, 2);

        formulario.add(lblNumeroCarne, 0, 3);
        formulario.add(txtNumeroCarne, 1, 3);

        formulario.add(lblAprobado, 0, 4);
        formulario.add(rbAprabado, 1, 4);

        // Estudiante
        formulario.add(lblGradoMaestro, 0, 5);
        formulario.add(txtGradoMaestro, 1, 5);

        formulario.add(lblCurso, 0, 6);
        formulario.add(txtCurso, 1, 6);

        formulario.add(lblActivo, 0, 7);
        formulario.add(cbActivo, 1, 7);

        formulario.add(btnGuardar, 0, 8);
        formulario.add(btnLimpiar, 1, 8);

        cajaVertical.getChildren().addAll(lblTipoPersona, cmbTipoPersona, formulario);

        instanciaPanel.getChildren().add(cajaVertical);
    }

    public Label getLblTipoPersona() {
        return lblTipoPersona;
    }

    public void setLblTipoPersona(Label lblTipoPersona) {
        this.lblTipoPersona = lblTipoPersona;
    }

    public GridPane getFormulario() {
        return formulario;
    }

    public void setFormulario(GridPane formulario) {
        this.formulario = formulario;
    }

    public ComboBox<Persona> getCmbTipoPersona() {
        return cmbTipoPersona;
    }

    public void setCmbTipoPersona(ComboBox<Persona> cmbTipoPersona) {
        this.cmbTipoPersona = cmbTipoPersona;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public static RegistroView getInstanciaRegistroView() {
        if (instanciaRegistroView == null) {
            instanciaRegistroView = new RegistroView();
        }
        return instanciaRegistroView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public Label getLblNombres() {
        return lblNombres;
    }

    public void setLblNombres(Label lblNombres) {
        this.lblNombres = lblNombres;
    }

    public Label getLblApellidos() {
        return lblApellidos;
    }

    public void setLblApellidos(Label lblApellidos) {
        this.lblApellidos = lblApellidos;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(TextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(TextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public Label getLblGradoEstudiante() {
        return lblGradoEstudiante;
    }

    public void setLblGradoEstudiante(Label lblGradoEstudiante) {
        this.lblGradoEstudiante = lblGradoEstudiante;
    }

    public Label getLblNumeroCarne() {
        return lblNumeroCarne;
    }

    public void setLblNumeroCarne(Label lblNumeroCarne) {
        this.lblNumeroCarne = lblNumeroCarne;
    }

    public Label getLblAprobado() {
        return lblAprobado;
    }

    public void setLblAprobado(Label lblAprobado) {
        this.lblAprobado = lblAprobado;
    }

    public TextField getTxtGradoEstudiante() {
        return txtGradoEstudiante;
    }

    public void setTxtGradoEstudiante(TextField txtGradoEstudiante) {
        this.txtGradoEstudiante = txtGradoEstudiante;
    }

    public TextField getTxtNumeroCarne() {
        return txtNumeroCarne;
    }

    public void setTxtNumeroCarne(TextField txtNumeroCarne) {
        this.txtNumeroCarne = txtNumeroCarne;
    }

    public RadioButton getRbAprabado() {
        return rbAprabado;
    }

    public void setRbAprabado(RadioButton rbAprabado) {
        this.rbAprabado = rbAprabado;
    }

    public Label getLblActivo() {
        return lblActivo;
    }

    public void setLblActivo(Label lblActivo) {
        this.lblActivo = lblActivo;
    }

    public Label getLblCurso() {
        return lblCurso;
    }

    public void setLblCurso(Label lblCurso) {
        this.lblCurso = lblCurso;
    }

    public Label getLblGradoMaestro() {
        return lblGradoMaestro;
    }

    public void setLblGradoMaestro(Label lblGradoMaestro) {
        this.lblGradoMaestro = lblGradoMaestro;
    }

    public TextField getTxtGradoMaestro() {
        return txtGradoMaestro;
    }

    public void setTxtGradoMaestro(TextField txtGradoMaestro) {
        this.txtGradoMaestro = txtGradoMaestro;
    }

    public TextField getTxtCurso() {
        return txtCurso;
    }

    public void setTxtCurso(TextField txtCurso) {
        this.txtCurso = txtCurso;
    }

    public CheckBox getCbActivo() {
        return cbActivo;
    }

    public void setCbActivo(CheckBox cbActivo) {
        this.cbActivo = cbActivo;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(Button btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(Button btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
}
