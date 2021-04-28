//3.28 几何：两个矩形
import java.util.*;
public class Exercise03_28 {
    
    public static void main(String args[]) {
        double x1,x2,y1,y2,w1,w2,h1,h2;
        double x,y;
        double w3,w4,h3,h4;
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter r1's center x-,y-coordinates, width,and height:");
        x1=cin.nextDouble();
        y1=cin.nextDouble();
        w1=cin.nextDouble();
        h1=cin.nextDouble();
        System.out.print("Enter r2's center x-,y-coordinates, width,and height:");
        x2=cin.nextDouble();
        y2=cin.nextDouble();
        w2=cin.nextDouble();
        h2=cin.nextDouble();
        
        x=Math.abs(x1-x2);
        y=Math.abs(y1-y2);
        w3=Math.abs((w1-w2)/2);
        h3=Math.abs((h1-h2)/2);
        w4=Math.abs((w1+w2)/2);
        h4=Math.abs((h1+h2)/2);
        if(x<=w3&&y<=h3)//内含
        {
            System.out.println("r2 is inside r1"); 
        }
        else if(x<=w4&&y<=h4)//相交
        {
            System.out.println("r2 overlaps r1");
        }
        else//外离
        {
            System.out.println("r2 does not overlap r1");
        }

    }      
}