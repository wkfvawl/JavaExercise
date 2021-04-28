//11.19使用最先合适法解决集装箱问题
import java.util.*;

public class Exercise11_19 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter the number of objects: ");
    int num = cin.nextInt();
    int[] weights = new int[num];//物件重量数组
    int[] vis = new int[num];//物件是否被装入到箱子中，1装入，0未装入
    System.out.print("Enter the weights of the objects: ");
    for (int i = 0; i < num; i++) {
      weights[i] = cin.nextInt();
      vis[i] = 0;
    }
    int cnt = 1;
    int sum = 0;
    for (int i = 0; i < num; i++) {
      if (vis[i] == 0) {
        sum = weights[i];
        vis[i] = 1;
        System.out.println("");
        System.out.print("Container " + cnt + " contains objects with weight " + weights[i]);
      }
      for (int j = i + 1; j < num; j++) {
        if ((vis[j] == 0) && (sum + weights[j] < 10)) {
          sum += weights[j];
          vis[j] = 1;
          System.out.print(" " + weights[j]);
        } else {
          continue;
        }
      }
    }

  }
}