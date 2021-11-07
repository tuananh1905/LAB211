/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0023;

import java.util.ArrayList;
import java.util.Hashtable;

public class Manager {
    Validation validation = new Validation();
    ControllerFruit controllerFruit = new ControllerFruit();
    ControllerOrders controllerOrders = new ControllerOrders();
    ControllerOrder controllerOrder = new ControllerOrder();
    
    public void menu(){
        while(true){
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println(" 1. Create Fruit.");
            System.out.println(" 2. View orders.");
            System.out.println(" 3. Shopping(for buyer).");
            System.out.println(" 4. Exit.");
            System.out.print("Your choice: ");
            int choice = validation.checkInputIntLimit(1, 4);
            switch(choice){
                case 1:
                    addFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    return;
            }
            System.out.println("");
        }
    }
    
    public void addFruit(){
        while(true){
            System.out.print("Enter fruit id: ");
            String id = validation.checkInputString();
            while(controllerFruit.checkFruitIdExist(id)){
                System.out.println("Id exist!!!");
                System.out.print("Enter again: ");
                id = validation.checkInputString();
            }
            System.out.print("Enter fruit name: ");
            String name = validation.checkInputString();
            System.out.print("Enter price: ");
            double price = validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = validation.checkInputString();
            controllerFruit.addFruit(new Fruit(id, name, price, quantity, origin));
            
            if(!validation.checkInputYN()){
                showFruitList();
                return;
            }
        }
    }
    
    public void viewOrders(){
        if(controllerOrders.isEmpty()) {
            System.out.println("There are no orders yet!!!");
            return;
        }
        Hashtable<String, ArrayList<Fruit>> o = controllerOrders.show();
        for (String key : o.keySet()){
            System.out.println("Customer: "+key);
            ArrayList<Fruit> a = o.get(key);
            System.out.printf("%-15s%-15s%-15s%-15s\n", "Fruit", "Quantity", "Price", "Amount");
            double total=0;
            for (int i = 0; i < a.size(); i++) {
                System.out.printf("%-15s%-15d%5.2f%-10s%.2f\n",a.get(i).getName(), a.get(i).getQuantity(), a.get(i).getPrice(), "$", a.get(i).getPrice()*a.get(i).getQuantity(), "$");
                total += a.get(i).getPrice() * a.get(i).getQuantity();
            }
            System.out.println("Total: "+total);
        }
    }
    
    public void shopping(){
        if(controllerFruit.checkFruitList()){
            System.out.println("The store has no fruit at the moment!!!");
            return;
        }
        ControllerOrder c = new ControllerOrder();
        while(true){
            showFruitListToOrder();
            System.out.print("Fruit your choice: ");
            int item =  validation.checkInputIntLimit(1, controllerFruit.countNumberFruit());
            Fruit fruit = controllerFruit.getFruitById(item);
            System.out.println("You selected: " + fruit.name);
            System.out.print("Please input quantity: ");
            int quantity = validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity()-quantity);
            
            if(c.checkItemExist(fruit.name)) c.updateOrder(fruit, quantity);
            else c.addOrder(new Fruit(fruit.id, fruit.name, fruit.price, quantity, fruit.origin));
            controllerFruit.checkAfterShopping();
            
            if(validation.checkInputYNOrder()){
                break;
            }
        }
        showOrderList(c.showOrderList());
        System.out.print("Enter customer name: ");
        String name = validation.checkInputString();
        controllerOrders.shopping(c.showOrderList(), name);
        System.out.println("Add successfull!!!");
    }
    
    public void showFruitList(){
        ArrayList<Fruit> f = controllerFruit.showFruit();
        System.out.println("List of Fruit:");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n","Fruit id","Fruit Name","Price","Quantity","Origin");
        for (int i = 0; i < f.size(); i++) {
            System.out.printf("%-15s%-15s%5.2f%-10s%-15d%-15s\n",f.get(i).getId(), f.get(i).getName(), f.get(i).getPrice(), "$", f.get(i).getQuantity(), f.get(i).getOrigin());
        }
    }
    
    public void showOrderList(ArrayList<Fruit> o){
        System.out.printf("%-15s%-15s%-15s%-15s\n","Fruit","Quantity","Price","Amount");
        for (int i = 0; i < o.size(); i++) {
            System.out.printf("%-15s%-15d%5.2f%-10s%.2f\n",o.get(i).getName(), o.get(i).getQuantity(), o.get(i).getPrice(), "$", o.get(i).getPrice()*o.get(i).getQuantity(), "$");
        }
    }
    
    public void showFruitListToOrder(){
        ArrayList<Fruit> f = controllerFruit.showFruit();
        System.out.println("List of Fruit:");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n","Item","Fruit Name","Origin","Quantity","Price");
        for (int i = 0; i < f.size(); i++) {
            System.out.printf("%-15s%-15s%-15s%-15d%.2f\n", i+1, f.get(i).getName(), f.get(i).getOrigin(), f.get(i).getQuantity(), f.get(i).getPrice(), "$");
        }
    }
}
