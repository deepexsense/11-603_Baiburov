import java.util.Scanner;

class FunctionMult{
  public static int[][] mult(int[][] z, int[][] x){
    int[][] v = new int[z.length][x[0].length];
    for (int i = 0; i < z.length; i++) {
      for (int j = 0; j < x[0].length; j++) {
        int m = 0;
        for(int h = 0; h < z[0].length; h++){
          m += z[i][h] * x[h][j];
        }
        v[i][j] = m;
      }
    }
    return v;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int q = scanner.nextInt(), w = scanner.nextInt();
    int[][] a = new int[q][w];
    for (int i = 0; i < q; i++ ) {
      for (int j = 0; j < w; j++ ) {
        a[i][j] = scanner.nextInt();
      }
    }
    int e = scanner.nextInt(), r = scanner.nextInt();
    int[][] b = new int[e][r];
    for (int i = 0; i < e; i++ ) {
      for (int j = 0; j < r; j++ ) {
        b[i][j] = scanner.nextInt();
      }
    }
    int[][] c = new int[q][r];
    c = mult(a,b);

    System.out.print("\n\n");
    for (int i = 0; i < q; i++) {
      for (int j = 0; j < r; j++ ) {
        System.out.print(c[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
