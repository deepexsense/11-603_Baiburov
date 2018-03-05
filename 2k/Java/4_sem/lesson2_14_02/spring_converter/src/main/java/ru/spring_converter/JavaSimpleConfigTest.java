package ru.spring_converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class JavaSimpleConfigTest {

  public static void main(String[] args) {
    ApplicationContext context
      = new AnnotationConfigApplicationContext(SimpleConfig.class);
    
    Conventer obj = (Conventer) context.getBean("conventer");
    System.out.println( obj.getConventer(2));
    

    System.out.println( obj.getConventer(1) );
  }
}
