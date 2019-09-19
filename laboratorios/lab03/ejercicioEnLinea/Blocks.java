package Laboratorio3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class Blocks {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite un n (0 < n < 25): ");
        int n = input.nextInt();
        Stack<Integer>[] stacks = new Stack[n];
        //
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
            stacks[i].push(i);
        }
        System.out.println(Arrays.toString(stacks)); //Stack
      
        String command = "";
        int c = 0;
        do {
            if (!command.equals("quiet") && c >= 2) {
                String arrayCommand[] = command.split(" ");
                if (arrayCommand.length == 4) {
                    int option1, option2, blocka, blockb;

                    if (arrayCommand[2].equals("onto")) {
                        option2 = 1;
                    } else if (arrayCommand[2].equals("over")) {
                        option2 = 2;
                    } else {
                        option2 = 0;
                    }
                    if (arrayCommand[0].equals("move")) {
                        option1 = 1;
                    } else if (arrayCommand[0].equals("pile")) {
                        option1 = 2;
                    } else {
                        option1 = 0;
                    }

                    blocka = Integer.parseInt(arrayCommand[1]);
                    blockb = Integer.parseInt(arrayCommand[3]);
                    stacks = procesar(stacks, option1, option2, blocka, blockb);
                }
            } else {

            }
            c++;
            System.out.print("Digite comando: ");
            command = input.nextLine();
        } while (!command.equals("quiet"));
        
        for (int i = 0; i < stacks.length; i++) {
            System.out.println(i+":"+stacks[i].toString());
        }
    }

    /**
     * 
     * @param stacks
     * @param option1
     * @param option2
     * @param a
     * @param b
     * @return stacks processed after a command
     */
    public static Stack<Integer>[] procesar(Stack<Integer>[] stacks, int option1, int option2, int a, int b) {
        //Command move a onto b
        if (option1 == 1 && option2 == 1) {
            return p1(stacks, a, b);
        }
        //Command move a over b
        if (option1 == 1 && option2 == 2) {
            return p2(stacks, a, b);
        }
        //Command pile a over b
        if (option1 == 2 && option2 == 2) {
            return p4(stacks, a, b);
        }

        return stacks;
    }

    /**
     * 
     * @param stacks
     * @param a
     * @param b
     * @return stacks processed after the move a onto b command
     */
    public static Stack<Integer>[] p1(Stack<Integer>[] stacks, int a, int b) {
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(a)) {
                stacks[i] = removeryActualizar(stacks[i], a);
            }
        }

        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(b)) {
                stacks[i] = montar(stacks[i], a, b);
            }
        }
        return stacks;
    }

    /**
     * 
     * @param stack
     * @param a
     * @return Stack without block a
     */
    public static Stack<Integer> removeryActualizar(Stack<Integer> stack, int a) {
        Stack<Integer> auxiliar = new Stack<>();
        while (!stack.empty()) {
            auxiliar.push(stack.pop());
        }
        while (!auxiliar.empty()) {
            if (auxiliar.peek() != a) {
                stack.push(auxiliar.pop());
            } else {
                auxiliar.pop();
            }
        }
        return stack;
    }

    /**
     * 
     * @param stack
     * @param a
     * @param b
     * @return Stack update
     */
    public static Stack<Integer> montar(Stack<Integer> stack, int a, int b) {
        Stack<Integer> auxiliar = new Stack<>();
        while (stack.peek() != b) {
            auxiliar.push(stack.pop());
        }
        stack.push(a);
        while (!auxiliar.empty()) {
            stack.push(auxiliar.pop());
        }
        return stack;
    }

    /**
     * 
     * @param stacks
     * @param a
     * @param b
     * @return stacks processed after the move a over b command 
     */
    public static Stack<Integer>[] p2(Stack<Integer>[] stacks, int a, int b) {
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(a)) {
                stacks[i] = removeryActualizar(stacks[i], a);
            }
        }

        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(b)) {
                stacks[i] = añadir(stacks[i], a);
            }
        }
        return stacks;
    }

    /**
     * 
     * @param stack
     * @param a
     * @return Stack update
     */
    public static Stack<Integer> añadir(Stack<Integer> stack, int a) {
        stack.push(a);
        return stack;
    }

    /**
     * 
     * @param stacks
     * @param a
     * @param b
     * @return  stacks processed after the pile a over b command
     */
    public static Stack<Integer>[] p4(Stack<Integer>[] stacks, int a, int b) {
        Stack<Integer> aux = new Stack<>();
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(a)) {
                aux = pilaParaMontar(stacks[i], a);
            }
        }
        
        for (int i = 0; i < stacks.length; i++) {
            if (i==b) {
                stacks[i] = montar(stacks[i], aux);
                System.out.println(stacks[i].toString());
            }
        }
        
        return stacks;
    }

    /**
     * 
     * @param stack
     * @param a
     * @return Stack update
     */
    public static Stack<Integer> pilaParaMontar(Stack<Integer> stack, int a) {
        Stack<Integer> auxiliar = new Stack<>();
        while (stack.peek() != a) {
            auxiliar.push(stack.pop());
        }
        auxiliar.push(stack.pop());
        return auxiliar;
    }

    public static Stack<Integer> montar(Stack<Integer> stack, Stack<Integer> aux) {
        while(!aux.empty()){
            stack.push(aux.pop());
        }
        return stack;
    }

}
