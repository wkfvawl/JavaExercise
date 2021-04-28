//15.29（赛车）
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

//Duration定义持续事件
public class Exercise15_29 extends Application {
  @Override
  public void start(Stage primaryStage) {

    CarPane car = new CarPane();
    Scene scene = new Scene(car, 600, 400);// 创建场景
    // 时间线计时器 动画持续刷新时间为50

    // 设置鼠标触发事件
    car.setOnMousePressed(e -> car.pause());
    car.setOnMouseReleased(e -> car.play());

    // 被聚焦的结点可以接收KeyEvent事件
    car.requestFocus();// car可以接收键盘输入
    // 左键上键加速，右键下键减速 回车暂停
    car.setOnKeyPressed(e -> {
      switch (e.getCode()) {
      case UP:
        car.increaseSpeed();
        break;
      case RIGHT:
        car.increaseSpeed();
        break;
      case DOWN:
        car.decreaseSpeed();
        break;
      case LEFT:
        car.decreaseSpeed();
        break;
      case ENTER:
        car.pause();
        break;
      }
    });

    primaryStage.setTitle("Exercise15_29"); // 舞台title
    primaryStage.setScene(scene); // 放置场景于舞台中
    primaryStage.show(); // display
  }

  public static void main(String[] args) {
    launch(args);
  }
}

// 汽车面板
class CarPane extends Pane {
  private double w = 600;
  private double h = 400;
  private double baseX = 0;
  private double baseY = h;

  private double r = 5;// 汽车轮子半径
  private Timeline animation;

  // 绘制汽车轮子
  Circle wheel1 = new Circle(baseX + 10 + 5, baseY - 10 + 5, r);
  Circle wheel2 = new Circle(baseX + 30 + 5, baseY - 10 + 5, r);
  // 绘制车身
  Rectangle carBody = new Rectangle(baseX, baseY - 20, 50, 10);
  // 绘制车顶棚
  Polygon carTop = new Polygon(baseX + 10, baseY - 20, baseX + 20, baseY - 30, baseX + 30, baseY - 30, baseX + 40,
      baseY - 20);

  // 构造函数
  public CarPane() {
    wheel1.setFill(Color.BLACK);
    wheel2.setFill(Color.BLACK);
    carBody.setFill(Color.BLUE);
    carTop.setFill(Color.RED);
    this.getChildren().addAll(wheel1, wheel2, carBody, carTop);
    animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveCar()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // 开始动画
  }

  // 汽车移动函数
  public void moveCar() {
    if (baseX > w) {
      baseX = -20;
      //车身距
    } else {
      baseX += 1;
    }
    setValues();
  }

  // 运动
  public void play() {
    animation.play();
  }

  // 暂停
  public void pause() {
    animation.pause();
  }

  // 加速
  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 1);
  }

  // 减速
  public void decreaseSpeed() {
    animation.setRate(animation.getRate() - 1);
  }

  public void setValues() {
    wheel1.setCenterX(baseX + 10 + 5);
    wheel1.setCenterY(baseY - 10 + 5);
    wheel2.setCenterX(baseX + 30 + 5);
    wheel2.setCenterY(baseY - 10 + 5);

    carBody.setX(baseX);
    carBody.setY(baseY - 20);

    carTop.getPoints().clear();
    carTop.getPoints().addAll(baseX + 10, baseY - 20, baseX + 20, baseY - 30, baseX + 30, baseY - 30, baseX + 40,
        baseY - 20);
  }

}