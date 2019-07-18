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
public class Punto {

    private double x, y;

    /**
     * Se inicializan las variables globales en el constructor de manera que no
     * posean valores nulos o 0s.
     */
    public Punto(double x, double y) {  
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
        return this.x;
    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
        return this.y;

    }

    /**
     * Método para obtener el radio polar, en este caso se puede obtener por
     * medio del teorema de pitágoras.
     *
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver
     * más <a/>
     */
    public double radioPolar() {
        double radioPolar= Math.sqrt(x*x+y*y);
        return radioPolar;
    }

    /**
     * Método para obtener el ángulo polar, en este caso se puede obtener por
     * medio de la tangente inversa.
     *
     *
     * @return angulo polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver
     * más <a/>
     */
    public double anguloPolar() {
        double anguloPolar = Math.atan(y/x)*(Math.PI/180);
        return anguloPolar;

    }

    /**
     * Método para obtener la distacia euclidiana. La distacia euclidiana o
     * euclídea es la distancia "ordinaria" (que se mediría con una regla) entre
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema
     * de Pitágoras. En otras palabras es halla el radio polar a la diferencia
     * entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con
     * es cual se desea comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver más <a/>
     */
    public double distanciaEuclidiana(Punto otro) {
        double distancia = Math.sqrt((x-otro.x)*(x-otro.x)+(y-otro.y)*(y-otro.y));
        distancia = Math.abs(distancia);
        return distancia;
    }
}
