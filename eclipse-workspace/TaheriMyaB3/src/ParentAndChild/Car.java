package ParentAndChild;

//inheritence
public class Car extends Vehicle
{
    private double insideArea;

    public Car()
    {
        //go to the method "above" > when in the child constructor, it will go to the parent constructor
        super();
        insideArea = 500.25;
    }

    public void greetings()
    {
        super.greetings();
        System.out.println("Hola ");
    }
}
