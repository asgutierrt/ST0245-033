package Laboratorio3;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
/**
 * Class with methods focused on user interaction
 */
public class Menu {

    /**
     *
     * request type of inquiry
     *
     * @throws FileNotFoundException
     */
    public static void tipoConsulta() throws FileNotFoundException {
        System.out.println("********************************************************************************************");
        System.out.println("- Consulta 1: ");
        System.out.println("    Dado un curso (por ejemplo, Estructuras de Datos 1) y un semestre del\n"
                + "    año (por ejemplo 2016-2), obtener todos los estudiantes matriculados y la nota final\n"
                + "    de cada uno.");
        System.out.println("\n- Consulta 2");
        System.out.println("    Dado un estudiante y un semestre del año, obtener todos los cursos que\n"
                + "    matriculó y la nota que obtuvo en cada uno de ellos.");
        System.out.print("\nCúal consulta desea ejecutar? (Digite 1 ó 2 según sea el caso): ");
        int tipoConsulta = solicitarTipoConsulta();

        if (tipoConsulta == 1) {
            menuConsulta1();
        } else {
            menuConsulta2();
        }
    }

    /**
     *
     * Interact with the user in the query type request
     *
     * @return option
     */
    public static int solicitarTipoConsulta() {
        Scanner input = new Scanner(System.in);
        int tipoConsulta = 0;
        try {
            do {
                tipoConsulta = input.nextInt();
                if (tipoConsulta != 1 && tipoConsulta != 2) {
                    System.out.print("¡ERROR! Ingrese una opción válida. (1 ó 2): ");
                }
            } while (tipoConsulta != 1 && tipoConsulta != 2);
            return tipoConsulta;
        } catch (Exception e) {
            System.out.print("¡ERROR! Ingrese una opción válida. (1 ó 2): ");
            solicitarTipoConsulta();
        }
        return 0;
    }
    
    /**
     *
     * Request query options 1
     *
     * @throws FileNotFoundException
     */
    public static void menuConsulta1() throws FileNotFoundException {
        System.out.println("\nCursos disponibles: ");
        System.out.println(" 1. Fundamentos de Programación");
        System.out.println(" 2. Estructuras Datos y Algoritmos 1");
        System.out.println(" 3. Estructuras Datos Y Algortimos 2");
        System.out.print("Digite el número de la opción que desea (1-3): ");
        int curso = solicitarCurso();
        System.out.print("Digite año y semestre juntos (Ejemplo: 20182): ");
        int semester = requestSemester();
        String semesterS = Integer.toString(semester);
        LinkedList<Student> listStudents = Operations.readFile(curso);
        Operations.filter(listStudents, semesterS);
    }

    /**
     *
     * Request courses
     *
     * @return course
     */
    public static int solicitarCurso() {
        Scanner input = new Scanner(System.in);
        int curso = 0;
        try {
            do {
                curso = input.nextInt();
                if (curso != 1 && curso != 2 && curso != 3) {
                    System.out.print("¡ERROR! Ingrese una opción válida. (1-3): ");
                }
            } while (curso != 1 && curso != 2 && curso != 3);
            return curso;
        } catch (Exception e) {
            System.out.print("¡ERROR! Ingrese una opción válida. (1-3): ");
            solicitarCurso();
        }
        return 0;
    }

    /**
     * 
     * Request semester
     *
     * @return semester
     */
    public static int requestSemester() {
        Scanner input = new Scanner(System.in);
        int semester;
        int digitos;
        try {
            do {
                semester = input.nextInt();
                digitos = (int) (Math.log10(semester) + 1);
               if(digitos !=5 || (semester%10 != 1 && semester%10 != 2 ))
                    System.out.println("¡ERROR!. Digite una opción válida: ");
            } while(digitos !=5 || (semester%10 != 1 && semester%10 != 2) );
            return semester;
        } catch (Exception e) {
            System.out.println("¡ERROR!. Digite una opción válida: ");
             requestSemester();
        }
        return 0;
    }

    /**
     *
     * Request query menu options 2
     *
     * @throws FileNotFoundException
     */
    public static void menuConsulta2() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDigite nombre del estudiante (Sin tíldes): ");
        String name = input.nextLine();
        System.out.print("Digite año y semestre juntos (Ejemplo: 20182): ");
        int semester = requestSemester();
        String semesterS = Integer.toString(semester);
        Operations.printCourses(name, semesterS);
    }
    
}
