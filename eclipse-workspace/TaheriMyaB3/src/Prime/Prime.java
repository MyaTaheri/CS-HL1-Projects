package Prime;

public class Prime {
    
    public static void main (String[] args)
    {
        int num = 1474747;
        int primeSum = 0;
        for (int i = 2; i < num; i++)
        {
            if (checkPrime(i))
            {
                primeSum += i;
                System.out.println("prime sum: " + primeSum + "   i: " +  i);
            }
        }
        System.out.println(primeSum);
    }

    public static boolean checkPrime(int num)
    {
        for (int i = 2; i < (int)(Math.sqrt(num) + 1); i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}

