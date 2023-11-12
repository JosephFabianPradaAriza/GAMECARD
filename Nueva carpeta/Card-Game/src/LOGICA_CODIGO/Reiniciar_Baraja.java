/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

/**
 *
 * @author Joseph F
 */
public class Reiniciar_Baraja {

    private final Carta[] cartas;
    private int CartasBaraja;

    public Reiniciar_Baraja() {
        cartas = new Carta[108];
    }

    public void reiniciar_mi_Baraja() {

        Carta.Color[] colores = Carta.Color.values();
        int CartasBaraja = 0;

        for (int i = 0; i < colores.length - 1; i++) {
            Carta.Color color = colores[i];
            cartas[CartasBaraja++] = Generar_Cartas.crearCarta(color, Carta.Valor.getValor(0));

            for (int j = 0; j < 10; j++) {
                cartas[CartasBaraja++] = Generar_Cartas.crearCarta(color, Carta.Valor.getValor(j));
                cartas[CartasBaraja++] = Generar_Cartas.crearCarta(color, Carta.Valor.getValor(j));
            }

            Carta.Valor[] valores = new Carta.Valor[]{Carta.Valor.DrawDos, Carta.Valor.Saltar, Carta.Valor.Reversa};
            for (Carta.Valor valor : valores) {
                cartas[CartasBaraja++] = Generar_Cartas.crearCarta(color, valor);
                cartas[CartasBaraja++] = Generar_Cartas.crearCarta(color, valor);
            }
        }

        Carta.Valor[] valores = new Carta.Valor[]{Carta.Valor.DrawDos, Carta.Valor.Saltar, Carta.Valor.Reversa};
        for (Carta.Valor valor : valores) {
            for (int i = 0; i < 2; i++) {
                cartas[CartasBaraja++] = Generar_Cartas.crearCarta(Carta.Color.Morado, valor);
            }
        }
    }
}
