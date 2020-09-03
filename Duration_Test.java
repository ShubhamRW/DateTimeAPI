package dateTimeDemo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Duration_Test {
	public static void main(String[] args) {
		
		//------------------ # Duration ------------------
		
		System.out.println("------------------ # Duration ------------------");
		
		LocalTime t1 = LocalTime.now();
		LocalTime t2 = LocalTime.parse("20:12:51.25555");
		//-->  gives duration between two time objects
		//-->  Duration Format ::  PT<hour>H<minutes>M<seconds>S
		Duration dur = Duration.between(t2, t1);
		System.out.println("Duration between t1 and t2 :: "+dur);
		
		System.out.println();

		//--> in Duration we can work with LocalDateTime which was not possible in Period
		
		LocalDateTime dt1 = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.parse("1995-02-04T20:12:51.25555");
		//--> in Duration we can work with LocalDateTime which was not possible in Period
		//--> even if try to find the duration between two date time it gives duration in
		//     the PT<hour>H<minutes>M<seconds>S format only
		System.out.println("Duration between dt1 and dt2 :: "+Duration.between(dt2, dt1));
		
		//---> LocalDate object with Duration class method
		/*
		 * LocalDate d1 = LocalDate.now(); LocalDate d2 = LocalDate.parse("2018-03-25");
		 * 
		 * System.out.println(Duration.between(d2, d1));
		 */
		System.out.println();
		
		//comparing two durations
		System.out.println("Duration compare : "+dur.compareTo(Duration.between(dt2, dt1)));
		
		System.out.println();
		
		//getting dates in different units
		System.out.println("nanos   : "+Duration.between(dt2, dt1).toNanos());
		System.out.println("minutes : "+Duration.between(dt2, dt1).toMinutes());
		System.out.println("hours   : "+Duration.between(dt2, dt1).toHours());
		System.out.println("days    : "+Duration.between(dt2, dt1).toDays());
		
		System.out.println();
		
		//units in the duration
		System.out.println("Unit used by Duration ."+Duration.between(dt2, dt1).getUnits());
	}
}
