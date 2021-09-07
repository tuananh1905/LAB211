//https://docs.google.com/document/d/1JpwKwLJATKaMds3KVXzNDXE-qMGt618k/edit
package P0055;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        
        while (true){
            int choice = Manager.menu();
            switch (choice){
                case 1:
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    Manager.searchDoctor(ld);
                    break;
                case 5:
                    Manager.showDoctorList(ld);
                    break;
                case 6:
                    return;
            }
            System.out.println("");
        }
    }
}
