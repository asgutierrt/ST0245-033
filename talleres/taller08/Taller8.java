package Taller8;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * La clase Taller8 tiene la intención de enfatizar en el uso de pilas y colas
 * ya implementadas en java
 *
 * @see
 * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver
 * más acerca de colas<a/>
 * @see
 * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver
 * más acerca de pilas <a/>
 * @author Mauricio Toro, Andrés Páez
 *
 * Students
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1
 */
public class Taller8 {

    /**
     * @param stack es una pila ya implementada que se crea en el test Este
     * método se encarga de poner la pila stack en orden inverso Nota: recuerde
     * que la funcion pop() no solo expulsa la última posición de una pila si no
     * que tambien devuelve su valor.
     * @return una pila que haga el inverso de stack
     */
    public static Stack<Integer> inversa(Stack<Integer> stack) {
        Stack<Integer> stackIn = new Stack<>();
        while(!stack.empty()){
            stackIn.push(stack.pop());
        }
        return stackIn;
    }

    /**
     * @param queue es una cola ya implementada que se crea en el test Este
     * método se encarga de atender a personas. Nota: Se debe imprimir en
     * consola a quién atiende y sacarlo de la cola existe una función "pull"
     * que hace el trabajo más fácil
     *
     */
    public static void cola(Queue<String> queue) {
        while(!queue.isEmpty()){
            System.out.println("Atendiendo a "+ queue.poll());
        }
    }

    /**
     * @param string es una cadena de texto que viene de este modo 3 4 5 * + o
     * de esta manera 2 3 * 5 + todo viene separado por espacios por lo que la
     * funcion split.("") vendría muy bien para separarlos Se intenta hacer el
     * calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
    public static int polaca(String string) {
        Stack<Integer> stack = new Stack<>();
        String digits[] = string.split(" ");
        int aux;
        for (int i = 0; i < digits.length; i++) {
            boolean operator = false;

            if (digits[i].length() == 1) {
                operator = (digits[i].charAt(0) == 42 || digits[i].charAt(0) == 43 || digits[i].charAt(0) == 45 || digits[i].charAt(0) == 47);
            }
            if (operator && stack.size() != 1) {
                int b = stack.pop();
                int a = stack.pop();
                if (digits[i].charAt(0) == 42) {
                    aux = a * b;
                    stack.push(aux);
                }
                if (digits[i].charAt(0) == 43) {
                    aux = a + b;
                    stack.push(aux);
                }
                if (digits[i].charAt(0) == 45) {
                    aux = a - b;
                    stack.push(aux);
                }
                if (digits[i].charAt(0) == 47) {
                    aux = a / b;
                    stack.push(aux);
                }
            } else {
                stack.push(Integer.parseInt(digits[i]));
            }
        }
        return stack.pop();
    }

}
