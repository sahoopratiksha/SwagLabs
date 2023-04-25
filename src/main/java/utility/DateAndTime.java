package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	
	public static String GetDateTime() {
		
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter type=DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String DateTime=time.format(type);
		return DateTime;
	}

}
