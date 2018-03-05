package ru.spring_converter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class XmlScanningConfigTest {

  public static void main(String[] args) {
    new XmlScanningConfigTest();
  }
  
  public XmlScanningConfigTest(){
    ApplicationContext context
      = new FileSystemXmlApplicationContext(getClass().getResource("/ScanningConfigConventer.xml").toString());
    
    Conventer obj = (Conventer) context.getBean("conventer");
    System.out.println( obj.getConventer(2) );
    
   // obj.setCh(1);
    System.out.println( obj.getConventer(1));
  }

}
