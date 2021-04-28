//12.13 统计一个文字中的字符数、单词数和行数
import java.util.*;
import java.io.*;

public class Exercise12_13 {
  private static int countWords(String s)// 从字符串中提取单词
  {
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws Exception{
    File fileName = new File(args[0]);// 主函数参数
    //如果文件不存在
    if (!fileName.exists()) {
      System.out.println("Source file " + args[0] + " does not exist");
      System.exit(1);
    } // 需要检查文件是否存在，否则无法通过编译
    Scanner cin = new Scanner(fileName);
    int words = 0;//单词数
    int lines = 0;//行数
    while (cin.hasNext()) {
      String temp = cin.nextLine();
      lines++;
      words += countWords(temp);
    }
    System.out.println("File " + fileName + " has ");
    System.out.println(fileName.length() + " characters");
    System.out.println(words + " words");
    System.out.println(lines + " lines");
  }
}