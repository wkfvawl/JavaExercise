//11.8新的Account类
import java.util.*;

class Account {
  private int id; // 账号
  private double balance; // 余额
  private static double annualInterestRate;
  // 当前利率,注意这里是static,要对所有该类的对象都有效
  private Date dateCreated; // 开户日期
  private String name; // 客户名称
  private ArrayList<Transaction> transactions;//存储账户交易的动态列表

  public Account() {
    dateCreated = new Date();
  }// 无参构造方法

  public Account(String newName, int newId, double newBalance) {
    name = newName;
    id = newId;
    balance = newBalance;
    dateCreated = new Date();
    transactions = new ArrayList<Transaction>();// 构建链表，存储账户交易
  }// 构造函数创建指定姓名，id和余额的账号

  public String getName() {
    return name;
  }

  public ArrayList getTransactions() {
    return transactions;
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
    transactions.add(new Transaction('W', amount, balance, ""));
  }// 提取指定额度

  public void deposit(double amount) {
    balance += amount;
    transactions.add(new Transaction('D', amount, balance, ""));
  }// 存储指定额度
}

class Transaction {

  private java.util.Date date;
  private char type; // 交易类型
  private double amount;// 交易量
  private double balance; // 交易后的新余额
  private String description;// 交易描述

  public Transaction(char newType, double newAmount, double newBalance, String newDescription) {
    date = new Date();
    type = newType;
    amount = newAmount;
    balance = newBalance;
    description = newDescription;
  }

  public Date getDate() {
    return date;
  }

  public char getType() {
    return type;
  }

  public void setType(char newType) {
    type = newType;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double newAmount) {
    amount = newAmount;
  }

  public double getBalance() {
    return balance;
  }

  public double setBalance(double newBalance) {
    balance = newBalace;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String newDescription) {
    description = newDescription;
  }
}

public class Exercise11_08 {
  public static void main(String[] args) {
    Account testAccount = new Account("George", 1112, 1000.0);
    Account.setAnnualInterestRate(1.5);
    
    testAccount.deposit(30);
    testAccount.deposit(40);
    testAccount.deposit(50);// 存钱测试

    testAccount.withdraw(5);
    testAccount.withdraw(4);
    testAccount.withdraw(2);// 取钱测试

    System.out.println("账户姓名：" + testAccount.getName());
    System.out.println("年利率: " + Account.getAnnualInterestRate());
    System.out.println("账户余额: " + testAccount.getBalance());

    for (int i = 0; i < testAccount.getTransactions().size(); i++) {
      Transaction transaction = (Transaction) testAccount.getTransactions().get(i);
      System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), transaction.getType(), transaction.getAmount(),
          transaction.getBalance());
    }
  }
}