//2.19几何：三角形的面积
import java.util.*;
public class Exercise02_19 {
    public static void main(String[] args) {
        double []x = new double[4];
        double []y = new double[4];//使用数组来保存坐标
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter three points for a triangle: ");
        for(int i = 1; i <= 3; i++)//循环输入三点
        {
            x[i] = cin.nextDouble();
            y[i] = cin.nextDouble();
        }
        double s1 = Math.sqrt(Math.pow((x[2] - x[1]),2) + Math.pow((y[2] - y[1]),2));
        double s2 = Math.sqrt(Math.pow((x[2] - x[3]),2) + Math.pow((y[2] - y[3]),2));
        double s3 = Math.sqrt(Math.pow((x[3] - x[1]),2) + Math.pow((y[3] - y[1]),2));
        //海伦公式求三角形的面积
        double s = (s1 + s2 + s3) / 2;
        double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
        System.out.println("The area of the triangle is " + String.format("%.2f", area));
    }
}