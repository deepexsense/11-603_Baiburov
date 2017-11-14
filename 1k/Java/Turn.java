import java.util.Scanner;

class Turn{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] a = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        int q = a[i][j];
        a[i][j] = a[n-j-1][n-i-1];
        a[n-j-1][n-i-1] = q;
      }
    }

    System.out.print("\n\n");

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.print("\n");
    }

  }
}
