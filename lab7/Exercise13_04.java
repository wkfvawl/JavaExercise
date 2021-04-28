//13.4 显示日历
import java.util.*;

public class Exercise13_04 {
  static Calendar calendar = new GregorianCalendar();

  public static void main(String[] args) {
    int month = calendar.get(Calendar.MONTH) + 1;
    int year = calendar.get(Calendar.YEAR);
    if (args.length == 2) {
      month = Integer.parseInt(args[0]);
      year = Integer.parseInt(args[1]);
    } // 年月参数齐备
    else if (args.length == 1) {
      month = Integer.parseInt(args[0]);
      calendar.set(Calendar.MONTH, month - 1);
    } // 不输入年份，年份为当前年份
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month - 1);// 0表示1月......
    calendar.set(Calendar.DATE, 1);// 每月的第一天
    printMonth(year, month);
  }

  public static void printMonth(int year, int month) {
    printMonthTitle(year, month);
    printMonthBody(year, month);
  }

  public static int getStartDay() {
    return calendar.get(Calendar.DAY_OF_WEEK);
  }

  public static void printMonthTitle(int year, int month) {
    System.out.println("         " + getMonthName(month) + ", " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  public static String getMonthName(int month) {
    String monthName = "";
    switch (month) {
    case 1:
      monthName = "January";
      break;
    case 2:
      monthName = "February";
      break;
    case 3:
      monthName = "March";
      break;
    case 4:
      monthName = "April";
      break;
    case 5:
      monthName = "May";
      break;
    case 6:
      monthName = "June";
      break;
    case 7:
      monthName = "July";
      break;
    case 8:
      monthName = "August";
      break;
    case 9:
      monthName = "September";
      break;
    case 10:
      monthName = "October";
      break;
    case 11:
      monthName = "November";
      break;
    case 12:
      monthName = "December";
    }
    return monthName;
  }

  public static void printMonthBody(int year, int month) {
    int startDay = getStartDay();
    int numOfDaysInMonth = getNumberOfDaysInMonth();
    int i = 0;
    for (i = 0; i < startDay - 1; i++) {
      System.out.print("    ");
    }
    for (i = 1; i <= numOfDaysInMonth; i++) {
      if (i < 10)
        System.out.print("   " + i);
      else
        System.out.print("  " + i);
      if ((i + startDay - 1) % 7 == 0)
        System.out.println();
    }
    System.out.println("");
  }

  public static int getNumberOfDaysInMonth() {
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  }//获得一个月内的天数
}