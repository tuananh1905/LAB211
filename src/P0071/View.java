/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0071;

import java.util.ArrayList;

/**
 *
 * @author TuanAnh
 */
public class View {
    
    Validation v = new Validation();
    ControllerTask c = new ControllerTask();
    
    public void menu(){
        while(true){
            System.out.println("====== Task program ======");
            System.out.println("    1. Add Task.");
            System.out.println("    2. Update Task.");
            System.out.println("    3. Delete Task.");
            System.out.println("    4. Display Task.");
            System.out.println("    5. Exit.");
            System.out.print("    Your choice: ");
            int choice = v.checkIntLimit(1, 5);
            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    displayTask();
                    break;
                case 5:
                    return;
            }
        }
    }
    
    public void addTask(){
        System.out.print("Requirement Name: ");
        String name =  v.checkInputString();
        System.out.print("Task Type: ");
        String taskTypeId = v.checkInputTaskTypeId();
        System.out.print("Date: ");
        String date = v.checkInputDate();
        System.out.print("From: ");
        double from = v.checkInputPlanFrom();
        System.out.print("To: ");
        double to = v.checkInputPlanTo(from);
        System.out.print("Enter Assignee: ");
        String assign = v.checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = v.checkInputString();
        
        c.addTask(taskTypeId, name, date, from, to, assign, reviewer);
        System.out.println("\nAdd Task Success!!!");
    }
    
    public void updateTask(){
        if(c.isEmpty()){
            System.out.println("\nList is empty!!!");
            return;
        }
        System.out.print("Enter id of task you want to update: ");
        int id = 0;
        while(true){
            id = v.checkInputInt();
            if(c.isValidId(id)) break;
            else {
                System.out.println("Id does not exist.");
                System.out.print("Enter again: "); 
            }
        }
        Task t = c.getTask(id);
        
        System.out.print("Enter new requirement name: ");
        String newName = v.checkInputStringNope(t.name);
        System.out.print("Enter new type: ");
        String newType = v.checkInputTypeNope(t.taskTypeId);
        System.out.print("Enter new date: ");
        String newDate = v.checkInputDateNope(t.date);
        System.out.print("Enter new time start: ");
        double newFrom = v.checkUpdatePlanFromNope(t.planFrom);
        System.out.print("Enter new time finish: ");
        double newTo = v.checkUpdatePlanToNope(newFrom, t.planTo);
        System.out.print("Enter new assignee: ");
        String newAssignee = v.checkInputStringNope(t.assignee);
        System.out.print("Enter new reviewer: ");
        String newReviewer = v.checkInputStringNope(t.reviewer);
        
        c.updateTask(new Task(id, newType, newName, newDate, newFrom, newTo, newAssignee, newReviewer));
        System.out.println("\nUpdate success!!!");
    }
    
    public void deleteTask(){
        while(true){
            if(c.isEmpty()){
                System.out.println("\nList is empty!!!");
                return;
            }
            System.out.print("Enter id of task you want to delete: ");
            int id = v.checkInputInt();
            if(c.delTask(id)) {
                System.out.println("\nDelete success!!!");
                return;
            }
            System.out.print("Enter again: ");
        }
    }
    
    public void displayTask(){
        if(c.isEmpty()){
            System.out.println("\nList is empty!!!");
            return;
        }
        ArrayList<Task> lt = c.getList();
        if (lt.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.println("");
        System.out.println("--------------------------------- Task descending order ---------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            double time = lt.get(i).getPlanTo()-lt.get(i).planFrom;
            if(lt.get(i)!=null){
                System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                        lt.get(i).getId(),
                        lt.get(i).getName(),
                        lt.get(i).getTaskTypeId(),
                        lt.get(i).getDate(),
                        time,
                        lt.get(i).getAssignee(),
                        lt.get(i).getReviewer()
                );
            }
        }
    }
}
