package dateTimeDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Period_Test {
	public static void main(String[] args) {
		
		//-------------- # Period Class -----------------
		//==> Period class is there to find the Period or Duration between two dates only
		//    or the Period of given date quantities and cannot be used to differenciate the time
		
		
		System.out.println("-------------- # Period Class -----------------");
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.parse("1995-02-04");
		
		//==> Period.between(-,-)
		//--> to find the period between to dates use between(-,-) method
		//--?period gives difference between two dates in the Format of :: P<year>Y<months>M<days>D
		Period p1 = Period.between(d2, d1);
		
		System.out.println("period between d1 and d2 : "+p1);
		
		//--> Remember Period class is used to find the difference between two dates
		//     and we cannot use this class to calculate difference between to LocalDateTime
		//     between this object contains which cannot be differenciated with the Period class.
		
		
		//Note :: we cannot exceed the value limit of data class places like month cannot be
		//----    greater than 12 and  date should be less than or equal to the days in the 
		//		  specified month otherwise you will get Exception
		
		//System.out.println(LocalDate.parse("1932,16,35")); // ==> INVALID
		
		System.out.println();
		
		//--> if you want to retrieve the individual days, months, years value from the given 
		//    period use following method
		System.out.println("periodObj.getDays() to retrive Days   :: "+p1.getDays());
		System.out.println("periodObj.getDays() to retrive Months :: "+p1.getMonths());
		System.out.println("periodObj.getDays() to retrive Years  :: "+p1.getYears());
		
		System.out.println();
		//--> to check the supported units list
		System.out.println(p1.getUnits());
		
		System.out.println();
		
		//creating period
		System.out.println("ofMonths() :"+Period.ofMonths(65));
		System.out.println("ofDays() :"+Period.ofDays(65));
		System.out.println("ofYears() :"+Period.ofYears(65));
		
		System.out.println("period :: "+Period.of(6, 4, 25));
		
		System.out.println();
		//use the existing period to subtract from given date
		Period p2 =Period.of(6, 4, 25);
		System.out.println("subtracting given period from the date ::"+p2.subtractFrom(LocalDate.now()));
		
		System.out.println();
		//to get total months
		System.out.println(p1.toTotalMonths());
	}
}
