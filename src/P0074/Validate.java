package P0074;

import java.util.Scanner;

public class Validate {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static int checkInputLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                if(result<min || result>max){
                    System.out.print("Enter again: ");
                }else return result;
            }catch(NumberFormatException e){
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                return result;
            }catch(NumberFormatException e){
                System.err.println("Value of matrix is digit!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkMatrixSameSize(int[][] matrix1, int[][] matrix2){
        return matrix1.length==matrix2.length &&  matrix1[0].length==matrix2[0].length;
    }
    
    public static boolean checkMatrixCanMultiplication(int[][] matrix1, int[][] matrix2){
        return matrix1[0].length == matrix2.length;
    }
}
