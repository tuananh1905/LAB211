//https://docs.google.com/document/d/1bfq7ruDNSXQFk3ufwXgmAcID1WvaP1LJ/edit#
package P0103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(dob1BeforeDob2()) System.out.println("Date1 is before Date2");
        else System.out.println("Date2 is before Date1");
    }
    
    public static boolean dob1BeforeDob2(){
        Date date1 = inputDate("first");
        Date date2 = inputDate("second");
        return date1.before(date2);
    }
    
    public static Date inputDate(String amount){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Please enter the "+amount+" date with [dd/mm/yyyy] format: ");
                String dob = scan.next();
                Date date = formatter.parse(dob);
                return date;
            }catch(ParseException e){
                System.err.println("You need to enter correct [dd/mm/yyyy] format.");
            }
        }
    }
    
}
