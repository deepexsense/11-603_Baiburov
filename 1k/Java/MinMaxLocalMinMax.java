import java.util.Scanner;

class MinMaxLocalMinMax{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] a = new int[n];

    for(int i = 0; i < n; i++){
      int b = scanner.nextInt();
      a[i] = b;
    }

    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    for(int i = 0; i < n; i++){
      if(a[i] < min){
        min = a[i];
      }
      if(a[i] > max){
        max = a[i];
      }
    }

    System.out.print("Minimum: " + min + "\nMaximum: " + max + "\nLocalMin: ");

    for(int i = 1; i < n - 1; i++){
      if(a[i - 1] > a[i] && a[i + 1] > a[i]){
        System.out.print(a[i] + " ");
      }
    }

    System.out.print("\nLocalMax: ");
    for(int i = 1; i < n - 1; i++){
      if(a[i - 1] < a[i] && a[i + 1] < a[i]){
        System.out.print(a[i] + " ");
      }
    }
  }
}
