/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;

public class ControllerOrders {
    Hashtable<String, ArrayList<Fruit>> os = new Hashtable<>();
    
    public void addOrder(Order o){
        os.put(getKeyHashtable(o.getCustomerName()), o.showOrderList());
    }
    
    public Hashtable show(){
        return os;
    }
    
    public boolean isEmpty(){
        return os.isEmpty();
    }
    
    public String getKeyHashtable(String name){
        return LocalDateTime.now().toString() + "@" + name;
    }
}
