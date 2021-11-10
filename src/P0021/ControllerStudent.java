/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author TuanAnh
 */
public class ControllerStudent {
    private ArrayList<Student> l = new ArrayList<>();
    
    public ControllerStudent() {
        l.add(new Student("3", "Nguyen Van B", 1, "c/c++"));
        l.add(new Student("7", "Nguyen Van D", 2, "java"));
        l.add(new Student("1", "Nguyen Van A", 2, "java"));
        l.add(new Student("3", "Nguyen Van B", 1, "c/c++"));
        l.add(new Student("6", "Nguyen Van E", 3, ".net"));
        l.add(new Student("5", "Nguyen Van A", 2, "java"));
        l.add(new Student("4", "Nguyen Van C", 3, ".net"));
        l.add(new Student("1", "Nguyen Van A", 1, "java"));
        l.add(new Student("8", "Duong Van F", 3, ".net"));
        l.add(new Student("2", "Nguyen Van G", 1, ".net"));
    }
    
    public int getSize(){
        return l.size();
    }
    
    public void addStudent(String id, String name, int semester, String courseName) {
        l.add(new Student(id, name, semester, courseName));
    }
    
    public ArrayList<Student> getList(){
        return l;
    }
    //sort list format name first and id before that
    public void SortlistStudent() {
        Collections.sort(l, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                String[] name = t.getName().split(" ");
                String[] name1= t1.getName().split(" ");
                
                int compare = name[name.length-1].compareTo(name1[name1.length-1]);
                
                if(compare==0){
                    return t.getId().compareTo(t1.getId());
                }
                return compare;
                
//                if(t.getName().compareTo(t1.getName())==0){
//                    return t.getId().compareTo(t1.getId());
//                }
//                return t.getName().compareTo(t1.getName());
            }
        });
    }
    //return a list of student correct id with id imput
    public ArrayList<Student> listStudentById(String id){
        ArrayList<Student> listId = new ArrayList<>();
        for (Student t : l) {
            if (t.getId().equalsIgnoreCase(id)) {
                listId.add(t);
            }
        }
        return listId;
    }
    
    public void del(Student s){
        l.remove(s);
    }
    
    /*
    check functions
    */
    public boolean checkId(String id) {
        for (Student t : l) {
            if (id.equalsIgnoreCase(t.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkName(String name) {
        for (Student t : l) {
            if (name.equalsIgnoreCase(t.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkStudentExist(String name, String id) {
        for (Student t : l) {
            if (name.equals(t.getName())&& id.equalsIgnoreCase(t.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSemester(int semester, String name, String id, String courseName) {
        for (Student t : l) {
            if (semester == t.getSemeter()
                    && name.equalsIgnoreCase(t.getName())
                    && id.equalsIgnoreCase(t.getId())
                    && courseName.equalsIgnoreCase(t.getCourseName())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty(){
        if(l.isEmpty()) return true;
        else return false;
    }
}
