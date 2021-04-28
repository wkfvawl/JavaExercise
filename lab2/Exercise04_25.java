//4.25 生成车牌号码
import java.util.*;
public class Exercise04_25 {
    
    public static void main(String args[]) {
        char c;
        int x;
        System.out.print("随机产生的车牌号为：");
        for(int i = 0;i < 3;i++){//前三位大写字母
            c = (char)(int)(Math.random() * 26 + 65);
            System.out.print(c);
        }
        System.out.print("-");
        for(int i = 0;i < 4;i++){//后四位数字
            x=(int)(Math.random() * 10 );
            System.out.print(x);
        }
            
    }      
}