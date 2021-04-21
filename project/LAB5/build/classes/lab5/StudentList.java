package LAB5;
import java.util.Scanner;

public class StudentList 
{
    private  Student[] list=null;
    private int count=0;
    public StudentList(int size)
    {
        if (size<10) size=10;
        list= new Student[size];
    }
    
    int find (String aCode)
    {
        for (int i=0; i<count; i++)
            if (aCode.equals(list[i].getCode())) return i;
        return -1;
    }
    
    public void add()
    {
        if (count==list.length) System.out.println("List is full!");
        else
        {
            String newCode ,newName, newDbirth; int newAge=0,newIntCode=0;
            boolean cont = true;
            Scanner s= new Scanner(System.in);
            int pos;
            do 
            {
                do
                {
                    try
                    {
                        System.out.print("Enter the student's code: ");
                        newIntCode = Integer.parseInt(s.nextLine());
                        if (newIntCode<1 || newIntCode>999)
                        {
                            System.out.println("Code >=1 and Code <=999");
                            cont = true;
                        } else {
                            cont = false;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Something went wrong.");
                        cont = true;
                    }
                }while(cont == true);
                newCode = DecimalFormatDemo.setCodeFormat("P000",newIntCode);
                pos=find(newCode);
                if (pos>=0) System.out.println("\tThis code existed!");    
            } while (pos>=0);
            System.out.print("Enter the student's name: ");
            newName=s.nextLine().toUpperCase();
            System.out.print("Enter the student's birth date: ");
            newDbirth=s.nextLine().toUpperCase();
            do
            {
                try
                {
                    System.out.print("Enter the student's age: ");
                    newAge = Integer.parseInt(s.nextLine());
                    if (newAge<=0)
                    {
                        System.out.println("The Age > 0");
                        cont = true;
                    } else {
                        cont = false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont == true);
            
            list[count++]=new Student(newCode, newName, newDbirth, newAge );
            System.out.println("New student have been added");
        }
    }
    
    public void remove()
    {
        if (count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        String removeCode;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the code of removed student: ");
        removeCode=s.nextLine().toUpperCase();
        int pos=find(removeCode);
        if (pos<0) System.out.println("This Student does not exist.");
        else
        {
            for (int i=pos; i<count-1; i++) list[i]=list[i+1];
            count--;
            System.out.println("The student " + removeCode + " was removed");
        }
    }
    
    public void update()
    {
        if (count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        String code;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the code of updated student: ");
        code=s.nextLine().toUpperCase();
        int pos= find(code);
        if (pos<0) System.out.println("This student does not exist.");
        else
        {
            String newName, newDbirth; int newAge=0;
            boolean cont=true;
            System.out.print("Enter the student's name: ");
            newName=s.nextLine().toUpperCase();
            System.out.print("Enter the student's birth date: ");
            newDbirth=s.nextLine().toUpperCase();
            do
            {
                try
                {
                    System.out.print("Enter the student's age: ");
                    newAge = Integer.parseInt(s.nextLine());
                    if (newAge<=0)
                    {
                        System.out.println("The Age > 0");
                        cont = true;
                    } else {
                        cont = false;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Something went wrong.");
                    cont = true;
                }
            }while(cont == true);
            
            list[pos].setName(newName);
            list[pos].setDbirth(newDbirth);
            list[pos].setAge(newAge);
            System.out.println("The student " + code + " was updated");
        }
        
    }
    
    public void print()
    {
        if (count==0)
        {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("LIST OF STUDENT:");
        for (int i=0; i<count; i++)
            System.out.println(list[i].toString());
    }
    
    void sort()
    {
        if (count==0) return;
        
        for(int i=0; i<count-1; i++)
            for (int j=count-1; j>i; j--)
                if (list[j].getAge()>list[j-1].getAge())
                {
                    Student p= list[j];
                    list[j]=list[j-1];
                    list[j-1]=p;
                }
    }
}
