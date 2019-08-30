package Taller7;

import java.util.LinkedList;

public class Taller7 {

    /**
     *
     *
     * @param list
     * @param lista
     * @return el elemento máximo de la lista
     */
    public static int encontrarMax(LinkedList<Integer> list, LinkedList<Integer> lista){
        return encontrarMaxAux(0,lista);
    }

    /**
     *
     * @param index indice para recorrer la lista
     * @param lista
     * @return elemento máximo de la lista
     */
    private static int encontrarMaxAux(int index, LinkedList<Integer> lista){
        if(lista.size()==index){
            return 0;
        }else {
            return Math.max(lista.get(index), encontrarMaxAux(index+1,lista));
        }
    }

    /**
     *
     * @param lista1
     * @param lista2
     * @return verdad si las listas son iguales
     */
    public static boolean comparar(LinkedList<Integer> lista1, LinkedList<Integer> lista2){
        return comparar(0,lista1,lista2);
    }

    /**
     *
     * @param index indice para recorrer los arreglos
     * @param lista1
     * @param lista2
     * @return
     */
    private static boolean comparar(int index, LinkedList<Integer> lista1, LinkedList<Integer> lista2){
        if(lista1.size()!=lista2.size()){
            return false;
        }
        if(index==lista1.size()){
            return true;
        }else{
            return lista1.get(index).equals(lista2.get(index)) && comparar(index+1,lista1, lista2);
        }
    }
}
