/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;

/**
 *
 * @author TuanAnh
 */
public class ControllerFruit {
    ArrayList<Fruit> f = new ArrayList<>();
    
    public void addFruit(Fruit fr){
        f.add(fr);
    }
    
    public ArrayList<Fruit> showFruit(){
        return f;
    }
    
    public ArrayList<Fruit> showFruitToOrder(){
        ArrayList<Fruit> o = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            if(f.get(i).quantity!=0) o.add(f.get(i));
        }
        return o;
    }
    
    public boolean checkFruitIdExist(String id){
        for (int i = 0; i < f.size(); i++) {
            if(id.equalsIgnoreCase(f.get(i).getId())) return true;
        }
        return false;
    }
    
    public boolean checkFruitList(){
        return f.isEmpty();
    }
    
    public int countNumberFruit(){
        return f.size();
    }
    
    public Fruit getFruitById(int id){
        id--;
        for (int i = 0; i < f.size(); i++) {
            if(i==id) return f.get(i);
        }
        return null;
    }
}
