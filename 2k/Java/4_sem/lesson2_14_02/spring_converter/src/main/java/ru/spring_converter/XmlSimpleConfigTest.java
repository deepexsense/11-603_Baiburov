package ru.spring_converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class XmlSimpleConfigTest {

  public static void main(String[] args) {
    new XmlSimpleConfigTest();
  }
  
  public XmlSimpleConfigTest(){
    ApplicationContext context = 
             new FileSystemXmlApplicationContext(getClass().getResource("/SimpleConfigConventer.xml").toString());
    
    Conventer obj = (Conventer) context.getBean("conventer");
    System.out.println( obj.getConventer(2) );
    
    //obj.setCh(2);
    System.out.println( obj.getConventer(1) );
  }
}
