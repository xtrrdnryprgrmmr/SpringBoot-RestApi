package com.example.demo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.example.demo.*;
public class TestDeneme {

CalculateNumber  calculation_for_numbers=new CalculateNumber();
CalculatorController calculation_controller=new CalculatorController();




@Test
public void testing_multiple_add() throws Exception
{
	String given_result="23";
	String expected_result="{\r\n" + 
			"    \"numbers\": [8,4,2,1,8]\r\n" + 
			
			"}";
	CalculateNumber calculate_multiple_add=new CalculateNumber();
	calculate_multiple_add=calculation_controller.multipleadd(expected_result);
	assertEquals(given_result, calculate_multiple_add.getResult());
}

@Test
	public void testing_multiple_multiply() throws Exception
	{
		/*String result="{\r\n" + 
				"    \"numbers\": [],\r\n" + 
				"    \"result\": \"512\"\r\n" + 
				"}";
				*/
	   
	   //given
	   String given_result="512";
		String expected_result="{\r\n" + 
				"    \"numbers\": [8,4,2,1,8]\r\n" + 
				
				"}";
		
	   	CalculateNumber calculate_multiple_multiply=new CalculateNumber();
	   	
	   	
	   	calculate_multiple_multiply=calculation_controller.multiplemultiply(expected_result);
	 
		assertEquals(given_result, calculate_multiple_multiply.getResult());
	}
 @Test
	public void testing_multiple_subtract() throws Exception
	{
		String given_result="-23";
		String expected_result="{\r\n" + 
				"    \"numbers\": [8,4,2,1,8]\r\n" + 
				
				"}";
		CalculateNumber calculate_multiple_subtract=new CalculateNumber();
		calculate_multiple_subtract=calculation_controller.multiplesubtract(expected_result);
		assertEquals(given_result, calculate_multiple_subtract.getResult());
		
	}
}
