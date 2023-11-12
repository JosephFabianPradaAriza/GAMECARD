/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
class ExcepcionEnvioValorInvalidoEnviado extends Exception {

    private Carta.Valor esperado;
    private Carta.Valor actual;

    public ExcepcionEnvioValorInvalidoEnviado(String mensaje, Carta.Valor actual, Carta.Valor esperado) {
        this.esperado = esperado;
        this.actual = actual;
    }
}