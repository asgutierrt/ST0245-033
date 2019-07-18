/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author SanHidalgo
 */
public class Fecha {
      /*
    varibales con atributo final indican que una variable es de tipo 
    constante, es decir, no admitirá cambios después de su declaración y asignación de valor.
    final determina que un atributo no puede ser sobreescrito o redefinido.
    Se le asigna esta característica para evitar que se sobrescriban valores.
    tener en cuenta tipado de las 3 variables!.
    */

    private final int dia;
    private final int mes;
    private final int anyo;


    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Fecha(int dia, int mes, int anyo) {   
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public int dia() {
        return this.dia;
    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public int mes() {
        return this.mes;

    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public int anio() {
        return this.anyo;

    }

    /**
    * @param otra representa la fecha con la culase va a comparar.
    *
    * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
    * 1: si la fecha es menor que la otra retorna -1.
    * 2: si la fecha es igual que la otra retorna 0.
    * 3: si la fecha es mayor que la otra retorna 1.
    *
    * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
    *
    */

    public int comparar(Fecha otra) {
        String fecha1= Integer.toString(anyo)+Integer.toString(mes)+Integer.toString(dia);
        String fecha2 = Integer.toString(otra.anyo)+Integer.toString(otra.mes)+Integer.toString(otra.dia);
        int diferencia = fecha1.compareTo(fecha2);
        return diferencia;
    }


     /**
    * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
    * para su posterior visualización
    *
    * @return una cadena que contiene la fecha
    */
    public String toString() {
        return dia + " de "+ mes+" del "+anyo;
        
    }
}
