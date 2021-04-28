//12.33(搜素 Web)
import java.util.*;
import java.net.URL;

public class Exercise12_33 {// 网络爬虫
  public static void main(String[] args) {
    Scanner input = new java.util.Scanner(System.in);
    System.out.print("请输入起始网站的URL: ");
    String url = input.nextLine();
    System.out.print("请输入要查找的单词: ");
    String word = input.nextLine();
    crawler(url, word); // 从起始的url开始爬取word
  }

  public static void crawler(String startingURL, String word) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();// 将被遍历的网址列表
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();// 已经遍历的网址列表
    listOfPendingURLs.add(startingURL);
    // 遍历100个URL
    while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
      // 将要遍历的列表不为空，已经遍历的列表规模小于100
      String urlString = listOfPendingURLs.remove(0);// 从将要遍历的列表中移除第一个
      if (!listOfTraversedURLs.contains(urlString)) {
        // 如果该URL不在已经遍历的列表中
        listOfTraversedURLs.add(urlString);
        // 就加入到已经遍历的列表中
        System.out.println("Craw " + urlString);

        if (contains(urlString, word)) {
          System.out.println("The URL " + urlString + " contains the word " + word);
          System.out.println("The number of pages been searched is " + listOfTraversedURLs.size());
          break;
        }

        for (String s : getSubURLs(urlString)) {
          if (!listOfTraversedURLs.contains(s))
            listOfPendingURLs.add(s);
        }
      }
    }
  }

  // 查找urlString网站下是否含有单词word
  public static boolean contains(String urlString, String word) {
    try {
      URL url = new URL(urlString);
      try (Scanner input = new Scanner(url.openStream())) {
        // 从输入流中读取数据
        while (input.hasNext()) {
          String line = input.nextLine();
          if (line.indexOf(word) > 0) {
            return true;
          } // 字符串中包含要找的单词，查找成功
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }

    return false;
  }

  // 用来获取页面中的其他URL的函数
  public static ArrayList<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();
    try {
      URL url = new URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) { // Ensure that a correct URL is found
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else
            current = -1;
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    return list;
  }
}