package com.autoeurope.carrental.core;

import java.util.Scanner;
import com.autoeurope.carrental.util.GetRateInfo;
import com.autoeurope.carrental.util.Utils;
import java.util.HashMap;

public class RentalMainClass {

	/**
	 * @param args
	 */
   
    
	public static void main(String[] args) {

	   Scanner reader = new Scanner(System.in);  // Reading from System.in
           Utils utility = new Utils();
	   
	   System.out.println("Welcome To Car-Rental Portal");
	   System.out.println("Please Select Your Option Below");
	   
	   // A. Get Car Type
	   System.out.println("Please Select Your Car");
	   System.out.println("1. Mercedes");
	   System.out.println("2. Lada");
	   System.out.println("3. CHEVY MALIBU");
	   System.out.println("4. FORD FIESTA");
	   
	   System.out.println("Enter a number: ");
	   String carType = reader.next(); // Scans the next token of the input as an int.
	   
	  // System.out.println("Your Input Number Is  " + carType);

	   // B. Get Location
	   System.out.println("Please Select Your Location");
	   System.out.println("1. Charles De Gaulle Airport");
	   System.out.println("2. London Heathrow Airport");
	   System.out.println("3. Tokyo Narita Airport");
	   System.out.println("4. Boston Logan Airport");
	   
	   System.out.println("Enter a number: ");
	   String location = reader.next(); // Scans the next token of the input as an int.
	   
	   //System.out.println("Your Input Number Is  " + location);
	   
	   //C. Enter Date 
	   System.out.println("Please enter date range for car availability and price ");
	   System.out.print("Enter From Date (MM/dd/yyyy): ");
	   String dateFrom = reader.next();

	   System.out.print("Enter To Date (MM/dd/yyyy) : ");
	   String dateTo = reader.next();
	   //D. Search For availability and price
	   
           
	   double yourRate = 0;
	   try {
		  if(utility.isRequestedCarAvailable(carType, location)) {
			 
			   GetRateInfo getRateInfo = new GetRateInfo();
			   yourRate = getRateInfo.rate(carType, location, dateFrom , dateTo);
		  }
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   if(yourRate == 0 || yourRate == -1) {
		   System.out.println("Sorry No avaialbity or some genric message... please try one more time");
	   }else {
		   System.out.println("Congratulation !! You Get our best rate : " + yourRate);
		   
	   }
	  reader.close();
	
	}

        
}