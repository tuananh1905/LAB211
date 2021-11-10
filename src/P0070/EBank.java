/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0070;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class EBank {
    
    ResourceBundle bundle;

    public EBank() {
        bundle = ResourceBundle.getBundle("messages", new Locale("Vi"));
    }
    
//choose language for program
    public void setLocale(Locale Locale){
        bundle = ResourceBundle.getBundle("messages", Locale);
    }
//check account number input by user must be right format
//return message
    public String checkAccountNumber(String account){
        if(account.matches("^\\d{10}$")){
            return "";
        }else{
            return bundle.getString("accountWrong");
        }
    }
//check password input by user must be right format
//return message
    public String checkPassword(String password){
        if(password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+") && password.length() <= 31 && password.length() >= 8) {
            return "";
        }else{
            return bundle.getString("passwordWrong");
        }
    }
//create and return random captcha with 5 char including number, lower and upper case
    public String captchaGenerate(){
        int Ascii[] = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        char captcha[] = new char[5];
        Random rand = new Random();
        for (int i = 0; i < captcha.length; i++) {
            captcha[i] = (char)Ascii[rand.nextInt(Ascii.length)];
        }
//        String recaptcha = new String(captcha);
        return new String(captcha);
    }
//check captcha (captcha generate and captcha input by user)
//return message
    String checkCaptcha(String captchaInput, String captchaGenerate){
        //check length captcha
        if (captchaInput.length() != captchaGenerate.length()){
            return bundle.getString("captchaWrong");
        }
        
        if (! captchaInput.contains(captchaGenerate)){
            return bundle.getString("captchaWrong");
        }else{
            return bundle.getString("captchaRight");
        }
    }
}
