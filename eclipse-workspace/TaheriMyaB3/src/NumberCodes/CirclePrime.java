package NumberCodes;

//How many circle primes less than 500,000

//another possible solution, check all primes and then see if they are a circle prime
public class CirclePrime
{
    public static void main (String[] args)
    {
        int maxNum = 500000;
        int counter = 0;
       
        for (int i = 2; i < maxNum; i++)
        {
            if (checkPrime(i) && checkCircle(i))
            {
                counter++;
                System.out.println(i);
            }
        }
        counter += 1; // to adjust for the fact 2 is not included
        System.out.println("Cirle Primes Num: " + counter);
       
        
    }

    public static boolean checkCircle(int num)
    {
        if (!(hasDigit(num, 0) || hasDigit(num, 2) || hasDigit(num, 4) || hasDigit(num, 6) || hasDigit(num, 8)))
        {
            int length = String.valueOf(num).length();
            String[] possibleNums = new String[length];
            String temp = shuffleNums(num);
            possibleNums[0] = temp;

            for (int i = 1; i < length; i++)
            {
                temp = shuffleNums(Integer.parseInt(temp));
                possibleNums[i] = temp;
            }

            for (int i = 0; i < length; i++)
            {
                if (!(checkPrime(Integer.parseInt(possibleNums[i]))))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean hasDigit(int num, int digit) {
        int rem;
        while (num > 0) {
            rem = num % 10;
            if (rem == digit)
                return true;
            num = num / 10;
        }
        return false;
    }

    public static String shuffleNums(int num)
    {
        String strNum = String.valueOf(num);
        strNum = strNum.substring(1, strNum.length())  + strNum.substring(0, 1);
        return strNum;
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