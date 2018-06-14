/**
 *  Gets the car rate details from Database
 */
package com.autoeurope.carrental.util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author shraddha bhatt
 *
 */
public class GetRateInfo {

	DBConnection connection = new DBConnection();
        HashMap<String, String> getCarType = new HashMap<String, String>();
        HashMap<String, String> getLocation = new HashMap<String, String>();

	// constructor
	public GetRateInfo() {
            
       
        //Later on we can get genrate dynamic map value from dataBase for Car_Model and AirPort_Location    
        getCarType.put("1", "Mercedes");
        getCarType.put("2", "Lada");
        getCarType.put("3", "CHEVY MALIBU");
        getCarType.put("4", "FORD FIESTA");

        getLocation.put("1", "Charles De Gaulle Airport");
        getLocation.put("2", "London Heathrow Airport");
        getLocation.put("3", "Tokyo Narita Airport");
        getLocation.put("4", "Boston Logan Airport");
    
    	 
            // TODO Auto-generated constructor stub
	}
        
        // calculate number of days 
	public long getDateDiff(String dateFrom, String dateTo){
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		long diffDays = 0;
		try{
			Date dfrom = format.parse(dateFrom);
			Date dto = format.parse(dateTo);
			
			//in milliseconds
			long diff = dfrom.getTime() - dto.getTime();
			
			// number of days
			diffDays = diff / (24 * 60 * 60 * 1000);
		
		}catch(Exception e){
                    System.out.println("Error in date calculation : "+e);
		}
		return diffDays;
	}
        
	// get to know the demand based on the season.
	public int getSeason(String dateFrom){
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		int season = 5;
		try{
			Date dfrom = format.parse(dateFrom);
			Calendar now = GregorianCalendar.getInstance();
			now.setTime(dfrom);
			int month = now.get(Calendar.MONTH);
			
			if(month > 11 && month < 3)
				season = 5;
			else if(month > 2 && month < 6)
				season = 6;
			else if(month > 5 && month < 9)
				season = 7;
			else if(month > 8  && month < 12)
				season = 8;
				
		}catch(Exception e){
			System.out.println("Error in date calculation : "+e);
		}
		return season;
        }
        
        // calculate best rate - incomplete code
	public double rate(String carType, String location, String dateFrom, String dateTo) throws Exception {
		
                String carmodel = getCarType.get(carType);
                String airport = getLocation.get(location);
		int demand = getSeason(dateFrom);
                System.out.println("Demand : "+demand);
        		
		Connection db = connection.getConnection();
		// query database         
		ResultSet rs = db.createStatement().executeQuery("select * from car where airport = '"+airport+"' and carmodel = '"+carmodel+"'");  
        
                double calRate = 0;

                System.out.println("Price : "+rs.getDouble(demand));

                long days = getDateDiff(dateFrom, dateTo);
					
		return calRate;
	}

}
