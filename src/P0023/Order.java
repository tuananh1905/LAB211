/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;

public class Order {
    private String customerName;
    private ArrayList<Fruit> o = new ArrayList<>();
    
    public void addFruitToOrder(Fruit buy){
        o.add(buy);
    }
    
    //if checkItemExist --> use updateOrder for not duplicate fruit in order
    //if not --> addFruitToOrder
    
    public void updateOrder(Fruit fruit, int quantity){
        for (int i = 0; i < o.size(); i++) {
            if(fruit.getId().equalsIgnoreCase(o.get(i).getId())){
                o.get(i).setQuantity(o.get(i).getQuantity()+quantity);
                return;
            }
        }
    }
    
    public boolean checkItemExist(String id){
        for (int i = 0; i < o.size(); i++) {
            if(id.equalsIgnoreCase(o.get(i).getId())) return true;
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
