/*
 * @author: Mara von Kroge
 * @author: Rene Hagemann
 */

package de.renehagemann.haw.pm2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DifferenceBetweenDates {
	private long gap;
	private LocalDate firstDate;
	private LocalDate secondDate;
	
	public DifferenceBetweenDates(LocalDate a, LocalDate b) {
		firstDate = a;
		secondDate = b;
		gap = ChronoUnit.DAYS.between(firstDate, secondDate);
	}
	public void printDifference() {
		System.out.println("Difference between the 2 dates in Days: " + gap);
	}
}
