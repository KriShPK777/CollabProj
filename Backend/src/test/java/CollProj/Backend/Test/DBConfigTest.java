package CollProj.Backend.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigTest 
{
  public static void main(String arg[])
  {
	  
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("CollProj.Backend");
	  context.refresh();
  }
	

}
