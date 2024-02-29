package ParentAndChild;

public class Vehicle 
{

    private String name;
    private int wheel;

    //polymorphism - multiple methods with the same name 
        //overloading - polymorphism but the parameters are different
        //overriding - within different classes trhough inheritence
            //the child method overides that parent class
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
