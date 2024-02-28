package ParentAndChild;

public class Vehicle 
{

    private String name;
    private int wheel;

    //polymorphism - multiple methods with the sname name but different parameters
    public Vehicle()
    {
        //default case
        name = "name";
        wheel = 20;
    }

    public Vehicle (String name, int wheel)
    {
        this.name = name;
        this.wheel = wheel;
    }

    public void greetings ()
    {
        System.out.println("Hello " + name);
    }


    
}
