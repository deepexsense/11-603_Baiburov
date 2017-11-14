import java.util.Scanner;

class Crossing{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int k1 = scanner.nextInt();
    int[] a1 = new int[k1];

    for(int i = 0; i < k1; i++){
      int q = scanner.nextInt();
      a1[i] = q;
    }

    int k2 = scanner.nextInt();
    int[] a2 = new int[k2];

    for(int i = 0; i < k2; i++){
      int q = scanner.nextInt();
      a2[i] = q;
    }

    for(int i = 0; i < k1; i++){
      for(int j = 0; j < k2; j++){
        if(a1[i] == a2[j]){
          System.out.print(a1[i] + " ");
        }
      }
    }
  }
}
