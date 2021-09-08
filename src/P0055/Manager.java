
package P0055;

public class Manager {
    ControlDoctor dt = new ControlDoctor();
    
    public void addDoctor(){
        System.out.print("Enter Doctor code: ");
        String code = Validate.checkInputString();
        if(dt.findByCode(code) != null){
            System.out.println("This code is duplicate!!!");
            return;
        }
        System.out.print("Enter doctor name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter doctor specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter doctor availability: ");
        int availability = Validate.checkInputInt();
        
        dt.addDoctor(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful.");
    }
    
    public void updateDoctor(){
        System.out.print("Enter code of doctor you want to update information: ");
        String code = Validate.checkInputString();
        if(dt.findByCode(code) == null){
            System.out.println("Not found doctor with code: "+code);
            return;
        }
        Doctor doctor = dt.findByCode(code);
        System.out.print("Enter code update: ");
        String oldCode = doctor.getCode();
        String newCode = Validate.checkInputStringEmpty(oldCode);
        doctor.setCode(null);
        while(true) {
            if(dt.findByCode(newCode)!=null){
                System.err.println("This code is duplicate!!!");
                System.out.print("Enter code update: ");
                newCode = Validate.checkInputStringEmpty(oldCode);
                doctor.setCode(null);
            } else break;
        }
        System.out.print("Enter name of doctor update: ");
        String newName = Validate.checkInputStringEmpty(doctor.getName());
        System.out.print("Enter specialization: ");
        String newSpecialization = Validate.checkInputStringEmpty(doctor.getSpecialization());
        System.out.print("Enter availability: ");
        int newAvailability = Validate.checkInputIntEmpty(doctor.getAvailability());
        dt.updateDoctor(doctor, new Doctor(newCode, newName, newSpecialization, newAvailability));
        System.out.println("Doctor is updated successful!!!");
        
    }
    
    public void deleteDoctor(){
        System.out.print("Enter code of doctor you want to delete:");
        String code = Validate.checkInputString();
        while(dt.findByCode(code)==null){
            System.err.println("Doctor not found.");
            System.out.print("Enter code of doctor you want to delete:");
            code = Validate.checkInputString();
        }
        dt.deleteDoctor(code);
        System.out.println("Doctor with code \""+code+"\" is deleted.");
    }
    
    public void searchDoctor(){
        System.out.println("Based on what information do you want to find a doctor?");
        String[] type = {"code","name","Specialization"};
        System.out.println(" 1. "+type[0]+".");
        System.out.println(" 2. "+type[1]+".");
        System.out.println(" 3. "+type[2]+".");
        System.out.print("Your choice: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        System.out.print("Enter "+type[choice-1]+" of doctor you need to find: ");
        dt.searchDoctor(type[choice-1], Validate.checkInputString());
    }
    
    public void showDoctorList(){
        dt.showDoctorList();
    }
}
