/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
public class TomarCarta {
    
    private Carta[] cartas;
    private int CartasBaraja;
    
    public boolean EstaVacio() {
            return cartas.length == 0;
        }
    
    public Carta tomar_carta() throws IllegalArgumentException{
            if(EstaVacio()){
                throw new IllegalArgumentException("No se pueden robar cartas, puesto que no hay cartas en la baraja.");
            }
            return cartas[--CartasBaraja];
        }
}
