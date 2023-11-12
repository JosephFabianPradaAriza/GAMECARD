/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author Joseph F
 */
public class Gestionar_Cartas {

    private int JugadorActual;
    private String[] CodigoJugadores;

    private Baraja baraja;
    private ArrayList<ArrayList<Carta>> ManoJugador;
    private ArrayList<Carta> Restantes;

    private Carta.Color ColorValido;
    private Carta.Valor ValorValido;

    boolean DireccionJuego;

    public Carta ObtenerCartaSuperior() {
        return new Carta(ColorValido, ValorValido);
    }

    public ImageIcon ObtenerImagenCartaSuperior() {
        return new ImageIcon(ColorValido + "_" + ValorValido + ".png");
    }

    public boolean CartaValida(Carta carta) {
        return carta.getColor() == ColorValido || carta.getValor() == ValorValido;
    }

    public ArrayList<Carta> ObtenerManoJugador(String codigo_jugadores) {
        int index = Arrays.asList(CodigoJugadores).indexOf(codigo_jugadores);
        return ManoJugador.get(index);
    }

    public Carta ObtenerCartaJugador(String codigo_jugadores, int escoger) {
        ArrayList<Carta> mano = ObtenerManoJugador(codigo_jugadores);
        return mano.get(escoger);
    }

    public boolean TieneManoVacia(String codigo_jugadores) {
        return ObtenerManoJugador(codigo_jugadores).isEmpty();
    }

    public void setColorCarta(Carta.Color color) {
        ColorValido = color;
    }
    
    public void TurnoJugador(String codigo_jugadores) throws ExcepcionTurnoInvalidoJugador {
        Gestionar_Jugadores turno_jugador = new Gestionar_Jugadores();
        turno_jugador.TurnoJugador(codigo_jugadores);
    }
    
    public void submitDraws(String codigo_jugadores) throws ExcepcionTurnoInvalidoJugador {
        TurnoJugador(codigo_jugadores);

        if (baraja.EstaVacio()) {
            baraja.ReemplazarBaraja(Restantes);
            baraja.Mezclar();
        }

        ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
        if (DireccionJuego == false) {
            JugadorActual = (JugadorActual + 1) % CodigoJugadores.length;
        } else if (DireccionJuego == true) {
            JugadorActual = (JugadorActual - 1) % CodigoJugadores.length;
            if (JugadorActual == -1) {
                JugadorActual = CodigoJugadores.length - 1;
            }
        }
    }

}
