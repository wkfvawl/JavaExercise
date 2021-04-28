//10.7(游戏：ATM机)
import java.util.*;

class Account {
    private int id;// 账号
    private double balance;// 余额
    private static double annualInterestRate;// 当前利率
    private Date dateCreated;// 开户日期

    public Account() {
        dateCreated = new Date();
    }// 无参构造方法

    public Account(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }// 设置当前利率

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }// 返回当前利率

    public double getMonthlyInterestRate() {
        return annualInterestRate / (12 * 100);
    }// 返回月利率

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / (12 * 100));
    }// 返回月利息

    public Date getDateCreated() {
        return dateCreated;
    }// dateCreated访问器方法

    public void withdraw(double amount) {
        balance -= amount;
    }// 提取指定额度

    public void deposit(double amount) {
        balance += amount;
    }// 存储指定额度

}

// 测试程序
public class Exercise10_07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Account[] accounts = new Account[10];// 10个账户数组
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i,100);
        }//初始化操作
        int id;
        int choice;
        while (true) {
            System.out.print("Enter an id: ");
            id = cin.nextInt();
            if (id < 1 || id > 10) {
                System.out.println("输入的id错误，请输入正确的id:");
                continue;
            }
            while (true) {
                System.out.println(" ");
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                choice = cin.nextInt();
                if (choice == 1) {
                    System.out.println("The balance is " + accounts[id].getBalance());

                } else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    int amount = cin.nextInt();
                    if (amount <= accounts[id].getBalance()) {
                        accounts[id].withdraw(amount);
                    } else {
                        System.out.println("余额不足！");
                    }
                } else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    int amount = cin.nextInt();
                    if (amount >= 0) {
                        accounts[id].deposit(amount);
                    } else {
                        System.out.print("要存入的金额不合法，请重新输入！");
                    }
                } else if (choice == 4) {
                    break;

                } else {
                    System.out.println("输入错误，请重新输入：");
                }
            }
        }
    }
}