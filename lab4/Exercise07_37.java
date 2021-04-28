//7.37游戏：豆机
import java.util.*;

public class Exercise07_37 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int m, n;
    System.out.print("Enter the number of balls to drop:");
    m = cin.nextInt();// 输入球的个数
    System.out.print("Enter the number of slots in the bean machine:");
    n = cin.nextInt();// 输入机器的漕数
    int[] slots = new int[n];
    char[] path = new char[n];// 保存路径
    System.out.println("");
    System.out.println("");
    for (int i = 0; i < m; i++) {
      int cnt = 0;
      for (int j = 0; j < n - 1; j++) {
        int opt = (int) (Math.random() * 2);// 随机产生0或1
        if (opt == 0) {// 左
          path[j] = 'L';
        } else {// 右
          path[j] = 'R';
          cnt++;// R的个数觉得存在于哪一个漕中
        }
      }
      slots[cnt]++;// 记录存在于的漕
      System.out.println(path);// 打印路径
    }
    int maxs = 0;// 槽内最多含有的小球数
    for (int i = 0; i < n; i++) {
      if (slots[i] > maxs) {
        maxs = slots[i];
      }
    }
    System.out.println();
    for (int i = 0; i < maxs; i++) {//从最多漕数的行向下
      for (int j = 0; j < n; j++) {//判断每一个漕位
        if (slots[j] >= (maxs - i)) {
          System.out.print("0");// 球用0表示
        } else {
          System.out.print(" ");// 球用0表示
        }
      }
      System.out.println();
    }
  }
}