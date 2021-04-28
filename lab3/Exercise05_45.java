//5.45统计：计算平均值和标准差
import java.util.*;
public class Exercise05_45 {
  public static void main(String[] args) {
    double[] x = new double[11];
    double avg = 0.0;
    double sum = 0.0;
    double squareSum = 0.0;
    double deviation = 0.0;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    for (int i = 0; i < 10; i++) {
      x[i] = input.nextDouble();
      sum += x[i];
      squareSum += Math.pow(x[i], 2);
    }
    avg = sum / 10;
    deviation = Math.sqrt((squareSum - sum*sum/10)/(10 - 1));
    System.out.println("The mean is " + avg);
    System.out.printf("The standard deviation is %.5f",deviation);

  }
}