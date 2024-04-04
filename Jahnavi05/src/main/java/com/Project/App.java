package com.Project;









import org.hibernate.cfg.Configuration;







/**
 * Hello world!
 *
 */
public class App 
{
	

	public static void main( String[] args )
    {
		System.out.println( "WELCOME" );
		System.out.println( "The Project begins HERE !!!!!!........" );
		
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
     
		
        
        
    }
}