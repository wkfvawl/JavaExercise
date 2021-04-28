// 1.11人口计算
import java.util.*;
public class Exercise01_11 {
    public static void main(String[] args){
        int org = 312032486;             //当前人口
        int sec = 365 * 24 * 60 * 60;    //一年之中的秒数
        double birth = sec / 7.0;        //出生
        double death = sec / 13.0;       //死亡 
        double img = sec / 45.0;         //迁移
        int sum = (int)(birth - death + img);    
        int years;
        //使用循环简化
        for(int i = 1 ;i <= 5; i++)
        {
            years = org + i * sum;
            System.out.println(years);
        }   
    }
}