import java.util.Scanner;

class Multiplication{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int[][] a = new int[b][c];
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < c; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    int d = scanner.nextInt();
    int[][] e = new int[c][d];
    for (int i = 0; i < d; i++) {
      for (int j = 0; j < b; j++) {
        e[i][j] = scanner.nextInt();
      }
    }

    int[][] h = new int[b][d];
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < d; j++) {
        h[i][j] = a[i][j]*e[i][j];
      }
    }

System.out.print("\n\n");
for (int i = 0; i < b; i++) {
  for (int j = 0; j < d; j++) {
    System.out.print(h[i][j] + " ");
  }
  System.out.print("\n");
  }
}
}
