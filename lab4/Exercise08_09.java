//8.9游戏:井字游戏

import java.util.*;

public class Exercise08_09 {
  static char[][] board = new char[3][3];// 棋盘的规模

  public static void displyBoard() {// 打印棋盘
    System.out.println("\n-------------");
    for (int i = 0; i < 3; i++) {
      System.out.print("|");
      for (int j = 0; j < 3; j++) {
        if (board[i][j] != '\u0000') {
          System.out.print(" " + board[i][j] + " |");
        } else {
          System.out.print("   |");
        }
      }
      System.out.println("\n-------------");
    }
  }

  public static void moveBoard(char playerFlag) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter a row (0, 1, or 2) for player " + playerFlag + " :");
    int row = cin.nextInt();
    System.out.print("Enter a column (0, 1, or 2) for player " + playerFlag + " :");
    int column = cin.nextInt();
    board[row][column] = playerFlag;
  }

  public static boolean isWon(char ch) {
    for (int i = 0; i < 3; i++) {// 行相同或列相同
      if ((ch == board[i][0] && ch == board[i][1] && ch == board[i][2])
          || (ch == board[0][i] && ch == board[1][i] && ch == board[2][i])) {
        return true;
      }
    }
    if (ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) {// 主对交线
      return true;
    }
    // Check sub diagonal
    if (ch == board[0][2] && ch == board[1][1] && ch == board[2][0]) {// 副对角线
      return true;
    }
    return false;
  }

  public static boolean isDraw() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '\u0000') {
          return false;
        }
      }
    }
    return true; // All cells are now occupied
  }

  public static void main(String[] args) {
    displyBoard();
    int cnt = 0;
    while (true) {
      if (cnt % 2 == 0) {// 偶数
        moveBoard('X');
      } else { // 奇数
        moveBoard('O');
      }
      cnt++;
      displyBoard();
      if (isWon('X')) {
        System.out.println("X player won");
        return ;
      } 
      else if (isWon('O')) {
        System.out.println("O player won");
        return ;
      }
       else if (isDraw()) {
        System.out.println("No winner");
        return ;
      }
    }
  }
}


