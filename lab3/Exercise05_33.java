//5.33 完全数
import java.util.*;
public class Exercise05_33 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10000; i++) {//遍历1000内的数
      int sum = 0;
      for (int j = 1; j < i; j++) {//找到所有的除数
        if (i % j == 0) {
          sum += j;
        }
      }
      if (sum == i) {
        System.out.println("完全数有"+i);
      }
    }
  }
}