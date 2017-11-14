import java.util.Scanner;

class RowSorting{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int[][] a = new int[b][c];
    int[][] d = new int[c][b];
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < c; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    for  (int i = 0; i < b; i++) {
      for (int j = 0; j < c; j++) {
      d[j][i] = a[i][j];
      }
    }

    System.out.print("\n\n");
    for (int i = 0; i < c; i++) {
      for (int j = 0; j < b; j++) {
        System.out.print(d[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
