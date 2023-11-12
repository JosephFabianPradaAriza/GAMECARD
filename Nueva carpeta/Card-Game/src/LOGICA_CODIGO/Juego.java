/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph F
 */
public class Juego {

    private int JugadorActual;
    private String[] CodigoJugadores;

    private Baraja baraja;
    private ArrayList<ArrayList<Carta>> ManoJugador;
    private ArrayList<Carta> Restantes;

    private Carta.Color ColorValido;
    private Carta.Valor ValorValido;

    boolean DireccionJuego;

    public Juego(String[] codigo_jugadores) {
        baraja = new Baraja();
        baraja.Mezclar();
        Restantes = new ArrayList<Carta>();

        CodigoJugadores = codigo_jugadores;
        JugadorActual = 0;
        DireccionJuego = false;

        ManoJugador = new ArrayList<ArrayList<Carta>>();

        for (int i = 0; i < codigo_jugadores.length; i++) {
            ArrayList<Carta> mano = new ArrayList<Carta>(Arrays.asList(baraja.drawCard(7)));
            ManoJugador.add(mano);
        }
    }

    public void iniciar(Juego juego) {
        Carta carta = baraja.TomarCarta();
        ColorValido = carta.getColor();
        ValorValido = carta.getValor();

        if (carta.getValor() == Carta.Valor.Wild) {
            iniciar(juego);
        }

        if (carta.getValor() == Carta.Valor.WildCuatro || carta.getValor() == Carta.Valor.DrawDos) {
            iniciar(juego);
        }

        if (carta.getValor() == Carta.Valor.Saltar) {
            JLabel message = new JLabel(CodigoJugadores[JugadorActual] + " a salido!");
            message.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, message);

            if (DireccionJuego == false) {
                JugadorActual = (JugadorActual + 1) % CodigoJugadores.length;
            } else if (DireccionJuego == true) {
                JugadorActual = (JugadorActual - 1) % CodigoJugadores.length;
                if (JugadorActual == -1) {
                    JugadorActual = CodigoJugadores.length - 1;
                }
            }
        }

        if (carta.getValor() == Carta.Valor.Reversa) {
            JLabel message = new JLabel(CodigoJugadores[JugadorActual] + " La direccion del juego a cambiado!!");
            message.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, message);
            DireccionJuego ^= true;
            JugadorActual = CodigoJugadores.length - 1;
        }
        Restantes.add(carta);
    }

    public boolean isGameOver() {
        for (String jugador : this.CodigoJugadores) {
            if (TieneManoVacia(jugador)) {
                return true;
            }
        }
        return false;
    }

    public Carta ObtenerCartaSuperior() {
        Gestionar_Cartas carta_superior = new Gestionar_Cartas();
        carta_superior.ObtenerCartaSuperior();
        return null;
    }

    public ImageIcon ObtenerImagenCartaSuperior() {
        Gestionar_Cartas imagen_carta_superior = new Gestionar_Cartas();
        return imagen_carta_superior.ObtenerImagenCartaSuperior();
    }

    public String ObtenerJugadorActual() {
        Gestionar_Jugadores gestion_de_jugadores = new Gestionar_Jugadores();
        return gestion_de_jugadores.ObtenerJugadorActual();
    }

    public String ObtenerJugadorPrevio() {
        Gestionar_Jugadores jugador_previo = new Gestionar_Jugadores();
        return jugador_previo.ObtenerJugadorPrevio(JugadorActual);
    }

    public String[] ObtenerJugadores() {
        Gestionar_Jugadores jugadores = new Gestionar_Jugadores();
        return jugadores.ObtenerJugadores();
    }

    public ArrayList<Carta> ObtenerManoJugador(String codigo_jugadores) {
        Gestionar_Cartas jugadores = new Gestionar_Cartas();
        return jugadores.ObtenerManoJugador(codigo_jugadores);
    }

    public Carta ObtenerCartaJugador(String codigo_jugadores, int escoger) {
        Gestionar_Cartas carta_jugador = new Gestionar_Cartas();
        return carta_jugador.ObtenerCartaJugador(codigo_jugadores, escoger);
    }

    public boolean TieneManoVacia(String codigo_jugadores) {
        Gestionar_Cartas mano_vacia = new Gestionar_Cartas();
        return mano_vacia.TieneManoVacia(codigo_jugadores);
    }

    public boolean CartaValida(Carta carta) {
        return carta.getColor() == ColorValido || carta.getValor() == ValorValido;
    }

    public void TurnoJugador(String codigo_jugadores) throws ExcepcionTurnoInvalidoJugador {
        Gestionar_Jugadores turno_jugador = new Gestionar_Jugadores();
        turno_jugador.TurnoJugador(codigo_jugadores);
    }

    public void SetColorCarta() {
        Gestionar_Cartas color_carta = new Gestionar_Cartas();
        color_carta.setColorCarta(ColorValido);
    }
    
    public void EnviarCartaJugador(String codigo_jugadores, Carta carta, Carta.Color ColorDeclarado)
            throws ExcepcionTurnoInvalidoJugador, ExcepcionEnvioColorInvalido, ExcepcionEnvioValorInvalidoEnviado {
        TurnoJugador(codigo_jugadores);

        ArrayList<Carta> Mano = ObtenerManoJugador(codigo_jugadores);

        if (!CartaValida(carta)) {
            if (carta.getColor() == Carta.Color.Morado) {
                ColorValido = carta.getColor();
                ValorValido = carta.getValor();
            }

            if (carta.getColor() != ColorValido) {
                JLabel mensaje = new JLabel("Movimiento invalido, color esperado: " + ColorValido + " pero se obtuvo " + carta.getColor());
                mensaje.setFont(new Font("Arial", Font.BOLD, 18));
                String message = mensaje.getText();
                JOptionPane.showMessageDialog(null, mensaje);
                throw new ExcepcionEnvioColorInvalido(message, carta.getColor(), ColorValido);
            } else if (carta.getValor() != ValorValido) {
                JLabel mensaje = new JLabel("Movimiento invalido, valor esperado: " + ValorValido + " pero se obtuvo " + carta.getValor());
                mensaje.setFont(new Font("Arial", Font.BOLD, 18));
                String message2 = mensaje.getText();
                JOptionPane.showMessageDialog(null, mensaje);
                throw new ExcepcionEnvioValorInvalidoEnviado(message2, carta.getValor(), ValorValido);
            }
        }

        Mano.remove(carta);

        if (TieneManoVacia(this.CodigoJugadores[JugadorActual])) {
            JLabel mensaje = new JLabel(this.CodigoJugadores[JugadorActual] + " a ganado!");
            mensaje.setFont(new Font("Arial", Font.BOLD, 18));
            String message2 = mensaje.getText();
            JOptionPane.showMessageDialog(null, mensaje);
            System.exit(0);
        }

        ColorValido = carta.getColor();
        ValorValido = carta.getValor();
        Restantes.add(carta);

        if (DireccionJuego == false) {
            JugadorActual = (JugadorActual + 1) % CodigoJugadores.length;
        } else if (DireccionJuego == true) {
            JugadorActual = (JugadorActual - 1) % CodigoJugadores.length;
            if (JugadorActual == -1) {
                JugadorActual = CodigoJugadores.length - 1;
            }
        }

        if (carta.getColor() == Carta.Color.Morado) {
            ColorValido = ColorDeclarado;
        }

        if (carta.getValor() == Carta.Valor.DrawDos) {
            codigo_jugadores = CodigoJugadores[JugadorActual];
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            JLabel mensaje = new JLabel(codigo_jugadores + " a tomado 2 cartas.");
        }

        if (carta.getValor() == Carta.Valor.WildCuatro) {
            codigo_jugadores = CodigoJugadores[JugadorActual];
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            ObtenerManoJugador(codigo_jugadores).add(baraja.TomarCarta());
            JLabel mensaje = new JLabel(codigo_jugadores + " a tomado 4 cartas.");
        }

        if (carta.getValor() == Carta.Valor.Saltar) {
            JLabel mensaje = new JLabel(CodigoJugadores[JugadorActual] + " a sido saltado!");
            mensaje.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, mensaje);
            if (DireccionJuego == false) {
                JugadorActual = (JugadorActual + 1) % CodigoJugadores.length;
            } else if (DireccionJuego == true) {
                JugadorActual = (JugadorActual - 1) % CodigoJugadores.length;
                if (JugadorActual == -1) {
                    JugadorActual = CodigoJugadores.length - 1;
                }
            }
        }

        if (carta.getValor() == Carta.Valor.Reversa) {
            JLabel mensaje = new JLabel(codigo_jugadores + " a sido saltado!");
            mensaje.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, mensaje);

            DireccionJuego ^= true;
            if (DireccionJuego == true) {
                JugadorActual = (JugadorActual - 2) % CodigoJugadores.length;
                if (JugadorActual == -1) {
                    JugadorActual = CodigoJugadores.length - 1;
                }

                if (JugadorActual == -2) {
                    JugadorActual = CodigoJugadores.length - 2;
                }
            } else if (DireccionJuego == false) {
                JugadorActual = (JugadorActual + 2) % CodigoJugadores.length;
            }
        }
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


