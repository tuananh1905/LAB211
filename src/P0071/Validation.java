/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0071;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    
    public Scanner scan = new Scanner(System.in);
    
    public int checkIntLimit(int min, int max){
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
    
    public int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(scan.nextLine().trim());
                return result;
            } catch (NumberFormatException e){
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "design";
                    break;
                case 4:
                    result = "review";
            }
            return result;
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

    public String checkInputDate() {
        String DATE = "[0-3]{1}[0-9]{1}-[01]{1}[0-9]{1}-[0-9]{4}";
        while (true) {
            String date = checkInputString();
            if(!Pattern.matches(DATE, date)){
                System.out.print("You need to enter correct format [day-month-year]: ");
                continue;
            }
            if(!checkDateValid(date)){
                System.out.println("The day invalid.");
                System.out.print("Enter again: ");
                continue;
            }
            return date;
        }
    }
    
    public boolean checkDateValid(String date){
        String[] d = date.split("-");
        int day = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int year = Integer.parseInt(d[2]);
        
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            if(day<=31 && day>0) return true;
        }
        
        if(month==4 || month==6 || month==9 || month==11){
            if(day<=30 && day>0) return true;
        }
        
        if(month==2){
            if(year%4==0){
                if(year%100==0 && year%400!=0){
                        if(day<=28 && day>0) return true;
                }else{
                    if(day<=29 && day>0) return true;
                }
            }else {
                if(day<=28 && day>0) return true;
            }
        }
        return false;
    }
    
    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(scan.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Enter again: ");
            }
        }
    }
    
    public double checkInputPlanFrom(){
        while(true){
            double result = checkInputDouble();
            if(result>=8.0 && result <17.5){
                if(result%0.5==0) return result;
                else {
                    System.out.println("The project must be 8.0, 8.5, 9.0");
                    System.out.print("Enter again: ");
                }
            }else {
                System.out.println("The project must be start between 8:30am and 17:30pm.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public double checkInputPlanTo(double from){
        while(true){
            double result = checkInputDouble();
            if(result>from && result <=17.5){
                if(result%0.5==0) return result;
                else {
                    System.out.println("The project must be 8.0, 8.5, 9.0");
                    System.out.print("Enter again: ");
                }
            }else {
                if(from<=12) System.out.println("The project must be finish between "+ from +"am and 17:30pm.");
                else System.out.println("The project must be finish between "+ from +"pm and 17:30pm.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputStringNope(String s){
        String result = checkInputString();
        if(result.equalsIgnoreCase("nope")){
            System.out.println("Your input is 'nope', this information not change!");
            return s;
        }
        return result;
    }
    
    public String checkInputTypeNope(String type){
        while(true){
            try{
                String result = checkInputString();
                if(result.equalsIgnoreCase("nope")){
                    System.out.println("Your input is 'nope', this information not change!");
                    return type;
                }
                int r = Integer.parseInt(result);
                if (r < 1 || r > 4){
                    System.out.print("Enter again: ");
                    continue;
                }
                switch (r) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
                }
                return result;
            }catch(NumberFormatException e){
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputDateNope(String d){
        while(true){
            String DATE = "[0-3]{1}[0-9]{1}-[01]{1}[0-9]{1}-[0-9]{4}";
            String date = checkInputString();
            if(date.equalsIgnoreCase("nope")){
                    System.out.println("Your input is 'nope', this information not change!");
                    return d;
            }
            if(!Pattern.matches(DATE, date)){
                System.out.print("You need to enter correct format [day-month-year]: ");
                continue;
            }
            if(!checkDateValid(date)){
                System.out.println("The day invalid.");
                System.out.print("Enter again: ");
                continue;
            }
            return date;
        }
    }
    
    public double checkUpdatePlanFromNope(double f){
        while(true){
            String temp = checkInputString();
            if(temp.equalsIgnoreCase("nope")){
                    System.out.println("Your input is 'nope', this information not change!");
                    return f;
            }
            double from = Double.parseDouble(temp);
            if(from>=8.0 && from <17.5){
                return from;
            }else {
                System.out.println("The project must be start between 8:30am and 17:30pm.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public double checkUpdatePlanToNope(double f, double t){
        while(true){
            String temp = checkInputString();
            if(temp.equalsIgnoreCase("nope")){
                if(f>t){
                    System.out.println("Time finish must be bigger than time start.");
                    System.out.print("Enter again: ");
                    continue;
                } else {
                    System.out.println("Your input is 'nope', this information not change!");
                    return t;
                }
            }
            double to = Double.parseDouble(temp);
            if(to>f && to <=17.5){
                return to;
            }else {
                if(to<=12) System.out.println("The project must be finish between "+ f +"am and 17:30pm.");
                else System.out.println("The project must be finish between "+ f +"pm and 17:30pm.");
                System.out.print("Enter again: ");
            }
        }
    }
    
}
