package ParentAndChild;

public class VehicleDriver
{
    public static void main (String[] args)
    {
        Vehicle v1 = new Vehicle();
        v1.greetings();

        Vehicle v2 = new Vehicle("jeep", 4);
        v2.greetings();

        Car c1 = new Car();
        c1.greetings();

        Vehicle c2 = new Car();
        c2.greetings();

        //Will NOT work
        // Car c2 = new Vehcile();
        // c2.greetings();
    }
    
}