package com.pk.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigTest 
{
  public static void main(String arg[])
  {
	  
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("com.pk");
	  context.refresh();
  }
	

}
