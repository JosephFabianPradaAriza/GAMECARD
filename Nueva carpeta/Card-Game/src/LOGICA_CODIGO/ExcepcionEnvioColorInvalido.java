/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
class ExcepcionEnvioColorInvalido extends Exception {

    private Carta.Color esperado;
    private Carta.Color actual;

    public ExcepcionEnvioColorInvalido(String mensaje, Carta.Color actual, Carta.Color esperado) {
        this.esperado = esperado;
        this.actual = actual;
    }
}
