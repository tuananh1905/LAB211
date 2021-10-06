/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0070;

import java.util.Scanner;

/**
 *
 * @author TuanAnh
 */
public class MainBank {
    public static void main(String[] args) {
        String account;
        String password;
        String captchaIn;
        int choice;
        String captchaGenerate;
        
        System.out.println("-------Login program-------");
        System.out.println("1. Vietnamese.");
        System.out.println("2. English.");
        System.out.println("3. Exit.");
        System.out.print("Please choose one option: ");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        if(choice != 1 && choice !=2){
            return;
        }
        
        EBank user = new EBank(choice == 1 ? "Vi" : "En");
        
        while(true){
            System.out.print(user.bundle.getString("accountPrompt"));
            account = scan.next();
            
            user.checkAccountNumber(account);
            
            if(user.checkAccountNumber(account).equals(user.bundle.getString("accountWrong"))){
                System.out.println(user.checkAccountNumber(account));
            }else{
                break;
            }
        }
        
        while(true){
            System.out.print(user.bundle.getString("passwordPrompt"));
            password = scan.next();
            
            user.checkPassword(password);
            
            if(user.checkPassword(password).equals(user.bundle.getString("passwordWrong"))){
                System.out.println(user.checkPassword(password));
            }else{
                break;
            }
        }
        
        captchaGenerate = user.captchaGenerate();
        System.out.println("Captcha: "+captchaGenerate);
        
        System.out.print(user.bundle.getString("captchaPrompt"));
        captchaIn = scan.next();
        
        System.out.println(user.checkCaptcha(captchaIn, captchaGenerate));
    }
}
