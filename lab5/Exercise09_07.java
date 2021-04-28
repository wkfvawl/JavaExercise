//9.7(Account类)
import java.util.*;

//java.util.Date 导入Data包
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

public class Exercise09_07 {
    // 测试程序
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);// 年利率4.5
        account.withdraw(2500);// 取款2500
        account.deposit(3000);// 存款3000
        double nowBalance = account.getBalance();
        double nowAnnualInterest = account.getMonthlyInterest();
        double nowAnnualInterestRate = account.getMonthlyInterestRate();
        Date DateCreated = account.getDateCreated();
        System.out.println("账号余额有：" + nowBalance );
        System.out.println("月利息是:" + nowAnnualInterest );
        System.out.println("该账号创建于" + DateCreated );
    }
}