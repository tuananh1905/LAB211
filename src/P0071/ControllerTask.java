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
public class ControllerTask {
    
    ArrayList<Task> l = new ArrayList<>();
    
    public void addTask (String taskTypeId, String name, String date, double planFrom, double planTo, String assignee, String reviewer){
        int id = lastId();
        l.add(new Task(id, taskTypeId, name, date, planFrom, planTo, assignee, reviewer));
    }
    
    public int lastId(){
        if(isEmpty()) return 1;
        else return l.get(l.size()-1).getId() + 1;
    }
    
    public ArrayList getList(){
        return l;
    }
    
    public boolean isValidId(int id){
        for (int i = 0; i < l.size(); i++) {
            if(id == l.get(i).getId()) return true;
        }
        return false;
    }
    
    public Task getTask(int id){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).getId()==id) return l.get(i);
        }
        return null;
    }
    
    public int count(){
        return l.size();
    }
    
    public boolean isEmpty(){
        return l.isEmpty();
    }
    
    public void updateTask(Task t2){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).getId()==t2.getId()) l.set(i, t2);
        }
    }
    
    public boolean delTask(int id){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).getId()==id) {
                l.remove(i);
                return true;
            }
        }
        return false;
    }
    
}
