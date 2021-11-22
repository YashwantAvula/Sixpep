import java.util.*;
import java.util.ArrayList;

class Student
{
  //private String m_id;
  private String m_name;
  private int m_age;
  private String m_city;

  public Student(String name, int age, String city)
  {
    //m_id = id;
    m_name = name;
    m_age = age;
    m_city = city;
  }

}

class Main {

  private static int x= 0;

  private static ArrayList<Student> students = new ArrayList<Student>();

  


  public static void main(String[] args) {
    int n = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Student Management System \n1.Add   2.Update   3.Delete   4.View   5.Save & Quit ");
    int m = scan.nextInt();
    System.out.println("User has entered "+m);
    if(m==1)
    {  
      System.out.println("Full Name: ");
      String name = scan.next();
      int age = -1;
      do
      {
        try
        {
          age = Integer.parseInt(scan.nextLine());
        }
        catch (NumberFormatException e)
        {
          System.out.println("Enter Age: ");
        }
      }while (age<=0);

      System.out.println("City: ");
      String city = scan.nextLine();
      Student student = new Student(name, age, city);
      students.add(student);


      //printStudents(students);

    }
  }

  //System.out.println(students);
}
