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
public class ControllerOrder {
    ArrayList<Order> o = new ArrayList<>();
    
    public void addOrder(Order buy){
        o.add(buy);
    }
    
    public void updateOrder(String name, int quantity){
        for (int i = 0; i < o.size(); i++) {
            if(name.equalsIgnoreCase(o.get(i).getName())){
                o.get(i).setQuantity(o.get(i).getQuantity()+quantity);
                return;
            }
        }
    }
    
    public boolean checkItemExist(String name){
        for (int i = 0; i < o.size(); i++) {
            if(name.equalsIgnoreCase(o.get(i).getName())) return true;
        }
        return false;
    }
    
    public ArrayList showOrderList(){
        return o;
    }
}
