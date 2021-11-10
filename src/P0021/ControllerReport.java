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
public class ControllerReport {
    ArrayList<Report> l = new ArrayList<>();

    public ControllerReport(ArrayList<Student> ls) {
        for (Student t : ls) {
            int total = 0;
            for (Student tCheck : ls) {
                if(tCheck.getId().equalsIgnoreCase(t.getId()) 
                        && tCheck.getName().equalsIgnoreCase(t.getName()) 
                        && tCheck.getCourseName().equalsIgnoreCase(t.getCourseName())){
                    total++;
                    //check one by one, if same id, name, course -> toatl++
                }
            }
            //check if report not exist in list -> add to list
            if(!checkRP(t.getName(), t.getCourseName(), total, t.getId())){
                l.add(new Report(t.getName(), t.getCourseName(), total, t.getId()));
            }
        }
    }
    
    public boolean checkRP(String name, String courseName, int total, String id){
        for (Report r : l) {
            if(name.equalsIgnoreCase(r.getStdName()) && courseName.equalsIgnoreCase(r.getCourseName()) && total==r.getTotalCouse() && id.equalsIgnoreCase(r.getId())){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        return l.isEmpty();
    }
    
    public ArrayList<Report> getList(){
        return l;
    }
}
