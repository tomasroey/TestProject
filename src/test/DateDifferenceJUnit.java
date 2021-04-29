package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateDifferenceJUnit {
	public static int output=0;

	@Test
	public void test() {
		DateDifference junit = new DateDifference();
		boolean check1, check2 ;
		String date1;
		String date2;
		
		//SET 1 TEST CASE
		date1 = "15 01 1991";
		date2 = "01 02 1991";
		check1 = junit.dateValidator(date1);
		junit.flag++;
		check2 = junit.dateValidator(date2);
		if(check1 && check2){
		output = junit.differenceCalculation(date1, date2);
		assertEquals(17, output);
		}
		
		junit.flag=0;
		junit.totalDays=0;
		//SET 2 TEST CASE
		date1 = "16 11 2003";
		date2 = "01 12 2003";
		check1 = junit.dateValidator(date1);
		junit.flag++;
		check2 = junit.dateValidator(date2);
		if(check1 && check2){
		output = junit.differenceCalculation(date1, date2);
		assertEquals(15, output);
		}
		
		junit.flag=0;
		junit.totalDays=0;
		//SET 3 TEST CASE
		date1 = "15 01 1991";
		date2 = "01 02 1991";
		check1 = junit.dateValidator(date1);
		junit.flag++;
		check2 = junit.dateValidator(date2);
		if(check1 && check2){
		output = junit.differenceCalculation(date1, date2);
		assertEquals(17, output);
		}
		
		junit.flag=0;
		junit.totalDays=0;
		//SET 4 TEST CASE
		date1 = "02 11 1901";
		date2 = "30 12 2009";
		check1 = junit.dateValidator(date1);
		junit.flag++;
		check2 = junit.dateValidator(date2);
		if(check1 && check2){
		output = junit.differenceCalculation(date1, date2);
		assertEquals(39505, output);
		}
		
		junit.flag=0;
		junit.totalDays=0;
		//SET 5 TEST CASE
		date1 = "31 03 1911";
		date2 = "29 02 2000";
		check1 = junit.dateValidator(date1);
		junit.flag++;
		check2 = junit.dateValidator(date2);
		if(check1 && check2){
		output = junit.differenceCalculation(date1, date2);
		assertEquals(32477, output);
		}
//		output = junit.differenceCalculation("15 02 1992", "01 10 2001");
//		assertEquals(3516, output);
//		output = DateDifference.differenceCalculation("02 11 1901", "30 12 2009");
//		assertEquals(39505, output);
//		output = DateDifference.differenceCalculation("31 03 1911", "29 02 2000");
//		assertEquals(32477, output);
//		output = DateDifference.differenceCalculation("06 10 1991", "24 10 1991");
//		assertEquals(18, output);
//		output = DateDifference.differenceCalculation("16 01 2003", "01 12 2003");
//		assertEquals(319, output);
//		output = DateDifference.differenceCalculation("16 11 2003", "01 12 2003");
//		assertEquals(15, output);
	}

}
