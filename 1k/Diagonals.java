import java.util.Scanner;


class Diagonals{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int k = scanner.nextInt();
    int[][] a = new int[k][k];

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++) {
        a[i][j] = scanner.nextInt();
      }
    }
    int fdiag = 0, sdiag = 0, sum = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      fdiag+=a[i][i];
    }
    for (int i = 0 ; i < k; i++) {
      sdiag+=a[i][k - i - 1];
    }
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < i; j++) {
        sum+=a[j][i];
        if(a[j][i] < min){
          min = a[j][i];
        }
      }
    }
    System.out.print("main diagonal: " + fdiag + "\nsecondary diagonal: " + sdiag + "\nsum: " + sum + "\nmin: " + min);
  }
}
