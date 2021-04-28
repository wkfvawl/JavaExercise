//6.28 梅林素数
import java.util.*;
public class Exercise06_28 {
  public static boolean isPrime(int num) {//判断是否为素数
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    for (int i = 2; i <= 31; i++) {//遍历枚举
      int a = (int) (Math.pow(2, i) - 1);//梅林表达式
      if (isPrime(a)) {
        System.out.println("梅林素数有：" + a);
      }
    }
  }
}