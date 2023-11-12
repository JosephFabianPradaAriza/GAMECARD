/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
class ExcepcionTurnoInvalidoJugador extends Exception{
    String CodigoJugadores;
    
    public ExcepcionTurnoInvalidoJugador(String message, String codigo_jugadores){
        super(message);
        CodigoJugadores = codigo_jugadores;
    }
    
    public String getCodigo_Jugadores(){
        return CodigoJugadores;
    }    
}