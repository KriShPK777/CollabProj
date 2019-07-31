package com.pk.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigDBTest 
{
  public static void main(String arg[])
  {
	  
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("com.pk");
	  context.refresh();
	  System.out.println("Configuration Successfull");
  }
	

}
