//https://docs.google.com/document/d/1nYlaEk_66CLataI2nH6nylNBvsNJaNuW/edit
package H208;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number after swap: "+swapDigitPairs(checkInputInt()));
    }
    
    public static int checkInputInt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number need to swap digit: ");
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                if (result>=0) return result;
                else { 
                    System.err.println("You need to be enter a positive.");
                    System.out.print("Enter again: ");
                }
            }catch(NumberFormatException e){
                System.err.println("You need to be enter a integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static int swapDigitPairs(int number){
        int result=0;
        int place=1;
        while(number>=10){
            result += place * 10 * (number % 10);
            number /= 10;
            result += place * (number % 10);
            number /=10;
            place *= 100;
        }
        return result + place * number;
    }
}
