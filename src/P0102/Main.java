//https://docs.google.com/document/d/1Qkzq--yo5s4lR8mW5jNCr3BkD2dKstfV/edit#
package P0102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter date with format [dd/mm/yyyy]: ");
        String dob = scan.next();
        int day = stringToDate(dob);
        String[] arr = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("Your day is "+arr[day]);
    }

    public static int stringToDate(String dob) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dob);
        return date.getDay();
    }
}
