/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Joseph F
 */
public class Gestionar_Jugadores {

    private int JugadorActual;
    private String[] CodigoJugadores;
    private ArrayList<ArrayList<Carta>> ManoJugador;

    public String ObtenerJugadorActual() {
        return this.CodigoJugadores[this.JugadorActual];
    }

    public String ObtenerJugadorPrevio(int i) {
        int index = this.JugadorActual - i;
        if (index == -1) {
            index = CodigoJugadores.length - 1;
        }
        return this.CodigoJugadores[index];
    }

    public String[] ObtenerJugadores() {
        return CodigoJugadores;
    }

    public void TurnoJugador(String codigo_jugadores) throws ExcepcionTurnoInvalidoJugador {
        if (this.CodigoJugadores[this.JugadorActual] != codigo_jugadores) {
            throw new ExcepcionTurnoInvalidoJugador("No es el turno de " + codigo_jugadores + ".", codigo_jugadores);
        }
    }
}
