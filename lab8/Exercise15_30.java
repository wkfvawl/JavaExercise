//15.30(播放幻灯片)
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.util.Duration;

//Duration定义持续事件
public class Exercise15_30 extends Application {

  @Override
  public void start(Stage primaryStage) {

    // 幻灯片布局
    SlidePane slidepane = new SlidePane();
    // 鼠标事件
    // 鼠标点击（按压-释放）
    slidepane.setOnMouseClicked(e -> {
      // 检查动画当前的状态
      if (slidepane.getAnimationStatus() == 1) {
        slidepane.pause();
      } else if (slidepane.getAnimationStatus() == 3) {
        {
          slidepane.play();
        }
      }
    });

    // 幻灯片图像大小为800*600像素，创建相匹配的场景
    Scene scene = new Scene(slidepane, 800, 600);
    primaryStage.setTitle("Exercise15_30"); // 舞台title
    primaryStage.setScene(scene); // 放置场景于舞台中
    primaryStage.show(); // display

  }

  public static void main(String[] args) {
    launch(args);
  }
}

// 幻灯片布局类
class SlidePane extends StackPane {

  private Image[] image = new Image[25];
  private ImageView imageView;// 显示一个图像
  private Timeline animation;
  private int cnt = 0;// 记录显示图像的页数

  // 构造函数
  public SlidePane() {
    for (int i = 0; i < 25; i++) {
      image[i] = new Image("file:image/slide" + i + ".jpg");
    }
    // 网络图像文件前面加“http://”，而本地文件则要加“file:”
    imageView = new ImageView(image[0]);// 指向第一个需要显示的图像
    this.getChildren().add(imageView);
    animation = new Timeline(new KeyFrame(Duration.millis(2000), e -> run()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  // 运行状态，自动循环播放下一张幻灯片
  public void run() {

    int index = cnt % 25;
    cnt++;
    imageView.setImage(image[index]);
  }

  // 播放
  public void play() {
    animation.play();
  }

  // 暂停
  public void pause() {
    animation.pause();
  }

  /*
   * 获取动画当前状态 播放返回1 终止返回2 暂停返回3
   */
  public int getAnimationStatus() {
    if (animation.getStatus() == Animation.Status.RUNNING) {
      return 1;
    } else if (animation.getStatus() == Animation.Status.STOPPED) {
      return 2;
    } else if (animation.getStatus() == Animation.Status.PAUSED) {
      return 3;
    }
    return 0;
  }

}