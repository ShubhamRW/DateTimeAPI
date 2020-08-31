package dateTimeDemo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocatTime_Test {
	public static void main(String[] args) {
		
		//==> LocalTime class object creation
		System.out.println("============ LocalTime object creation ============");
		//#1. --> with now() method gives current clock time with ISO format HH:MM:SS.ns
		//    --> it's a static factory method
		LocalTime t01 = LocalTime.now();
		System.out.println("LocalTime now() :: "+t01);
		
		//#2. --> with of(..) method creates LocalTime object with given time
		//    --> it's a static factory method with multiple overloaded form
		LocalTime t02 = LocalTime.of(6, 12,30,2555);
		System.out.println("LocalTime of(..) :: "+t02);
		
		//#3. --> with parse(CharSequece time) creates the LocalTime object
		//        from the specified string value
		//    --> it is also a static factory method
		//    --> we need to pass the ISO format time string else we get error
		//    --> if you want to work with other than ISO format we need to use DateTimeFormatter
		LocalTime t03 = LocalTime.parse("06:12:52.2555");
		System.out.println("LocalTime parse(-) :: "+t03);
		
		System.out.println("\n");
		
		System.out.println("============ LocalTime Static Class Variables ============");
		//==> we have 4 static variables in LocalTime class
		// 1. MAX  2.MIDNIGHT   3.NOON  4.MIN
		
		//#1. MAX :: gives maximum clock time in the day you can specify
		System.out.println("LocalTime MAX :: "+LocalTime.MAX);
		
		//#2. MIDNIGHT :: gives midnight clock time in the day i.e at the start of thd day
		System.out.println("LocalTime MIDNIGHT :: "+LocalTime.MIDNIGHT);
				
		//#1. MIN :: gives minimum clock time in the day you can specify
		System.out.println("LocalTime MIN :: "+LocalTime.MIN);
	
		//#1. NOON :: gives clock time of noon i.e middle of the day
		System.out.println("LocalTime NOON :: "+LocalTime.NOON);
		
		System.out.println("\n");
		
		System.out.println("============ LocalTime Different values ============");
		//==> with the given method we can retrieve the different values from the
		//    LocalTime class object like hour,minutes , second ,nanosecond etc.
		
		LocalTime t06 = LocalTime.now();
		System.out.println("Hour \t\t:: "+t06.getHour());
		System.out.println("Minites \t:: "+t06.getMinute());
		System.out.println("Secondss \t:: "+t06.getSecond());
		System.out.println("NanoSeconds \t:: "+t06.getNano());
		
		System.out.println("\n");
		
		System.out.println("============ LocalTime Different Operations ============");
		//--> minus operations
		System.out.println("Minus Operation1 :: "+LocalTime.now().minus(2, ChronoUnit.HOURS));
		System.out.println("Minus Operation2 :: "+LocalTime.now().minusHours(2));
		//--> plus operations
		System.out.println("Plus Operation1 :: "+LocalTime.now().plus(20, ChronoUnit.MINUTES));
		System.out.println("plus Operation2 :: "+LocalTime.now().plusMinutes(20));
		
		System.out.println();
		
		//calculate the seconds from the start of the day given day to now
		System.out.println("seconds in day uptp now ::"+LocalTime.now().toSecondOfDay());
		
		//with() methods
		System.out.println("with() :: "+LocalTime.now().withMinute(25).withSecond(35));
		
		System.out.println();
		
		//isAfter and isBefore to compare time 
		LocalTime officeStartTime = LocalTime.now().withHour(6);
		LocalTime officeEndTime = LocalTime.now().withHour(16);
		
		System.out.println("officeStartTime isBefore officeEndTime ? "+officeStartTime.isBefore(officeEndTime));
		System.out.println("officeStartTime isAfter officeEndTime ? "+officeStartTime.isAfter(officeEndTime));
		
		System.out.println();
		
		//truncateTo(-) method truncate the given time from the given unit
		LocalTime time = LocalTime.now();
		System.out.println("currentTime :: "+time);
		System.out.println("currentTime with trucating to second : "+time.truncatedTo(ChronoUnit.SECONDS));
		System.out.println("currentTime with trucating to Minutes : "+time.truncatedTo(ChronoUnit.MINUTES));
		System.out.println("currentTime with trucating to Hours : "+time.truncatedTo(ChronoUnit.HOURS));
			
	}
}
