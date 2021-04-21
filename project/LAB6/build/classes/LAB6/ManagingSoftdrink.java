package LAB6;
public class ManagingSoftdrink 
{
    public static void main(String[] args) 
    {
        Menu menu= new Menu(6);
        menu.add("Add new softdrink");
        menu.add("Remove as softdrink");
        menu.add("Update a softdrink");
        menu.add("Find a softdrink");
        menu.add("List");
        menu.add("Quit");
        int choice;
        SoftdrinkList list = new SoftdrinkList(50);
        do 
        {            
            System.out.println("\nSOFTDRINK MANAGER");
            choice=menu.getChoice();
            switch(choice)
            {
                case 1: list.add(); break;
                case 2: list.remove(); break;
                case 3: list.update(); break;
                case 4: list.printfind(); break;
                case 5: list.sortprice();
                        list.sortmake();
                        list.print();
                        break;
            }
        } while (choice>= 1 && choice <=5);
    }
}
