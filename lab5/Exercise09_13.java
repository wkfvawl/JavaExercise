//9.13(location类)
import java.util.*;

class Location {
    int row;
    int column;// 最大值元素所在的行列坐标
    double maxValue;// 最大值
}

public class Exercise09_13 {
    public static Location locateLargest(double[][] a) {
        Location loca = new Location();
        int nowRow = a.length;
        int nowColumn = a[0].length;
        loca.maxValue = a[0][0];
        // 遍历整个二维数组查找最大值
        for (int i = 0; i < nowRow; i++) {
            for (int j = 0; j < nowColumn; j++) {
                if (a[i][j] > loca.maxValue) {
                    loca.maxValue = a[i][j];
                    loca.row = i;
                    loca.column = j;
                }
            }
        }
        return loca;
    }

    // 测试程序
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the array: ");
        int myRow = cin.nextInt();
        int myColumn = cin.nextInt();
        double[][] mp = new double[myRow][myColumn];// 动态创建二维数组
        System.out.println("Enter the array: ");
        for (int i = 0; i < myRow; i++) {
            for (int j = 0; j < myColumn; j++) {
                mp[i][j] = cin.nextDouble();
            }
        }
        Location location = locateLargest(mp);
        System.out.println("The location of the largest element is " + location.maxValue + " at (" + location.row + ", " + location.column + ")");
    }
}
/*
4 
23.5 35 2 10 
4.5 3 45 3.5 
44 5.5 9.6
 */