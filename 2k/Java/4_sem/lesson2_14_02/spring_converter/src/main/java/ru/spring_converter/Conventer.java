package ru.spring_converter;

import java.util.Scanner;

public class Conventer {

  private int ch = 1;

  public Conventer() {
  }

  public Conventer(int ch) {
    this.ch = ch;
  }

  public float getConventer(int ch) {

        Scanner keyboard = new Scanner(System.in);

        float res = 0;

        if(ch == 1){
          float XUSD = (float) 1.64;
           res= keyboard.nextFloat() * XUSD;
          System.out.println("USD: ");
          return res;

        } else if (ch == 2){
          float XGBP = (float) 0.64;
           res= keyboard.nextFloat() * XGBP;
          System.out.println("GBP: ");
          return res;
        }
        return res;
  }

  public int getCh() {
    return ch;
  }

  public void setCh(int ch) {
    this.ch = ch;
  }

}
