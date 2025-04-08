package anujaK.SeleniumCodes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy hh:mm:ssss");
		System.out.println(simpleDateFormat.format(date));
	}

}
