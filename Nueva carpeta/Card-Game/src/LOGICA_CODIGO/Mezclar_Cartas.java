/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import java.util.Random;

/**
 *
 * @author Joseph F
 */
public class Mezclar_Cartas {
    public static void Mezclar_Cartas(Carta[] cartas){
        int n = cartas.length;
        Random random = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int ValorAleatorio = i + random.nextInt(n - 1);
            Carta CartaAleatoria = cartas[ValorAleatorio];
            cartas[ValorAleatorio] = cartas[i];
            cartas[i] = CartaAleatoria;
        }
    }
}
