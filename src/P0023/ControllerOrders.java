/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;
import java.util.Hashtable;

public class ControllerOrders {
    Hashtable<String, ArrayList<Fruit>> o = new Hashtable<>();
    
    public void shopping(ArrayList<Fruit> orders , String name){
        o.put(name, orders);
    }
    
    public Hashtable show(){
        return o;
    }
    
    public boolean isEmpty(){
        return o.isEmpty();
    }
}
