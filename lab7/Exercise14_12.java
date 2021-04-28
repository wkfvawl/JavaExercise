//14.12(显示一个柱状图)
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class Exercise14_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();

    double height = 300;
    double width = 100;
    double paneWidth = 450;
    double paneHeight = 150;
 
    Rectangle r1 = new Rectangle(10, paneHeight - height * 0.2, width, height * 0.2);
    r1.setFill(Color.RED);
    Text text1 = new Text(10, paneHeight - height * 0.2 - 10, "项目 -- 20%");

    Rectangle r2 = new Rectangle(10 + (width + 10) * 1, paneHeight - height * 0.1, width, height * 0.1);
    r2.setFill(Color.BLUE);
    Text text2 = new Text(10 + (width + 10) * 1, paneHeight - height * 0.1 - 10, "测试 -- 10%");

    Rectangle r3 = new Rectangle(10 + (width + 10) * 2, paneHeight - height * 0.3, width, height * 0.3);
    r3.setFill(Color.GREEN);
    Text text3 = new Text(10 + (width + 10) * 2, paneHeight - height * 0.3 - 10, "期中考试 -- 30%");

    Rectangle r4 = new Rectangle(10 + (width + 10) * 3, paneHeight - height * 0.4, width, height * 0.4);
    r4.setFill(Color.ORANGE);
    Text text4 = new Text(10 + (width + 10) * 3, paneHeight - height * 0.4 - 10, "期末考试 -- 40%");

    pane.getChildren().addAll(r1, text1, r2, text2, r3, text3, r4, text4);
    Scene scene = new Scene(pane, paneWidth, paneHeight);
    primaryStage.setTitle("Exercise14_12"); // 舞台title
    primaryStage.setScene(scene); // 放置场景于舞台中
    primaryStage.show(); // display
  }

  public static void main(String[] args) {
    launch(args);
  }
}