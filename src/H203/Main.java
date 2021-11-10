/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H203;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printReverse("hello there");
    }
    
    public static String Reverse(String s){
        String words[] = s.split("\\s+");
        StringBuilder sc = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            if(i==words.length-1){
                sc.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1)).append(" ");
            }else{
                sc.append(words[i]).append(" ");
            }
        }
        return sc.toString().trim();
    }
    
    public static void printReverse(String s){
        while(s.isEmpty()){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a string: ");
            s = scan.nextLine().trim();
        }
        System.out.println(Reverse(s));
    }
}
