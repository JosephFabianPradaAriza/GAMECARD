/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
public class Generar_Cartas {
    public static Carta crearCarta(Carta.Color color, Carta.Valor valor) {
        return new Carta(color, valor);
    }
}