import java.util.Scanner;

class Sum{
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in );
int n = scanner.nextInt();
double s1 = 0, s2 = 0; 

for(int i = 1; i <= n; i++){
s1 += Math.pow(-1, i-1)/(i*i);
}
s2 = s1;
s2 += Math.pow(-1, n)/((n + 1)*(n + 1));
System.out.print(s2/s1);
}
}
