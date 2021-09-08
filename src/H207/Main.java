//https://docs.google.com/document/d/1s4Snq53V6zwDwR02dW5mlAVzPi4jECNm/edit
package H207;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = checkInputString();
        System.out.println("Amount letters in the string "+"\""+s+"\""+" is: "+secondHalfLetters(s.toLowerCase()));
    }
    
    public static String checkInputString(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your string: ");
        while(true){
            String result = scan.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Your string is empty.");
                System.out.print("Enter again: ");
            }else return result;
        }
    }
    
    public static int secondHalfLetters(String s){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.codePointAt(i)>=110 && s.codePointAt(i)<=122) count++;
        }
        return count;
    }
}
