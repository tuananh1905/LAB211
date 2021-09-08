package P0055;

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
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputStringEmpty(String s){
        String result = scan.nextLine().trim();
        if(result.isEmpty()){
            System.err.println("Your input is empty, this information not change!");
            return s;
        }
        return result;
    }
    
    public static int checkInputIntEmpty(int i){
        while(true){
            try{
                String result = scan.nextLine().trim();
                if(!result.isEmpty()){
                    System.err.println("Your input is empty, this information not change!");
                    return Integer.parseInt(result);
                }else{
                    return i;
                }
            } catch (NumberFormatException e){
                System.out.print("Enter again: ");
            }
        }
    }
    
    
}
