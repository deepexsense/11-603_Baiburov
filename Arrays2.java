import java.util.Scanner;

class Arrays2{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int b;
    int n = scanner.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = scanner.nextInt();
    }
    for(int i = 0; i < n/2; i++){
        int temp = a[i];
        a[i] = a[n-i-1];
        a[n-i-1] = temp;
      }
      for(int i = 0; i < n; i++){
        System.out.println(a[i]);
    }
  }
}
