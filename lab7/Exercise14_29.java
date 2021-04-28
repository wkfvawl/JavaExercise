//14.29 （游戏：豆机）
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;;

public class Exercise14_29 extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {           
    Pane pane = new Pane();
    double paneWidth = 400;
    double paneHeight = 300; 
    double firstNaitY = 50;
    double slotsLength = 40;
    double openingLength = 15;//开口到上边界距离
    double r = 5;//钉子半径
    double gapX = 10;//钉子之间横坐标间距
    double gapY = 20;//钉子之间竖坐标间距
    double centerX = paneWidth / 2;//最中间的x坐标
    int rowNubers = 7;
    double y = firstNaitY; 
    // 绘制所有的钉子
    for (int  i = 0; i < rowNubers; i++) {
      y += gapY;
      for (int  j = 0; j <= i; j++) {
        double x = centerX - i * gapX + j * gapY;
        Circle c = new Circle(x, y, r);
        c.setFill(Color.GREEN);//填充绿色
        pane.getChildren().add(c);
      }
    }
    
    // 绘制底部的竖漕
    y = y + r;//从最后一排钉子的底部开始绘制
    for (int i = 0; i < 9; i++) {
      double x = centerX - (rowNubers - 1) * gapX + (i - 1) * gapY;
      Line l = new Line(x, y, x, y + slotsLength);
      pane.getChildren().add(l);
    }
   
    //绘制瓶口
    double x1 = centerX - gapX;
    double y1 = firstNaitY - openingLength;
    double x2 = centerX + gapX;
    double y2 = firstNaitY - openingLength;
    double x4 = x2;
    double y4 = firstNaitY + r;
    double x3 = x1;
    double y3 = y4;
    Line rightBottle = new Line(x1,y1,x3,y3);
    Line leftBottle = new Line(x2,y2,x4,y4);
    pane.getChildren().add(rightBottle);
    pane.getChildren().add(leftBottle);

    // 绘制瓶子两边
    double x6 =  centerX - (rowNubers + 1) * gapX;
    double y6 = y;
    double x5 =  x6 + (rowNubers +1) * 2 * gapX;
    double y5 = y;
    //rightSide
    Line rightSide = new Line(x4, y4, x5, y5);
    //liftSide
    Line liftSide =new Line(x3, y3, x6, y6);
    pane.getChildren().add(liftSide);
    pane.getChildren().add(rightSide);
    
    // 绘制槽底边界  
    double x7 = x6;
    double y7 = y + slotsLength;
    double x8 = x5;
    double y8 = y + slotsLength;
    Line bottom = new Line(x7, y7, x8, y8);
    pane.getChildren().add(bottom);

    Scene scene = new Scene(pane, paneWidth, paneHeight);
    primaryStage.setTitle("Exercise14_29"); // 舞台title
    primaryStage.setScene(scene); // 放置场景于舞台中
    primaryStage.show(); // display
  }
  

  public static void main(String[] args) {
    launch(args);
  }
}