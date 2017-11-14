import java.util.Scanner;

class Function1{
  public static int min(int[] a){
    int min = a[0];
    for (int i = 0; i < a.length; i++) {
      if(min > a[i]){
        min = a[i];
      }
    }
    return min;
  }
  public static int max(int[] a){
    int max = a[0];
    for (int i = 0; i < a.length; i++) {
      if(max < a[i]){
        max = a[i];
      }
    }
    return max;
  }
  public static int sum(int[] a){
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = scanner.nextInt();
    }

    System.out.print(min(b) + "\n");
    System.out.print(max(b) + "\n");
    System.out.print(sum(b));
  }
}
