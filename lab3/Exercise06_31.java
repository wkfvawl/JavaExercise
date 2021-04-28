//6.31 金融应用：信用卡号的合法性验证
import java.util.*;
public class Exercise06_31 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter a credit card number as a long integer: ");
    long number = cin.nextLong();
    if (isValid(number)) {
      System.out.println(number + " is valid");
    } else {
      System.out.println(number + " is invalid");
    }
  }

  // 判断银行卡号是否合法
  public static boolean isValid(long number) {
    if ((getSize(number) >= 13) && (getSize(number) <= 16)) {// 13到16位的整数
      if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6)
          || prefixMatched(number, 37)) {// 开头前缀需要符合要求的数字
        int evenSum = sumOfDoubleEvenPlace(number);
        int oddSum = sumOfOddPlace(number);
        if ((evenSum + oddSum) % 10 == 0) {
          return true;
        }
      }
    }
    return false;
  }

  // 获得偶数位的数字之和
  public static int sumOfDoubleEvenPlace(long number) {
    int ans = 0;
    int temp;
    number = number / 10;
    while (number != 0) {
      temp = (int) ((number % 10) * 2);
      if (temp > 9) {// 数字翻倍之后变成了两位数
        temp = getDigit(temp);
      }
      ans += temp;
      number = number / 100;
    }
    return ans;
  }

  // 两位数的各位之和
  public static int getDigit(int number) {
    int ans;
    ans = number / 10 + number % 10;
    return ans;
  }

  // 原数字奇数各位之和
  public static int sumOfOddPlace(long number) {
    int ans = 0;
    int temp;
    while (number != 0) {
      temp = (int) (number % 10);
      ans += temp;
      number = number / 100;
    }
    return ans;
  }

  // 前缀匹配
  public static boolean prefixMatched(long number, int d) {
    if (d == getPrefix(number, getSize(d))) {
      return true;
    } else {
      return false;
    }
  }

  // 数字的位数
  public static int getSize(long d) {
    int cnt = 0;
    while (d != 0) {
      d = d / 10;
      cnt++;
    }
    return cnt;
  }

  // 获得前缀，前k位
  public static long getPrefix(long number, int k) {
    if(k>getSize(number))
    {
      return number;
    }
    int i = getSize(number) - k;
    while (i != 0) {
      number /= 10;
      i--;
    }
    return number;
  }
}
// 4388576018410707 is valid
// 4388576018402626 is invalid