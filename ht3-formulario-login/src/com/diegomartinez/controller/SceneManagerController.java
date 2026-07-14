package com.diegomartinez.controller;

import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javax.swing.JOptionPane;
import com.diegomartinez.view.LoginView;
import com.diegomartinez.view.VistaPrincipalView;

public class SceneManagerController {

    private static SceneManagerController instanciaSceneManagerController;
    private Stage escenarioPrincipal;

    //CONSTRUCTORES
    private SceneManagerController() {
    }

    //METODOS
    public void cambiarEscenaPrincipal(Pane panelView, int ancho, int alto) {
        try {
            Scene escenaPrincipal = new Scene(panelView, ancho, alto);

            this.escenarioPrincipal.setScene(escenaPrincipal);
            this.escenarioPrincipal.sizeToScene();
            this.escenarioPrincipal.show();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error objeto nulo cambiar escena");
        }
    }

    public void mostrarLogin() {
    try {
        LoginView vistaLogin = new LoginView();
        
        // El login se queda plano y estético como querías
        escenarioPrincipal.initStyle(javafx.stage.StageStyle.UNDECORATED);
        
        cambiarEscenaPrincipal(vistaLogin.getLayout(), 350, 300);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void vistaPrincipal(){
        try {
            //Le doy nombre a la ventana
            this.escenarioPrincipal.setTitle("JAVAFX-POO | REGISTRO Y LISTA");
            this.escenarioPrincipal.setResizable(false);
            VistaPrincipalView vistaPrincipal = VistaPrincipalView.getInstanciaVistaPrincipalView();
            cambiarEscenaPrincipal(vistaPrincipal.getInstanciaPanel(), 680, 580 );
            new VistaPrincipalController( vistaPrincipal );
            
        } catch (NullPointerException objeto){
            JOptionPane.showMessageDialog(null, "Error objeto nulo vista principal");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error padre vista principal");
        }
    }

    public static SceneManagerController getInstanciaSceneManagerController() {
        if (instanciaSceneManagerController == null) {
            instanciaSceneManagerController = new SceneManagerController();
        }
        return instanciaSceneManagerController;
    }

    public void setEscenarioPrincipal(Stage escenarioRaiz) {
        this.escenarioPrincipal = escenarioRaiz;
    }
}
