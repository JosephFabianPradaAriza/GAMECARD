/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA_CODIGO;

import java.util.Objects;

/**
 *
 * @author Joseph F
 */
public class Carta {
    
    enum Color{
        Rojo, Azul, Amarillo, Verde, Morado ;
        
        private  static final Color[] colores = Color.values();
        public static Color  getColor(int i){
            return Color.colores[i];
        }
    }
    
    enum Valor{
            Cero, Uno, Dos, Tres, Cuatro, Cinco, Seis, Siete, Ocho, Nueve, DrawDos, Saltar, Reversa, Wild, WildCuatro; 
        private  static final Valor[] valores  = Valor.values();
        public static Valor getValor(int i){
            return Valor.valores[i];
        }
    }
    
    private final Color color;
    private final Valor valor;
    
    public Carta(Color color, Valor valor){
        Objects.requireNonNull(color, "El color no puede ser nulo");
        Objects.requireNonNull(valor, "El valor no puede ser nulo");
        this.color = color;
        this.valor = valor;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public Valor getValor(){
        return this.valor;
    }
    @Override
    public String toString() {
        return "color=" + color + ", valor=" + valor;
    }
    
    public String getImagen(){
        return valor.toString() + "_" + color.toString() + ".png";
    }
    
}
