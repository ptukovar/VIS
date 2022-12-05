package DataLayer;

import java.util.*;

import BusinessLayer.Product;

public class productsDB {
    public ArrayList<Product> productList;
    public int size;

    public productsDB() {
        this.productList = new ArrayList<Product>();
    }
    public void addProduct(Product p){
        int i=0;
        boolean duplicate=false;
        for(Product pp:this.productList){
            if(this.productList.get(i).id ==p.getProduct().id){
                duplicate=true;
            }
            i++;
        }
        if(duplicate==false){
            this.productList.add(p);
        }else if(duplicate==true){
            System.out.print("Can't add this product:(");
            System.out.print(p.id+" ");
            System.out.print(p.name+" "); 
            System.out.print(p.type+" ");
            System.out.print(p.size+" ");
            System.out.print(p.quantity +") -> ID duplicates\n");
        }
    }
     
    public void editPruduct(int id, Product p) {
        System.out.println(id);
    	this.productList.set(id, p);
    }
    
    public void displayProducts(){
        int i=0;
        System.out.println("id\tname\ttype\tsize\tquantity");
        for(Product p:this.productList){
            System.out.print(this.productList.get(i).id+"\t");
            System.out.print(this.productList.get(i).name+"\t");
            System.out.print(this.productList.get(i).type+"\t");
            System.out.print(this.productList.get(i).size+"\t\t");
            System.out.print(this.productList.get(i).quantity);
            System.out.println();
            i++;
        }
    }
}
