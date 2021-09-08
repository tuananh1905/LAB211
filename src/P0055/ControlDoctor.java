package P0055;

import java.util.ArrayList;

public class ControlDoctor {
    private ArrayList<Doctor> ld = new ArrayList<>();
    
    public void addDoctor(Doctor d){
        ld.add(d);
    }
    
    public void updateDoctor(Doctor d1, Doctor d2){
        int index=0;
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i)==d1) index = i;
        }
        ld.set(index, d2);
    }
    
    public void deleteDoctor(String id){
        ld.remove(findByCode(id));
    }
    
    public void searchDoctor (String type, String infor){
        System.out.println("All doctor you wanna find: ");
        System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
        System.out.println(type);
        switch(type){
            case "code":
                System.out.println("1");
                for (int i = 0; i < ld.size(); i++) {
                    if(infor.equalsIgnoreCase(ld.get(i).getCode())) printADoctor(ld.get(i));
                }
                break;
            case "name":
                System.out.println("2");
                for (int i = 0; i < ld.size(); i++) {
                    if(infor.equalsIgnoreCase(ld.get(i).getName())) printADoctor(ld.get(i));
                }
                break;
            case "specialization":
                System.out.println("3");
                for (int i = 0; i < ld.size(); i++) {
                    if(infor.equalsIgnoreCase(ld.get(i).getSpecialization())) printADoctor(ld.get(i));
                }
                break;
        }
    }
    
    public void showDoctorList(){
        System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
        for (int i = 0; i < ld.size(); i++) {
            printADoctor(ld.get(i));
//            System.out.printf("%-15s%-15s%-20s%-15d\n", ld.get(i).getCode(), ld.get(i).getName(), ld.get(i).getSpecialization(), ld.get(i).getAvailability());
        }
    }
    
    public void printADoctor(Doctor d){
        System.out.printf("%-15s%-15s%-20s%-15d\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
    }
    
    public Doctor findByCode(String code){
        for (int i = 0; i < ld.size(); i++) {
            if(code.equalsIgnoreCase(ld.get(i).getCode())){
                return ld.get(i);
            } 
        }
        return null;
    }
    
    public boolean checkAvailabilityExist(int availability){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getAvailability() == availability){
                return false;
            }
        }
        return true;
    }
}
