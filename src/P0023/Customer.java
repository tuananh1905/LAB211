/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Fruit> o = new ArrayList<>();
    
    public void addOrder(Fruit buy){
        o.add(buy);
    }

    public void updateOrder(Fruit fruit, int quantity){
        for (int i = 0; i < o.size(); i++) {
            if(fruit.getName().equalsIgnoreCase(o.get(i).getName())){
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
}
