package com.diegomartinez.system;

import com.diegomartinez.controller.SceneManagerController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage escenarioRaiz) {
        SceneManagerController.getInstanciaSceneManagerController().setEscenarioPrincipal(escenarioRaiz);//seteando mi escenario
        SceneManagerController.getInstanciaSceneManagerController().vistaPrincipal();//llamando la ventana a mostrar
    }
}
