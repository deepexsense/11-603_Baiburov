import java.util.Scanner;

class RectangleMethod {
	public static double[] generateX(double a, double b , int inf) {
    double[] x = new double[inf];
    double q = (a - b)/inf;
		for(int i = 0; i < inf; i++){
      x[i] = a + i*q;
    }
    return x;
	}

	// x - точки отрезка [a,b]

	public static double calc(double x[],int inf) {
    double sum = 0;
    for(int i = 0; i< inf - 1; i++){
      sum += func(x[i]) * (x[i+1] - x[i]);
    }
		// реализуем метод
		// результат - сумма площадей прямоугольников
		// площадь прямоугольника - func(x[i]) * (x[i+1] - x[i])
    return sum;
	}

	public static double func(double w) {
		return Math.cos(w);
	}

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    int infi = scanner.nextInt();
    double[] z = new double[infi];
    z = generateX(a,b,infi);
    System.out.print(calc(z,infi));
  }

}
