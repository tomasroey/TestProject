package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DateDifference {
	
	public static int totalDays = 0;
	public static int date1 = 0, date2 = 0 ;
	public static int month1 = 0, month2 = 0 ;
	public static int year1 = 0, year2 = 0; 
	public static int flag = 0;
	
	//DATE FORMAT VALIDATOR
	public static boolean dateValidator(String date){
		StringTokenizer tok = new StringTokenizer(date," ");
		int day=0;
		int month=0;
		int year=0;
		if(flag==1){
			day = date2 = Integer.parseInt(tok.nextToken());
			month = month2 = Integer.parseInt(tok.nextToken());
			year = year2 = Integer.parseInt(tok.nextToken());		
		}else{
			day = date1 = Integer.parseInt(tok.nextToken());
			month = month1 = Integer.parseInt(tok.nextToken());
			year = year1 = Integer.parseInt(tok.nextToken());	
		}
		if(date.matches("\\d{2} \\d{2} \\d{4}")){
			if(year < 2011 && day <= 31 && month <= 12){
				int dateCheck=0;
				if((month%2==0 && month<=7 && month!=2)||(month%2!=0 && month>7)){
					dateCheck = 30;
				}else if((month%2!= 0 && month<=7 && month!=2)||(month%2== 0 && month>7)){
					dateCheck = 31;
				}else if(month==2 && ((year%4==0)&&(year%100!=0)||(year%400==0))){
					dateCheck = 29;
				}else if(month==2 && !((year%4==0)&&(year%100!=0)||(year%400==0))){
					dateCheck = 28;
				}
				if(day>dateCheck){
					System.out.println("Invalid date!\n");
					return false;
				}else{
					return true;
				}
			}else{
				return false;
			}
		}
		else{
			System.out.println("Invalid date format!\n");
			return false;
		}
	}
	
	public static int differenceCalculation(String d1, String d2){
		try{
		//Finding the difference of the two dates
		boolean isLeapYear ;
		int flag=0;
		for(int i=year1;i<=year2;i++){
			if((i%4==0)&&(i%100!=0)||(i%400==0)){
				isLeapYear = true;
			}else{
				isLeapYear=false;
			}
			
			if(i==year1 || i==year2){
				int m=0;
				int d=0;
				int limit=0;
				if(i==year1 && year1!=year2){
					m=month1;
					d=date1;
					limit=12;
				}else if(i==year2 && year1!=year2){
					m=1;
					d=date2;
					limit=month2;
				}else if(year1==year2){
					flag++;
					m=month1;
					d=date1;
					limit=month2;
				}else{
					m=month2;
					d=date2;
					limit=m;
				}
				for(int j=m; j<=limit;j++){
					if((j==m && i!=year2)){
						if((j%2==0 && j<=7 && j!=2)||(j%2!=0 && j>7)){
							totalDays += 30-d;
						}else if((j%2!= 0 && j<=7 && j!=2)||(j%2== 0 && j>7)){
							totalDays += 31-d;
						}else if(j==2 && isLeapYear){
							totalDays += 29-d;
						}else if(j==2 && !isLeapYear){
							totalDays += 28-d;
						}
					}else if((flag==1)){
						if(month1==month2){
							totalDays = date2 - d;
						}else if(j==month2){
							totalDays += date2;
						}else if(j==month1){
							if((j%2==0 && j<=7 && j!=2)||(j%2!=0 && j>7)){
								totalDays += 30-d;
							}else if((j%2!= 0 && j<=7 && j!=2)||(j%2== 0 && j>7)){
								totalDays += 31-d;
							}else if(j==2 && isLeapYear){
								totalDays += 29-d;
							}else if(j==2 && !isLeapYear){
								totalDays += 28-d;
							}
						}else{
							if((j%2==0 && j<=7 && j!=2)||(j%2!=0 && j>7)){
								totalDays += 30;
							}else if((j%2!= 0 && j<=7 && j!=2)||(j%2== 0 && j>7)){
								totalDays += 31;
							}else if(j==2 && isLeapYear){
								totalDays += 29;
							}else if(j==2 && !isLeapYear){
								totalDays += 28;
							}
						}
					}else if(j==month2 && i==year2){
							totalDays += d;
					}else{
						if((j%2==0 && j<=7 && j!=2)||(j%2!=0 && j>7)){
							totalDays += 30;
						}else if((j%2!= 0 && j<=7 && j!=2)||(j%2== 0 && j>7)){
							totalDays += 31;
						}else if(j==2 && isLeapYear){
							totalDays += 29;
						}else if(j==2 && !isLeapYear){
							totalDays += 28;
						}
					}
				}
			}else if (isLeapYear){
				totalDays +=366;
			}else {
				totalDays +=365;
			}
		}
		}catch(Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return totalDays;
	}
	
	//MAIN FUNCTION
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter date 1 [please follow this format - [DD MM YYYY] and year after 1900:\n");
		String d1 = inp.nextLine();
		boolean date1Validation = dateValidator(d1);
		System.out.println("Enter date 2 [please follow this format - [DD MM YYYY] and year before 2010:\n");		
		String d2 = inp.nextLine();
		flag++;
		boolean date2Validation = dateValidator(d2);
		if(date1Validation && date2Validation){
			if(differenceCalculation(d1, d2)!=0){
				System.out.println(d1 + ", "+ d2 + ", " + totalDays);
				}else{
				System.out.println("Invalid dates");
				}
		}
		
	}
}
