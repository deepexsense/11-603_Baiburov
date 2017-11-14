import java.util.Scanner;

class SortMatrix{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int w = scanner.nextInt();
    int q = scanner.nextInt();
    int[][] a = new int[w][q];
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < q; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    for (int z = 0; z < w; z++) {
      for(int i = q - 1; i >= 0; i--){
        for(int j = 1; j <= i; j++){
          if(a[z][j - 1] > a[z][j]){
            int e = a[z][j - 1];
            a[z][j - 1] = a[z][j];
            a[z][j] = e;
          }
        }
      }
    }
    System.out.print("\n\n");
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < q; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
