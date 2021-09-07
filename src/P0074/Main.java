//https://docs.google.com/document/d/1SKvlrJgEqwUlofUGAlbH6dDHrfaQ8OrP/edit
package P0074;

public class Main {
    public static void main(String[] args) {
        while(true){
            int choice = Manager.menu();
            switch(choice){
                case 1:
                    Manager.additionMatrix();
                    break;
                case 2:
                    Manager.subtractionMatrix();
                    break;
                case 3: 
                    Manager.multiplicationMatrix();
                    break;
                case 4:
                    return;
            }
        }
    }
}
