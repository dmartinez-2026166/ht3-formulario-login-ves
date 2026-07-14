package org.diegomartinez.errores;

public class ErroresPersonalizados extends Exception {
    public ErroresPersonalizados (String mensajeError) {
        super(mensajeError);
    }
    
    public ErroresPersonalizados () {
        
    }
    
    public void validarCampoNumericoEntero(String cadenaTexto) throws ErroresPersonalizados {
        String cadenaNumeros = "123456789";
        for (char letraIngresada : cadenaTexto.toCharArray()) {
            if(!cadenaNumeros.contains(String.valueOf(letraIngresada))) {
                throw new ErroresPersonalizados("INGRESASTE LETRAS EN EL CARNE");
            }
        }
    }
    
    public void validarLongitudTexto(String cadenaTexto, int cantidadMaxima) throws ErroresPersonalizados {
        if (cadenaTexto.length() > cantidadMaxima) {
            throw new ErroresPersonalizados("SUPERASTE LIMITE DE LETRAS: Total " + cantidadMaxima);
        }
    }
}
