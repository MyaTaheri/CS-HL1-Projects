package ParentAndChild;

//inheritence - parent and child classes
//extend and super keywords
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

//encapsulation - private, protected, public
//the restriction of data for only classes and packages

//abstraction - hides the processes and the underlying working of the code
//examples: Math.random(), how a car starts