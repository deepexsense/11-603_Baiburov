import java.util.Scanner;

class Infa {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 18732;
        int a5000 = a / 5000;
        int c = a % 5000;
        int a1000 = c / 1000;
        int e = c % 1000;
        int a500=e/500;
        int g=e%500;
        int a100=g/100;
        int i=g%100;
        int a50=i/50;
        int h=i%50;
        int a10=h/10;
        int x=h%10;
        int a5=x/5;
        int y=x%5;
        int a2=y/2;
        int z=y%2;
        int a1=z/1;
        int t=z%1;
        System.out.println(a5000+" "+a1000+" "+a500+" "+a100+" "+a50+" "+a10+" "+a5+" "+a2+" "+a1);
    }
}
