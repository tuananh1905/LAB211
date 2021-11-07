/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;

public class ControllerFruit {
    ArrayList<Fruit> f = new ArrayList<>();

    public ControllerFruit() {
        addFruit(new Fruit("f001", "Apple", 5, 10, "Vietname"));
        addFruit(new Fruit("f002", "Orange", 3, 10, "US"));
        addFruit(new Fruit("f003", "Coconut", 2, 10, "Thailand"));
        addFruit(new Fruit("f004", "Grape", 6, 10, "France"));
    }
    
    public void addFruit(Fruit fr){
        f.add(fr);
    }
    
    public ArrayList<Fruit> showFruit(){
        return f;
    }
    
    public boolean checkFruitIdExist(String id){
        for (int i = 0; i < f.size(); i++) {
            if(id.equalsIgnoreCase(f.get(i).getId())) return true;
        }
        return false;
    }
    
    public void checkAfterShopping(){
        for (int i = 0; i < f.size(); i++) {
            if(f.get(i).quantity==0) f.remove(f.get(i));
        }
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
