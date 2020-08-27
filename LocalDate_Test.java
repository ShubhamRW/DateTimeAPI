package dateTimeDemo;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDate_Test {
	
	public static void main(String[] args) {
		
		System.out.println("---------- Traditional java.util.Date class ----------");
		//---> provides unnecessary time data which we don't need
		Date dt01 = new Date();
		System.out.println("java.uti.Date :: "+dt01);
		
		System.out.println("\n");
		
		System.out.println("---------- java.time.LocalDate object creation ----------");
		
		//LocalDate.now() --> gives the LocaDate object
		//       with current date in ISO 8601 format --> 1995-06-28
		LocalDate dt02 = LocalDate.now();
		System.out.println("LocalDate with now() :: "+dt02);
		
		//==> LocalDate.of(yyyy,MM/mm,dd) --> gives the LocalDate object
		//     of specified date values
		LocalDate dt03 = LocalDate.of(2010, 12, 25);
		LocalDate dt04 = LocalDate.of(2010, Month.DECEMBER, 25);
		System.out.println("LocalDate with of(-,-,-) dt03:: "+dt03);
		System.out.println("LocalDate with of(-,-,-) dt04:: "+dt04);
	
		//LocalDate.parse("2010-06-23");
		//---> gives the LocaDate object of the specified string Date
		//--> usefull to convert the Web obtained Dat to ISO date
		LocalDate dt05 = LocalDate.parse("2010-06-23");
		System.out.println("LocalDate with parse(-) :: "+dt05);
	
		System.out.println("\n");
		
		System.out.println("---------- java.time.LocalDate method to obtained it's values ----------");
		LocalDate dt06 = LocalDate.now();
		System.out.println("Year :: "+dt06.getYear());
		System.out.println("month :: "+dt06.getMonthValue());
		System.out.println("Month :: "+dt06.getMonth());
		System.out.println("Day number of the year :: "+dt06.getDayOfYear());
		System.out.println("Day number of the month :: "+dt06.getDayOfMonth());
		System.out.println("Day of the week of date :: "+dt06.getDayOfWeek());
		System.out.println("\n");
		
		System.out.println("---------- LocalDate Object Operations ----------");
		//ChronoUnit --> is a enum representing the different different units related to 
		//               the date and time like YEARS,MONTHS,DAYS etc.
		// ---> by specifying the different chrono units we can either plus or minus the the given time
		
		LocalDate dt5 = LocalDate.now().minus(10,ChronoUnit.DAYS);
		System.out.println("LocalDate after minus : "+dt5);
		
		LocalDate dt6= LocalDate.now().plus(2,ChronoUnit.MONTHS);
		System.out.println("LocalDate after plus : "+dt6);
		
		//you can perform the different plus operations
		LocalDate dt7 = LocalDate.now().plusWeeks(3);
		System.out.println("LocalDate after adding weeks with plusWeeks() : "+dt7);
		
		LocalDate dt8 = LocalDate.now().minusDays(8);
		System.out.println("LocalDate after minus days with minusDays() : "+dt8);
		
		//method to find is the year a leap year
		boolean isLeap = LocalDate.now().isLeapYear();
		System.out.println(isLeap?"Current Year is Leap Year":"Current Year is NOT a Leap Year");
		
		//to get the era
		System.out.println("Era is :"+LocalDate.now().getEra());
		
		//method to get the number of days in the year
		System.out.println("The Number of Days in the Year are :"+LocalDate.now().lengthOfYear());
		
		//with()
		System.out.println("with() :: "+LocalDate.now().withDayOfMonth(1).withMonth(2));
		
		System.out.println("\n");
		
		System.out.println("-----------java.time.LocaDate to java.sql.Date------------");
		LocalDate ld = LocalDate.parse("1995-02-04");
		java.sql.Date sqld = java.sql.Date.valueOf(ld);
		System.out.println("sqdl : "+sqld+":::: class : "+sqld.getClass() );
	}
}
