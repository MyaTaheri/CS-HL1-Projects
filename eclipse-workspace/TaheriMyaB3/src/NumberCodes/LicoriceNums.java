package NumberCodes;

import java.util.Scanner;

public class LicoriceNums
{

    public static void main (String[] args)
    {
        Scanner scnr  = new Scanner (System.in);
        System.out.println("---------------------");
        System.out.println("Enter Number: ");
        int num = scnr.nextInt();
        int sum = reverseNum(Integer.toString(num)) + num;
        System.out.println("---------------------");
        System.out.println(num + "+" + reverseNum(Integer.toString(num)) + "=" + sum);
        int steps = 1;
        while (!isPalindrome(String.valueOf(sum)))
        {
            int newNum = sum;
            sum = reverseNum(Integer.toString(newNum)) + newNum;
            System.out.println(newNum + "+" + reverseNum(Integer.toString(newNum)) + "=" + sum);
            steps++;
        }
        System.out.println("---------------------");
        System.out.println("Steps needed: " + steps);
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

    public static int reverseNum (String num)
    {

        String flippedString = "";

        for (int i = 0; i < num.length(); i++)
        {
            flippedString = num.charAt(i) + flippedString;
        }

        return Integer.valueOf(flippedString);
    }

}