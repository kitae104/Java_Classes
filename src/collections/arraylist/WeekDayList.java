package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class WeekDayList {
    public static void main(String[] args) {

        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("월");
        weekdays.add("금");
        weekdays.add("일");

        weekdays.add(1, "수");

        Collections.reverse(weekdays);

        for (String day : weekdays) {
            System.out.println(day);
        }

        Vector<String> veclist = new Vector<>();
        veclist.add("월");
        veclist.add("금");
        veclist.add("일");



    }
}
