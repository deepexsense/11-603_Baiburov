import java.util.Scanner;

class PrimeComposite{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n= scanner.nextInt();
    int[] a = new int[n];

    for(int i = 0; i < n; i++){
      int q = scanner.nextInt();
      a[i] = q;
    }

    int[] prime = new int[100000];

    for(int i = 2; i*i < 100000; i++){
      if(prime[i] == 0){
        for(int j = i*i; j < 100000; j += i){
          prime[j] = 1;
        }
      }
    }

    for(int i = 0; i < n - 1; i++){
      if(prime[a[i]] == 0 && prime[a[i+1]] == 1){
        System.out.print(i + " ");
      }
    }

  }
}
