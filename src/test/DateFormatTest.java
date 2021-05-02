package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = format.format(new Date());
		System.out.println(strDate);
	}

}
