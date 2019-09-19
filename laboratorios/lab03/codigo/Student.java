
package Laboratorio3;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class Student {
    //Class with the essential attributes of the student
    private String name, course, semester;
    private float grade;

    /**
     * 
     * Constructor of student
     *
     * @param name
     * @param course
     * @param semester
     * @param grade 
     */
    public Student(String name, String course, String semester, float grade) {
        this.name = name;
        this.course = course;
        this.semester = semester;
        this.grade = grade;
    }

    /**
     *
     * return name of student
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *  set student name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * return student course
     *
     * @return course
     */
    public String getCourse() {
        return course;
    }

    /**
     * 
     * set student course
     *
     * @param course 
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * 
     * return student semester
     *
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * 
     * set student semester
     *
     * @param semester 
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * 
     * return student grade
     *
     * @return grade
     */
    public float getGrade() {
        return grade;
    }

    /**
     * 
     * set student grade
     *
     * @param grade 
     */
    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    /**
     * 
     * @return student information
     */
    @Override
    public String toString() {
        return "Estudiante{" + "name=" + name + ", course=" + course + ", semester=" + semester + ", grade=" + grade + '}';
    }
}
