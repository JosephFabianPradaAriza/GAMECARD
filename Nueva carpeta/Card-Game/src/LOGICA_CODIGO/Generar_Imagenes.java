/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import javax.swing.ImageIcon;

/**
 *
 * @author Joseph F
 */
public class Generar_Imagenes{
    
    public static ImageIcon generarImagen(Carta carta) {
        return new ImageIcon(carta.toString() + ".png");
    }
}
