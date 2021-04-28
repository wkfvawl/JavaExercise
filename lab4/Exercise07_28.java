//7.28数学：组合
import java.util.*;
//import java.util.List;

public class Exercise07_28 {

  public static void main(String[] args) {
    int[] a = new int[10];
    List<String> lists = new ArrayList<String>();//使用list存储组合
    Scanner cin = new Scanner(System.in);
    System.out.print("请输入十个数： ");
    for (int i = 0; i < 10; i++) {// 循环输入10个数
      a[i] = cin.nextInt();
    }
    System.out.println("所有的组合共用：");
    for (int i = 0; i < 10; i++) {
      for (int j = i + 1; j < 10; j++)
        lists.add(a[i] + " " + a[j] + "");
    }
    for (int i = 0; i < lists.size() - 1; i++) {//list去重
      for (int j = lists.size() - 1; j > i; j--) {
        if (lists.get(j).equals(lists.get(i))) {
          lists.remove(j);
        }
      }
    }
    Iterator<String> it = lists.iterator();
    while (it.hasNext()) {
      System.out.println(it.next() + " ");
    }
  }
}