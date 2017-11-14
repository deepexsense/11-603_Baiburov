import java.util.Scanner;

class Transposing{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int w = scanner.nextInt();
    int q = scanner.nextInt();
    int[][] a = new int[w][q];
    int[][] b = new int[q][w];
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < q; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < w; i++) {
      for (int j = 0; j < q; j++) {
        b[j][i] = a[i][j];
      }
    }
    System.out.print("\n\n");
    for (int i = 0; i < q; i++) {
      for (int j = 0; j < w; j++) {
        System.out.print(b[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
