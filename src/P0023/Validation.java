/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.Scanner;

public class Validation {
    public static Scanner scan = new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                if (result < min || result > max){
                    System.out.print("Enter again: ");
                }else return result;
            }catch(NumberFormatException e){
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputString(){
        while(true){
            String result = scan.nextLine().trim();
            if(result.isEmpty()){
                System.out.print("Your input is empty, please try again: ");
            }else return result;
        }
    }
    
    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(scan.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }
    
    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(scan.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkInputYNOrder() {
        System.out.print("Do you want to order now(Y/N)? ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
