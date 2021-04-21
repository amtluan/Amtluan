
package LAB5;
import java.util.Scanner;

public class Student 
{
    private String code="" ,name="", Dbirth="";
    private int age=0;

    public Student() {
    }
    
    public Student(String c, String n, String D, int a)
    {
        code=c; name=n; Dbirth=D; age=a>0? a:0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbirth() {
        return Dbirth;
    }

    public void setDbirth(String Dbirth) {
        this.Dbirth = Dbirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void input()
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the student's code: ");
        code=s.nextLine();
        System.out.print("Enter the student's name: ");
        name=s.nextLine();
        System.out.print("Enter the studen's birth date: ");
        Dbirth=s.nextLine();
        System.out.print("Enter the student's age: ");
        age=Integer.parseInt(s.nextLine());
    }
    
    public String toString()
    {
        return code + "," + name + "," + Dbirth + "," + age;
    }
}

