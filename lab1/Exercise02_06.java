import java.util.*;

public class Exercise02_06 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter an integer between 0 and 1000: ");
        int n = cin.nextInt();
        int sum = 0;
        while(n != 0)
        {
           sum += n % 10;
           n = n / 10;
        }
        System.out.println("The sum of all digits in " + n + " is " + sum);
    }
}