import java.util.Scanner;

class Infa2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pr = 1;
		int s = 0;
		int a;
		int b;
		a = scanner.nextInt();
		while (a != -999) {
			if (a%2==0) {
				pr = pr * a;
			}
			if (a < 0) {
				s = s + a;
			}
			a = scanner.nextInt();
		}
		System.out.println("Произведние = " + pr +" "+"Сумма = " + s);
	}
}
