//https://docs.google.com/document/d/1JpwKwLJATKaMds3KVXzNDXE-qMGt618k/edit
package P0055;


public class Main {
    public static void main(String[] args) {
        Manager menu = new Manager();
        while (true){
            System.out.println("---Doctor management program---");
            System.out.println(" 1. Add doctor.");
            System.out.println(" 2. Update doctor.");
            System.out.println(" 3. Delete doctor.");
            System.out.println(" 4. Search doctor.");
            System.out.println(" 5. Show doctor list.");
            System.out.println(" 6. Exit.");
            System.out.print("Enter your choice: ");
            int choice = Validate.checkInputIntLimit(1, 5);
            switch (choice){
                case 1:
                    menu.addDoctor();
                    break;
                case 2:
                    menu.updateDoctor();
                    break;
                case 3:
                    menu.deleteDoctor();
                    break;
                case 4:
                    menu.searchDoctor();
                    break;
                case 5:
                    menu.showDoctorList();
                    break;
                case 6:
                    return;
            }
            System.out.println("");
        }
    }
}
