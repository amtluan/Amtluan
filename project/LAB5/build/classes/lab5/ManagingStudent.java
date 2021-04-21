package LAB5;
public class ManagingStudent 
{
    public static void main(String[] args) 
    {
        Menu menu=new Menu(5);
        menu.add("Add new student");
        menu.add("Remove a student");
        menu.add("Update a student");
        menu.add("List");
        menu.add("Quit");
        int choice;
        StudentList list=new StudentList(50);
        do 
        {            
            System.out.println("\nSTUDENT MANAGER");
            choice=menu.getChoice();
            switch(choice)
            {
                case 1: list.add(); break;
                case 2: list.remove(); break;
                case 3: list.update(); break;
                case 4: list.sort(); list.print();break;
            }
        } while (choice>=1 && choice <5);
    }
}