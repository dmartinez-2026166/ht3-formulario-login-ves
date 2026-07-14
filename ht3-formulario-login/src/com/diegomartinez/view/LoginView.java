package com.diegomartinez.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.diegomartinez.controller.AuthSystem;
import com.diegomartinez.controller.SceneManagerController;
import com.diegomartinez.model.Usuario;

public class LoginView {
    private VBox root;
    private double xOffset = 0;
    private double yOffset = 0;
    private AuthSystem auth = new AuthSystem();

    public LoginView() {
        Label lblTitulo = new Label("Inicio de Sesión");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333;");

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuario");
        
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        Button btnIngresar = new Button("Ingresar");
        Button btnCerrar = new Button("X");

        btnIngresar.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnIngresar.setPrefWidth(120);
        btnIngresar.setOnMouseEntered(e -> btnIngresar.setStyle("-fx-background-color: #0056b3; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;"));
        btnIngresar.setOnMouseExited(e -> btnIngresar.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;"));

        btnCerrar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnCerrar.setOnAction(e -> System.exit(0));

        HBox topBar = new HBox(btnCerrar);
        topBar.setAlignment(Pos.TOP_RIGHT);

        root = new VBox(15, topBar, lblTitulo, txtUsuario, txtPassword, btnIngresar);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ffffff; -fx-padding: 25; -fx-background-radius: 15; " +
                     "-fx-border-radius: 15; -fx-border-color: #cccccc; -fx-border-width: 1;");

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        btnIngresar.setOnAction(e -> {
            txtUsuario.setStyle("");
            txtPassword.setStyle("");

            String user = txtUsuario.getText();
            String pass = txtPassword.getText();

            if (user.isEmpty() || pass.isEmpty()) {
                if (user.isEmpty()) txtUsuario.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-radius: 3;");
                if (pass.isEmpty()) txtPassword.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-radius: 3;");
                return;
            }

            Usuario usuarioLogueado = auth.login(user, pass);

            if (usuarioLogueado != null) {
                mostrarVentanaBienvenida(usuarioLogueado.getNombreCompleto());
            } else {
                txtUsuario.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-radius: 3;");
                txtPassword.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-radius: 3;");
            }
        });
    }

    public VBox getLayout() {
        return root;
    }

    private void mostrarVentanaBienvenida(String nombreCompleto) {
        Stage bienvenidaStage = new Stage();
        bienvenidaStage.initStyle(javafx.stage.StageStyle.UTILITY);

        Label lblBienvenida = new Label("Bienvenido, " + nombreCompleto);
        lblBienvenida.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Button btnContinuar = new Button("Continuar");
        btnContinuar.setOnAction(e -> {
            bienvenidaStage.close();
            
            SceneManagerController.getInstanciaSceneManagerController().vistaPrincipal();
        });

        VBox layoutBienvenida = new VBox(15, lblBienvenida, btnContinuar);
        layoutBienvenida.setAlignment(Pos.CENTER);
        layoutBienvenida.setStyle("-fx-padding: 25;");

        Scene escena = new Scene(layoutBienvenida, 280, 130);
        bienvenidaStage.setScene(escena);
        bienvenidaStage.setTitle("Acceso Exitoso");
        bienvenidaStage.show();
    }
}