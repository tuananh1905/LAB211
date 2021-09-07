package P0055;

import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    private final static Scanner scan = new Scanner(System.in);
    
    public static int checkInputIntLimit(int min, int max){
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
    
    public static String checkInputString(){
        while(true){
            String result = scan.nextLine().trim();
            if(result.isEmpty()){
                System.out.print("Your input is empty, please try again: ");
            }else return result;
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                return result;
            } catch (NumberFormatException e){
                System.out.println("Enter again");
            }
        }
    }
    
    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code){
        for (int i = 0; i < ld.size(); i++) {
            if(code.equalsIgnoreCase(ld.get(i).getCode())){
                return false;
            }
        }
        return true;
    }
    public static boolean checkNameExist(ArrayList<Doctor> ld, String name){
        for (int i = 0; i < ld.size(); i++) {
            if(name.equalsIgnoreCase(ld.get(i).getName())){
                return false;
            }
        }
        return true;
    }
    public static boolean checkSpecializationExist(ArrayList<Doctor> ld, String specialization){
        for (int i = 0; i < ld.size(); i++) {
            if(specialization.equalsIgnoreCase(ld.get(i).getSpecialization())){
                return false;
            }
        }
        return true;
    }
    public static boolean checkAvailabilityExist(ArrayList<Doctor> ld, int availability){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getAvailability() == availability){
                return false;
            }
        }
        return true;
    }
}
