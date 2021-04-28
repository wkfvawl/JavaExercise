//10.12(几何：Triangle2D 类)

import java.util.*;
import java.awt.geom.Line2D;

class MyPoint {
    private double x;
    private double y;// 点坐标(x,y)

    public MyPoint() {
    }// 无参构造方法

    public MyPoint(double newX, double newY) {
        x = newX;
        y = newY;
    }// 指定坐标构造方法

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }// x、y的获取方法

    public double distance(MyPoint secondPoint) {
        return distance(this, secondPoint);
    }

    public static double distance(MyPoint p1, MyPoint p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

}

class Triangle2D {

    private MyPoint p1, p2, p3;

    public Triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 2);
    }// 无参构造方法

    public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
        p1 = new MyPoint(x1, y1);
        p2 = new MyPoint(x2, y2);
        p3 = new MyPoint(x3, y3);
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }

    public double getPerimeter() {
        return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
    }// 返回三角形周长

    public double getArea() {
        double s1 = p1.distance(p2);
        double s2 = p1.distance(p3);
        double s3 = p2.distance(p3);
        double s = (s1 + s2 + s3) / 2;
        double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));// 海伦公式
        return area;
    }// 返回三角形面积

    public boolean contains(double x, double y) {
        double area = this.getArea();// 整个三角形的面积
        MyPoint p0 = new MyPoint(x, y);
        double a = new Triangle2D(p1, p3, p0).getArea();
        double b = new Triangle2D(p2, p3, p0).getArea();
        double c = new Triangle2D(p1, p2, p0).getArea();
        return Double.compare(a + b + c, area) == 0 && a != 0 && b != 0 && c != 0;
    }// 数学原理，p点与三角形各个顶点连线划分成的三个三角形的面积之和若等于原三角形，则在p点在三角形内部，否则在外部

    public boolean contains(Triangle2D t) {
        double x1 = t.getP1().getX();
        double y1 = t.getP1().getY();
        double x2 = t.getP2().getX();
        double y2 = t.getP2().getY();
        double x3 = t.getP3().getX();
        double y3 = t.getP3().getY();
        return (contains(x1, y1) && contains(x2, y2) && contains(x3, y3));
    }// 要求三个顶点都要在三角形内部

    public boolean overlaps(Triangle2D t) {
        // 判断两个三角形是否重叠
        // 使用Line2D类中的intersectsLine方法判断两个三角形是否有边相交
        Line2D[] line = new Line2D[3];
        line[0] = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
        line[1] = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
        line[2] = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
        Line2D[] side = new Line2D[3];
        side[0] = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        side[1] = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
        side[2] = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
        if (contains(t) == true) {
            return true;
        }//包含关系一定是重叠的
        //判断两个三角形是否有边相交，有边相交，则一定有三角形重叠
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (line[i].intersectsLine(side[j]) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 测试程序
public class Exercise10_12 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(2.5, 2);
        MyPoint p2 = new MyPoint(4.2, 3);
        MyPoint p3 = new MyPoint(5, 3.5);
        Triangle2D t1 = new Triangle2D(p1, p2, p3);
        System.out.println("测试三角形的面积为：" + t1.getArea());
        System.out.println("测试三角形的周长为：" + t1.getPerimeter());
        System.out.println("(3,3)点是否在测试三角形内部？" + t1.contains(3, 3));
        System.out.println("三角形(2.9,2),(4,1),(1,3.4)是否在测试三角形内部？"+t1.contains(new Triangle2D(new MyPoint(2.9,2),new MyPoint(4,1),new MyPoint(1,3.4))));
        System.out.println("三角形(2,5.5),(4,-3),(2,6.5)是否与测试三角形重叠？"+t1.overlaps(new Triangle2D(new MyPoint(2,5.5),new MyPoint(4,-3),new MyPoint(2,6.5))));
    }
}