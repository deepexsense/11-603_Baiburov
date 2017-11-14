import java.util.Scanner;
class Removing{
  public static void main(String[] args) {
    int a[] = {-3, -7, 10, 11, -5, 2};
    int b;
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    for (int i = c; i < a.length - 1; i++){
          b = a[i];
          a[i] = a[i+1];
          a[i+1] = b;
    }
      for (int i = 0; i < a.length - 1; i++)
      System.out.println(a[i]);
  }
}
