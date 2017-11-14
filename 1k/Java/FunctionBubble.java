import java.util.Scanner;

class FunctionBubble{
  public static void[] sort(int[] q){
    for(int i = q.length - 1; i >= 0; i--){
      for(int j = 1; j <= i; j++){
        if(q[j - 1] > q[j]){
          int w = q[j - 1];
          q[j - 1] = q[j];
          q[j] = w;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int k = scanner.nextInt();
    int[] a = new int[k];
    for(int i = 0; i < k; i++){
      a[i] = scanner.nextInt();
    }

    a = sort(a);

    for (int i = 0; i < k; i++) {
      System.out.print(a[i] + " ");
    }
  }


}
