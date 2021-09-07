/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0055;

import java.util.ArrayList;

/**
 *
 * @author TuanAnh
 */
public class Manager {
    public static int menu(){
        System.out.println("---Doctor management program---");
        System.out.println(" 1. Add doctor.");
        System.out.println(" 2. Update doctor.");
        System.out.println(" 3. Delete doctor.");
        System.out.println(" 4. Search doctor.");
        System.out.println(" 5. Show doctor list.");
        System.out.println(" 6. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 5);
        return choice;
    }
    public static void addDoctor(ArrayList<Doctor> ld){
        System.out.print("Enter Doctor code: ");
        String code = Validate.checkInputString();
        if(!Validate.checkCodeExist(ld, code)){
            System.out.println("This code is duplicate!!!");
            return;
        }
        System.out.print("Enter doctor name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter doctor specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter doctor availability: ");
        int availability = Validate.checkInputInt();
        
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful.");
    }
    public static void updateDoctor(ArrayList<Doctor> ld){
        System.out.print("Enter code of doctor you want to update information: ");
        String code = Validate.checkInputString();
        if(Validate.checkCodeExist(ld, code)){
            System.out.println("Not found doctor with code: "+code);
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter code update: ");
        String newCode = Validate.checkInputString();
        while(!Validate.checkCodeExist(ld, newCode)){
            if(code.equalsIgnoreCase(newCode)){
                System.out.println("Code not change.");
            } else {
                System.out.println("This code is duplicate!!!");
            }
            System.out.print("Enter code update: ");
            newCode = Validate.checkInputString();
        }
        System.out.print("Enter name of doctor update: ");
        String newName = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String newSpecialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int newAvailability = Validate.checkInputInt();
        doctor.setCode(newCode);
        doctor.setName(newName);
        doctor.setSpecialization(newSpecialization);
        doctor.setAvailability(newAvailability);
        System.out.println("Doctor is updated successful!!!");
        
    }
    public static void deleteDoctor(ArrayList<Doctor> ld){
        System.out.print("Enter code of doctor you want to delete:");
        String code = Validate.checkInputString();
        while(Validate.checkCodeExist(ld, code)){
            System.out.println("Doctor not found.");
            System.out.print("Enter code of doctor you want to delete:");
            code = Validate.checkInputString();
        }
        ld.remove(getDoctorByCode(ld, code));
        System.out.println("Doctor with code \""+code+"\" is deleted.");
    }
    public static void searchDoctor(ArrayList<Doctor> ld){
        System.out.println("Based on what information do you want to find a doctor?");
        System.out.println(" 1. Code.");
        System.out.println(" 2. Name.");
        System.out.println(" 3. Specialization.");
        System.out.println(" 4. Availability.");
        int choice = Validate.checkInputIntLimit(1, 4);
        switch(choice){
            case 1:
                System.out.print("Enter code of doctor you want to find: ");
                String code = Validate.checkInputString();
                if(Validate.checkCodeExist(ld, code)){
                    System.out.println("Doctor with code \""+code+"\" not found.");
                } else {
                    System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
                    for (int i = 0; i < ld.size(); i++) {
                        if(code.equalsIgnoreCase(ld.get(i).getCode())) printADoctor(ld.get(i));
                    }
                }
                break;
            case 2:
                System.out.print("Enter name of doctor you want to find: ");
                String name = Validate.checkInputString();
                if(Validate.checkNameExist(ld, name)){
                    System.out.println("Doctor with name \""+name+"\" not found.");
                } else{
                    System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
                    for (int i = 0; i < ld.size(); i++) {
                        if(name.equalsIgnoreCase(ld.get(i).getName())) printADoctor(ld.get(i));
                    }
                }
                break;
            case 3:
                System.out.print("Enter specialization of doctor you want to find: ");
                String specialization = Validate.checkInputString();
                if(Validate.checkSpecializationExist(ld, specialization)){
                    System.out.println("Doctor with specialization \""+specialization+"\" not found.");
                } else {
                    System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
                    for (int i = 0; i < ld.size(); i++) {
                        if(specialization.equalsIgnoreCase(ld.get(i).getSpecialization())) printADoctor(ld.get(i));
                    }
                }
                break;
            case 4:
                System.out.println("Enter availability of doctor you want to find: ");
                int availability = Validate.checkInputInt();
                if(Validate.checkAvailabilityExist(ld, availability)){
                    System.out.println("Doctor with availability \""+availability+"\" not found.");
                }else {
                    System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
                    for (int i = 0; i < ld.size(); i++) {
                        if(ld.get(i).getAvailability()==availability) printADoctor(ld.get(i));
                    }
                }
                break;
        }
    }
    public static void printADoctor(Doctor d){
        System.out.printf("%-15s%-15s%-20s%-15d\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
        
    }
    public static void showDoctorList(ArrayList<Doctor> ld){
        System.out.printf("%-15s%-15s%-20s%-15s\n", "Doctor code", "Doctor Name", "Specialization", "Availability");
        for (int i = 0; i < ld.size(); i++) {
            printADoctor(ld.get(i));
//            System.out.printf("%-15s%-15s%-20s%-15d\n", ld.get(i).getCode(), ld.get(i).getName(), ld.get(i).getSpecialization(), ld.get(i).getAvailability());
        }
    }
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getCode().equalsIgnoreCase(code)){
                return ld.get(i);
            }
        }
        return null;
    }
    public static boolean getDoctorByName(ArrayList<Doctor> ld, String name){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    public static boolean getDoctorBySpecialization(ArrayList<Doctor> ld, String Specialization){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getSpecialization().equalsIgnoreCase(Specialization)){
                return true;
            }
        }
        return false;
    }
    public static boolean getDoctorByAvailability(ArrayList<Doctor> ld, int Availability){
        for (int i = 0; i < ld.size(); i++) {
            if(ld.get(i).getAvailability()==Availability){
                return true;
            }
        }
        return false;
    }
}
