//13.13(使Course类可克隆)
import java.util.*;

public class Exercise13_13 {
  /** Main method */
  public static void main(String[] args) {
    Course course1 = new Course("DS");
    course1.addStudent("WL");
    course1.addStudent("LH");
    Course course2 = (Course) course1.clone();
    course2.addStudent("XM");
    course2.addStudent("FF");
    System.out.println("二者是否相等：");
    System.out.println(course1 == course2);
    System.out.println(course1.getNumberOfStudents());
    System.out.println(course2.getNumberOfStudents());
  }
}

class Course implements Cloneable {
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
  }// 构造函数

  public void addStudent(String student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
  }// 增加学生

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }// 获得班内学生数

  public String getCourseName() {
    return courseName;
  }// 获得班名

  public void dropStudent(String student) {

  }// 剔除学生

  public Object clone() {
    try {
      Course newCourse = (Course) super.clone();
      newCourse.students = this.students;
      newCourse.numberOfStudents = numberOfStudents;
      return newCourse;
    } catch (CloneNotSupportedException ex) {
      return null;
    }
  }// 深拷贝

}