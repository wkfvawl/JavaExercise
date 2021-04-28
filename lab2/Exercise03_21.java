//3.21 科学：某天是星期几
import java.util.Scanner;
public class Exercise03_21 {
    
    public static void main(String args[]) {
        int year,m,q;
        int j,k,h;
        String []week = new String[] {"Saturdat","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};//数组保存
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter year: (e.g.,2012): ");
        year = cin.nextInt();
        System.out.print("Enter month: 1-12: ");
        m = cin.nextInt();
        System.out.print("Enter the day of the month : 1-31: ");
        q = cin.nextInt();
        if(m == 1||m == 2) {//1月2月的特殊情况 1->13,2->14
            m = m + 12;
            year = year -1;
        }
        j = (int)(year / 100);
        k = year % 100;
        h=(q+ (int)(26 * (m + 1 ) / 10) + k + (int)(k / 4) + (int)(j / 4) + (5 * j)) % 7;//泽勒一致性公式
        System.out.println("Day of the week is " + week[h]);
    }      
}