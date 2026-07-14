package com.diegomartinez.controller;

import com.diegomartinez.view.RegistroView;
import com.diegomartinez.view.ResumenView;
import com.diegomartinez.view.VistaPrincipalView;

public class VistaPrincipalController {
    private final VistaPrincipalView vistaPrincipalView;
    
    public VistaPrincipalController( VistaPrincipalView vistaPrincipal ){
        this.vistaPrincipalView = vistaPrincipal;
        construirControladores();
        construirAcciones();
    }
    
    public void construirControladores(){
        new RegistroController( RegistroView.getInstanciaRegistroView() );
        new ResumenController( ResumenView.getInstanciaResumenView() );
    }
    
    public void construirAcciones(){
        this.vistaPrincipalView.getTabRegistro().setContent(
            RegistroView.getInstanciaRegistroView().getInstanciaPanel()
        );
        
        this.vistaPrincipalView.getTabResumen().setContent(
            ResumenView.getInstanciaResumenView().getInstanciaPanel()
        );
        
    }
}
