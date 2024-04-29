package NumberCodes;

public class BinaryPalindrome
{
    public static void main (String[] args)
    {  
        int max = 1000000;
        int sum = 0;
        for (int i = 1; i < max; i++)
        {
            if (isPalindrome(String.valueOf(i)) && isPalindrome(convertBinary(i)))
            {
                System.out.println(i + "   " + convertBinary(i));
                sum += i;
            }
        }

        System.out.println("Sum: "+ sum);
    }

    public static boolean isPalindrome (String num)
    {

        String flippedString = "";

        for (int i = 0; i < num.length(); i++)
        {
            flippedString = num.charAt(i) + flippedString;
        }

        return (flippedString.equals(num));
    }


    public static String convertBinary(int baseTen)
    {
        // return Integer.toBinaryString(baseTen);
        String s = "";
        while (baseTen > 0)
        {
            if ((baseTen % 2 ) == 0)
                s = 0 + s;
            else
                s = 1 + s;
            baseTen = baseTen / 2;
        }
        return s;
    }
}