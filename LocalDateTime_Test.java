package dateTimeDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTime_Test {
	public static void main(String[] args) {
		//## ==> it is a combination of LocalDate and LocalTime without
		//       time offset and is given in ISO 8601 standard.
		//                  yyyy-mm-dd T HH:MM:SS.ns
		
		//==> different ways to create the LocalDateTime object
		System.out.println("============= Object Creation =============");
		//#1. --> with now() method
		LocalDateTime ldt1 = LocalDateTime.now();
		System.out.println("LocalDateTime now() \t:: "+ldt1);
		
		//#2. --> with of(..) method
		LocalDateTime ldt2 = LocalDateTime.of(2012,02,04,06,25,26,26666);
		System.out.println("LocalDateTime of(..) \t:: "+ldt2);
		
		//#3. --> with parse(-) method
		LocalDateTime ldt3 = LocalDateTime.parse("2016-08-26T16:32:34.092");
		System.out.println("LocalDateTime parse(-) \t:: "+ldt3);
		
		System.out.println("\n");
		
		System.out.println("============= Different Operation and Value Retrieving =============");
		
		LocalDateTime ldt4 = LocalDateTime.now();
		System.out.println("Year \t::"+ldt4.getYear());
		System.out.println("month \t::"+ldt4.getMonthValue());
		System.out.println("Day \t::"+ldt4.getDayOfMonth());
		System.out.println("Hour \t::"+ldt4.getHour());
		System.out.println("Minutes ::"+ldt4.getMinute());
		System.out.println("Seconds ::"+ldt4.getSecond());
		System.out.println("Nano\t::"+ldt4.getNano());
		
		System.out.println();
		
		// ==> Temporal is a interface having many implementations like
		//     LocalDate, LocalDateTime , HijrahDateTime, JapaneseDateTime etc.
		
		// until(-,-) method calculate the specified unit value upto the specified instance.
		System.out.println("LocalDateTime until() ::"+LocalDateTime.now().until(LocalDateTime.now().withYear(2022), ChronoUnit.DAYS));
		
		System.out.println();
		
		System.out.println("MAX :: "+LocalDateTime.now().MAX);
		System.out.println("MIN :: "+LocalDateTime.now().MIN);
		
		System.out.println();
		
		// --> you cannot truncate the LocalDateTime value more than DAYs because
		// 	 truncate is not applicable for Date part it is there for only time part
		//   because you can say averegly but not the date.
		System.out.println("truncateTo :: "+LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
	
	
		System.out.println();
			
		System.out.println("============= TemporalField =============");
		
		//   				TemporalField
		// =====================================================
		// --> TemporalField is a interface in java.time.temporal interface
		// --> it is a data time field like DayOfYear, DayOfMonth etc
		// --> in general it provides the partition for the time line in human understandable way
		// --> Temporal interface is implemented by ChronoField having different constants representing fields
		
		//==> use in LocalDate class
		LocalDate d1 = LocalDate.now();
		
		System.out.println("LD DAY_OF_WEEK :: "+d1.get(ChronoField.DAY_OF_WEEK));
		System.out.println("LD isSupported :: "+d1.isSupported(ChronoField.DAY_OF_YEAR));
		System.out.println("LD with​(field,value) :: "+d1.with(ChronoField.DAY_OF_WEEK,6));
		
		System.out.println();
		
		//==> use in LocalTime class
		LocalTime t1 = LocalTime.now();
		
		System.out.println("LT DAY_OF_WEEK :: "+t1.get(ChronoField.CLOCK_HOUR_OF_AMPM));
		System.out.println("LT isSupported :: "+t1.isSupported(ChronoField.DAY_OF_WEEK));
		System.out.println("LT with​(field,value) :: "+t1.with(ChronoField.HOUR_OF_DAY,6));
		
		System.out.println();
		
		//==> use in LocalDateTime 
		//--> above three are applicable
		LocalDateTime localDT = LocalDateTime.now();
		//range(field) gives the range of field in the given data time like for given year which is leap
		//  range is 0-366
		System.out.println(localDT.range(ChronoField.SECOND_OF_DAY));
		
	}
}
