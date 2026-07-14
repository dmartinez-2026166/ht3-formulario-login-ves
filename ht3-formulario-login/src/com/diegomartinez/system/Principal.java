package com.diegomartinez.system;

import javafx.application.Application;
import javafx.stage.Stage;
import com.diegomartinez.controller.SceneManagerController;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioRaiz) {
        SceneManagerController.getInstanciaSceneManagerController().setEscenarioPrincipal(escenarioRaiz);
        SceneManagerController.getInstanciaSceneManagerController().mostrarLogin();
    }
}
