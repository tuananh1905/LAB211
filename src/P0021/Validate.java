/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0021;

import java.util.Scanner;

/**
 *
 * @author TuanAnh
 */
public class Validate {
    public Scanner scan = new Scanner(System.in);
    
    public int checkIntLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                if (result < min || result > max){
                    System.out.println("You must choice number in range "+min+" up to "+max);
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
    
    public boolean checkInputYN() {
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
    
    public String checkInputUD() {
        System.out.print("Do you want to update (U) or delete (D) student: ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U") || result.equalsIgnoreCase("D")) {
                return result;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
    
    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(scan.nextLine().trim());
                if(result>0) return result;
                else {
                    System.out.println("Semester must bigger than 0.");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkCouse() {
        while (true) {
            String str = scan.nextLine();
            if (str.equalsIgnoreCase("java")
                    || str.equalsIgnoreCase("c/c++")
                    || str.equalsIgnoreCase(".net")) {
                return str;
            }else{
                System.out.println("Only 3 course: java, .net, c/c++");
                System.out.print("Enter again: ");
            }
        }
    }
}
