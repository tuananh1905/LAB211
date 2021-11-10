/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0021;

import java.util.ArrayList;

/**
 *
 * @author TuanAnh
 */
public class View {
    
    Validate v = new Validate();
    ControllerStudent cs = new ControllerStudent();
    
    public void menu(){
        while(true){
            System.out.println("-----------------------------\n"
                + "WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit");
            System.out.print("Your choice: ");
            int choice = v.checkIntLimit(1, 5);
            switch(choice){
                case 1:
                    create();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDel();
                    break;
                case 4: 
                    report();
                    break;
                case 5:
                    return;
            }
        }
    }
    
    public void create(){
        while(true){
            System.out.print("Enter id of student: ");
            String id = v.checkInputString();
            String name;
            //check if duplicate id so need to correct name
            //if not duplicate ID dont need to check name
            while(true){
                System.out.print("Enter name of student: ");
                name = v.checkInputString();
                if(cs.checkId(id)){
                    if(cs.checkStudentExist(name, id)) break;
                    else System.out.println("Name Invalid!");
                }else break;
            }
            
            System.out.print("Course Name: ");
            String course = v.checkCouse();
            //check if duplicate id, name, course so need to diffierent semester
            int semester;
            System.out.print("Enter semester: ");
            while(true){
                semester = v.checkInputInt();
                if(cs.checkSemester(semester, name, id, course)) {
                    System.out.println("Invalid!");
                    System.out.print("Enter again: ");
                }
                else break;
            }
            //add student to list
            cs.addStudent(id, name, semester, course);
            System.out.println("Create Successful.");
            //if amount student in list greater than 10 user can stop if not continue
            if(cs.getSize()>10){
                System.out.print("Are you want to continue (Y/N): ");
                if(!v.checkInputYN()) return;
            }
        }
    }
    
    public void findAndSort(){
        String name;
        //input exist student
        System.out.print("Enter name of student you want to find: ");
        while (true){
            name = v.checkInputString();
            if(cs.checkName(name)) break;
            else {
                System.out.println("Student \""+name+"\" not found.");
                System.out.print("Enter again: ");
            }
        }
        //display all student with name inputed buy user
        ArrayList<Student> l = cs.getList();
        cs.SortlistStudent();
        System.out.printf("%-5s%-20s%-15s%-15s\n", "ID", "Name", "Semster", "Course");
        for (Student t : l) {
            if (name.equalsIgnoreCase(t.getName())) {
                display(t);
            }
        }
        //display all list of student sort by name first and ID before that
        System.out.println("------------- List sort by Name --------------");
        displayStudent(l);
    }
    
    public void updateOrDel(){
        if(cs.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String id;
        String choice = v.checkInputUD();
        switch(choice.toUpperCase()){
            case "U":
                //must be input exist student
                while(true){
                    System.out.print("Enter ID to update: ");
                    id = v.checkInputString();
                    if(cs.checkId(id)) break;
                    else System.out.println("Student not exist!");
                }
                //display for user choice student want to update
                Student t = getStudentSearch(cs.listStudentById(id));
                
                if(t==null){
                    System.out.println("Student not exist!");
                    return;
                }
                
                System.out.print("Do you want update ID (Y/N): ");
                if(v.checkInputYN()) {
                    System.out.print("Enter new ID: ");
                    t.setId(v.checkInputString());
                }
                
                System.out.print("Do you want update Name ? (Y/N): ");
                if(v.checkInputYN()) {
                    System.out.print("Enter new name: ");
                    t.setName(v.checkInputString());
                }
                
                System.out.print("Do you want update Course ? (Y/N): ");
                if(v.checkInputYN()) {
                    System.out.print("Enter new course: ");
                    t.setCourseName(v.checkCouse());
                }
                
                System.out.print("Do you want update Semester ? (Y/N): ");
                if(v.checkInputYN()) {
                    System.out.print("Enter new semester: ");
                    t.setSemeter(v.checkInputInt());
                }
                System.out.println("Update successful!");
                break;
            case "D":
                //find student by ID and get list student follow serial for user choice
                while(true){
                    System.out.print("Enter ID to delete: ");
                    id = v.checkInputString();
                    if(cs.checkId(id)) break;
                    else System.out.println("Student not exist!");
                }
                //display for user choice student want to delete
                cs.del(getStudentSearch(cs.listStudentById(id)));
                System.out.println("Delete successful!");
                break;
        }
    }
    
    public void report(){
        ControllerReport cr = new ControllerReport(cs.getList());
        if(cr.isEmpty()){
            System.out.println("List Empty!");
            return;
        }
        System.out.println("--------------- REPORT ---------------");
        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", "ID", "Name", "Course", "Total");
        for (Report rp : cr.getList()) {
            display(rp);
        }
    }
    
    /*
    display functions
    */
    public Student getStudentSearch(ArrayList<Student> l){
        int i = 1;
        System.out.printf("%-7s%-5s%-20s%-15s%-15s\n", "Serial", "ID", "Name", "Semster", "Course");
        for (Student t : l) {
            System.out.printf("%-7s%-5s%-20s%-15s%-15s\n", i, t.getId(),t.getName(), t.getSemeter(), t.getCourseName());
            i++;
        }
        System.out.print("Enter Serial: ");
        int seri = v.checkIntLimit(1, l.size());
        return l.get(seri-1);
    }
    
    public void display(Student s) {
        System.out.printf("%-5s%-20s%-15s%-15s\n", s.getId(), s.getName(), s.getSemeter(), s.getCourseName());
    }
    
    public void display(Report r) {
        System.out.printf("%-5s|%-15s|%-10s|%-10d\n", r.getId(), r.getStdName(), r.getCourseName(), r.getTotalCouse());
    }
    
    public void displayStudent(ArrayList<Student> l) {
        System.out.printf("%-5s%-20s%-15s%-15s\n", "ID", "Name", "Semster", "Course");
        for (Student t : l) {
            display(t);
        }
    }
    
}
