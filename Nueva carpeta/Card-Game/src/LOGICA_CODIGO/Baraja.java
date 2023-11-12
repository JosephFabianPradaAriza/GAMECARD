/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import LOGICA_CODIGO.Carta;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Joseph F
 */
public class Baraja {

    private Carta[] cartas;
    private int CartasBaraja;

    public void Reiniciar_Baraja() {
        Reiniciar_Baraja reiniciarBaraja = new Reiniciar_Baraja();
        reiniciarBaraja.reiniciar_mi_Baraja();
    }

    public void ReemplazarBaraja(ArrayList<Carta> cartas) {
        this.cartas = cartas.toArray(new Carta[cartas.size()]);
    }

    public boolean EstaVacio() {
        return cartas.length == 0;
    }

    public void Mezclar() {
        Mezclar_Cartas.Mezclar_Cartas(cartas);
    }

    public Carta TomarCarta() {
        TomarCarta tomar = new TomarCarta();
        tomar.tomar_carta();
        return null;
    }

    public ImageIcon drawCardImage() throws IllegalArgumentException {
        if (EstaVacio()) {
            throw new IllegalArgumentException("No se puede robar una carta porque la baraja está vacía.");
        }
        Carta cartaRobada = cartas[--CartasBaraja];
        return Generar_Imagenes.generarImagen(cartaRobada);
    }

    public Carta[] drawCard(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Deben de robarse cartas positivas, se intento adquirir" + n + " cartas.");
        }
        if (n > CartasBaraja) {
            throw new IllegalArgumentException("No se pueden robar " + n + " cartas, solo hay " + CartasBaraja + " disponibles.");
        }

        Carta[] ret = new Carta[n];

        for (int i = 0; i < n; i++) {
            ret[i] = cartas[--CartasBaraja];
        }
        return ret;
    }

}
