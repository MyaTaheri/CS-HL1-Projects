package NumberCodes;

import java.util.Arrays;

public class BirthdayProblem 
{
    public static void main (String[] args)
    {
        //ARRAY OF ALL BDAYS WHICH IS REPRESENT IF IT IS TRUE BY A BOOLEAN
        // CHECK IF TWO HAVE THE SAME BDAY
        //IF U HAVE 23,  AND RUN IT 10,000, HOW MANY WILL HAVE THE SAME BDAY

        double count = 0;
        int numOfSimulation = 10000;

        for (int i = 0; i < numOfSimulation; i++)
        {
            if (simulation())  
                count++;
        }
        System.out.println(count);
        double percent = count / numOfSimulation * 100;
        System.out.println("Percent they have the same bday with 23 random people: " + percent);
        
    } 

    public static boolean simulation()
    {
        // Boolean[] dates = new Boolean[365];
        // for (int i =0; i < 365; i++)
        // {
        //     dates[i] = false;
        // }

        int[] birthday23 = new int[23];
        boolean hasDuplicates = false;

        for (int i = 0; i < 23; i++) {
            birthday23[i] = (int)(Math.random() * 365) + 1;
        }

        Arrays.sort(birthday23);

        for (int i = 0; i < birthday23.length - 1; i++) {
            if (birthday23[i] == birthday23[i + 1]) {
                hasDuplicates = true;
                break;
            }
        }
        return hasDuplicates;
    }
}
