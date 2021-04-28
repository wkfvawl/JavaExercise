//8.17金融风暴
import java.util.*;
public class Exercise08_17 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    double[] balances = new double[n]; // 银行余额
    double[][] borrowers = new double[n][n]; // 银行i贷款给银行j的贷款金额
    double[] asset = new double[n]; // 银行总资产
    boolean[] judgement = new boolean[n]; // 银行是否安全
    double limit = cin.nextDouble(); // 保持银行安全的最小总资产
    for (int i = 0; i < n; i++) {
      balances[i] = cin.nextDouble();
      int num = cin.nextInt();
      for (int j = 0; j < num; j++) {
        int borrowerId = cin.nextInt();// 借款方id
        borrowers[i][borrowerId] = cin.nextDouble();
      }
    }

    for (int i = 0; i < n; i++) {// 开始假设所有的银行都是安全的
      judgement[i] = true;
    }
    boolean flag = true;

    while (flag) {
      flag = false;
      for (int i = 0; i < n; i++) {
        asset[i] = balances[i];
        for (int j = 0; j < n; j++) {
          asset[i] += borrowers[i][j];
        }
        if (judgement[i] && asset[i] < limit) {// 银行不安全
          judgement[i] = false;
          for (int j = 0; j < n; j++) {// 不安全银行导致借贷方不能将资产算入其总资产
            borrowers[j][i] = 0;
          }
          flag = true;
        }
      }
    }
    System.out.print("Unsafe banks: ");
    for (int i = 0; i < n; i++) {
      if (!judgement[i]) {
        System.out.print(i+" ");
      }
    }
  }
}


/*
5 201
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 125
181 1 2 125
Unsafe banks: 1 3*/
