package decorator_Pattern;
public class Quit extends Menu{
    
    public void Display()
    {
        System.out.println("Exiting the game...");
        System.exit(1);
    }

}
