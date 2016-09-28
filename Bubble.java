class Bubble{
  public static void main(String[] args) {
    int a[] = {-3, -7, 10, 11, -5, 2};

    for (int i = a.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j+1]) {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
        } else {
          j = j + 1;
        }
      }
    }

        for (i = 0; i < a.length; i++) {
          System.out.println(a[i]);
        }

  }
}
