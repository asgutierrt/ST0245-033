package Laboratorio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class Operations {

    /**
     *
     * @param course
     * @return Students of the course
     * @throws FileNotFoundException
     */
    public static LinkedList<Student> readFile(int course) throws FileNotFoundException {
        String fileName = "";
        if (course == 1) {
            fileName = "NOTAS ST0242";
        }
        if (course == 2) {
            fileName = "NOTAS ST0245";
        }
        if (course == 3) {
            fileName = "NOTAS ST0247";
        }
        LinkedList<Student> listStudent = converter(read(fileName));
        LinkedList<Student> listStudents = purify(listStudent);
        return listStudents;
    }

    /**
     *
     * @param Filename
     * @return basic information
     * @throws FileNotFoundException
     */
    public static LinkedList<String> read(String Filename) throws FileNotFoundException {
        LinkedList<String> informationLines = new LinkedList<>();
        String ruta = "./archivo/" + Filename + ".csv";
        File file = new File(ruta);
        Scanner input = new Scanner(file);

        int cont = 0; //Contador para determinar cantidad de datos

        while (input.hasNext()) {
            String line = input.nextLine();
            informationLines.add(line);
            cont++;
        }
        return informationLines;
    }

    /**
     *
     * @param list
     * @return list of Students
     */
    public static LinkedList<Student> converter(LinkedList<String> list) {
        LinkedList<Student> listStudent = new LinkedList<>();
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).equals("")) {
                list.remove(0);
            }
            String name, course, semester;
            int grade;
            String temp = list.get(0);
            String[] arrayTemp = temp.split(",");
            name = quitaDiacriticos(arrayTemp[0]);
            course = arrayTemp[10];
            semester = arrayTemp[3];
            if (arrayTemp.length == 15) {
                grade = (int) Float.parseFloat(arrayTemp[14]);
            } else {
                grade = (int) Float.parseFloat(arrayTemp[13]);
            }
            list.remove(0);
            Student student = new Student(name, course, semester, grade);
            listStudent.add(student);
            i--;
        }
        return listStudent;
    }

    /**
     *
     * @param listStudent
     * @return list of students purify
     */
    public static LinkedList<Student> purify(LinkedList<Student> listStudent) {
        int tam = listStudent.size() - 1;
        for (int i = 0; i < tam; i++) {
            boolean c = listStudent.get(i).getName().equals(listStudent.get(i + 1).getName());
            if (c) {
                listStudent.remove(i);
                i--;
                tam--;
            }
        }
        return listStudent;
    }

    /**
     *
     * @param listStudent
     * @param semester
     */
    public static void filter(LinkedList<Student> listStudent, String semester) {
        int tam = listStudent.size();
        System.out.println("\nLos estudiantes del semestre " + semester + " del curso de "
                + listStudent.get(0).getCourse() + " son: ");
        System.out.println("Estudiante: Nota Definitiva");
        for (int i = 0; i < tam; i++) {
            if (listStudent.get(i).getSemester().equals(semester)) {
                System.out.println(listStudent.get(i).getName() + ": " + listStudent.get(i).getGrade());
            } else {
                listStudent.remove();
                i--;
                tam--;
            }
        }
    }

    /**
     *
     * @param nameStudent
     * @param semester
     * @throws FileNotFoundException
     */
    public static void printCourses(String nameStudent, String semester) throws FileNotFoundException {
        LinkedList<Student> listStudent1 = readFile(1);
        LinkedList<Student> listStudent2 = readFile(2);
        LinkedList<Student> listStudent3 = readFile(3);
        System.out.println(nameStudent + " ha realizado los siguientes cursos: ");
        search(listStudent1, nameStudent);
        search(listStudent2, nameStudent);
        search(listStudent3, nameStudent);
    }

     /**
     * 
     * @param listStudent
     * @param nameStudent 
     */
    public static void search(LinkedList<Student> listStudent, String nameStudent) {
        int tam = listStudent.size();
        for (int i = 0; i < tam; i++) {
            if (listStudent.get(0).getName().equals(nameStudent)) {
                System.out.println(listStudent.get(0).getCourse() + ": " + listStudent.get(0).getGrade());
                break;
            } else {
                listStudent.remove();
                i--;
                tam--;
            }
        }
    }

    /**
     * 
     * Title: quitaDiacriticos
     * Author: Jorge Salamanca
     * Date: 21 June 2018
     * Availability: https://es.stackoverflow.com/questions/31178/c%C3%B3mo-limpiar-string-de-tildes-en-java
     * 
     * @param s
     * @return name without tildes
     */
    public static String quitaDiacriticos(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

}
