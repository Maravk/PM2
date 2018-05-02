/*
 * @author: Mara von Kroge
 * @author: Rene Hagemann
 */

package de.renehagemann.haw.pm2;
import java.time.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
 
/* K�nnen jetzt wenigstens einen begrenzten Stream aufrufen,
 * jetzt muss nur noch das Ergebnis gefiltert werden k�nnen. 
 */

public class DateCalculator {

    public static void main(String[] args)
    {
    	/*
    	 * Aufgabe 1.1	
    	 */
    	// gesamter Stream wird geprinted (auskommentiert)
        // System.out.println( getDaysInJava8(LocalDate.now(), (2100-1889)*365) );

        
        
        /* 
         * Aufgabe 1.3.1
         */

        LocalDate firstofmay = LocalDate.of(2018,5,1);
        System.out.println(nextSunday(firstofmay));
        
        /*
         * Aufgabe 1.3.2
         */
        
        int leapyear = firstofmay.getYear();
        System.out.println("The year of your date: "+ leapyear);
        System.out.println("The next Leapyear: " + nextLeapYear(leapyear));
        
        /*
         * Aufgabe 1.3.3
         */
        
       
    }
    public static int nextLeapYear(int year) {

        if (year % 4 == 0)
        {
           return year;
        }
        else
        {
            year = year + (year % 4);
            return year;
            
        }        
    }
    
    
    public static LocalDate nextSunday(LocalDate date) {
    	return date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }
 
    //Stream of dates with 1 day difference
    public static List<LocalDate> getDaysInJava8(LocalDate start, int days)
    {
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(days)
                .collect(Collectors.toList());
    }
}