package AppLayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import BusinessLayer.Product;
import BusinessLayer.User;
import DataLayer.ConnectionDB;
import DataLayer.LoginDB;
import DataLayer.productsDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String args[]) throws IOException, SQLException {
    	ConnectionDB con = new ConnectionDB();
        productsDB d1 = new productsDB();
        LoginDB l1 = new LoginDB();
        int choice = -1;
    	con.createTable();
   	 	l1.createTable();
    	 while(choice!=0){
             System.out.println("1) Login");
             System.out.println("2) Register");
             System.out.println("0) Quit");
             BufferedReader logM = new BufferedReader(new InputStreamReader(System.in));
             String s = logM.readLine();
             choice =Integer.parseInt(s);
             switch (choice){
                 case 1: inSystem(l1.loginTable(login()));
                     break;
                 case 2: l1.register(login());
                	 
                     break;
                 case 3:
                 	System.out.println("Enter ID of product:");
                 	BufferedReader scanner1 = new BufferedReader(new InputStreamReader(System.in));
                 	int id = Integer.parseInt(scanner1.readLine());
                 	if(id>=con.rows) {
                 		System.out.println("Can't find product");
                 		break;
                 	}
                 	con.updateTable(editProduct(id), id);
                     break;
                 case 0:
                     System.out.println("Good bye!");
                     break; 
             }
    	 }
    }
    public static void inSystem(boolean b) throws IOException {
    	ConnectionDB con = new ConnectionDB();
    	Product[] p = new Product[]{
                new Product(1, "Nike", "Shirt", "M", 5),
                new Product(2, "Adidas", "Skirt", "S", 2),
                new Product(3, "Gucci", "Jacket", "L", 3),
                new Product(4, "Husqu", "Skirt", "M", 1),
                new Product(5, "GymBeam", "Jacket", "L", 8),
                new Product(6, "LuiWi", "Socks", "S", 4),
                new Product(7, "Nike", "T-shirt", "L", 1),
                new Product(8, "Adidas", "Skirt", "S", 1),
                new Product(9, "Gucci", "Jacket", "L", 7)
        };
    	if(b==true) {
    		int choice = -1;
    		while(choice!=0){
	            System.out.println("1) Show products");
	            System.out.println("2) Add product");
	            System.out.println("3) Update product");
	            System.out.println("4) Remove product");
	            System.out.println("5) Prefill database");
	            System.out.println("6) Save products in file");
	            System.out.println("0) Quit");
	            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	            String ss = bufferRead.readLine();
	            choice =Integer.parseInt(ss);
	            switch (choice){
	                case 1:
	                    con.selectTable();
	                    break;
	                case 2:
	                	Product temp =  createProduct();
	                	con.insertTable(temp);
	                    break;
	                case 3:
	                	System.out.println("Enter ID of product:");
	                	BufferedReader scanner1 = new BufferedReader(new InputStreamReader(System.in));
	                	int id = Integer.parseInt(scanner1.readLine());
	                	if(id>=con.rows) {
	                		System.out.println("Can't find product");
	                		break;
	                	}
	                	con.updateTable(editProduct(id), id);
	                    break;
	                case 4:
	                	System.out.println("Enter ID of product you want to remove:");
	                	BufferedReader scanner2 = new BufferedReader(new InputStreamReader(System.in));
	                	int rid = Integer.parseInt(scanner2.readLine());
	                	con.removeTable(rid);
	                    break;
	                case 5:
	                	con.preInsert(p);
	                    break;
	                case 6:
	                	con.saveS();
	                    break;
	                case 0:
	                    System.out.println("Good bye!");
	                    break;
	            } 
    		}
    	}else {
    		System.out.println("Wrong Login");
    	}
    	
    }
    
    public static User login() throws IOException {
    	System.out.println("Enter name:");
    	BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String name = scanner.readLine();
    	System.out.println("Enter password:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	String password = scanner.readLine();
		return new User(name,password);
    }
    public static Product createProduct() throws IOException {
    	System.out.println("Enter name of product:");
    	BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String name = scanner.readLine();
    	System.out.println("Enter type of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	String type = scanner.readLine();
    	System.out.println("Enter size of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	String size = scanner.readLine();
    	System.out.println("Enter quantity of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	int quantity = Integer.parseInt(scanner.readLine());
    	
        Product tempProd = new Product(0, name, type, size, quantity);
		return tempProd;
    }
    public static Product editProduct(int id) throws IOException {
    	System.out.println("Enter name of product:");
    	BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String name = scanner.readLine();
    	System.out.println("Enter type of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	String type = scanner.readLine();
    	System.out.println("Enter size of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	String size = scanner.readLine();
    	System.out.println("Enter quantity of product:");
    	scanner = new BufferedReader(new InputStreamReader(System.in));
    	int quantity = Integer.parseInt(scanner.readLine());
        Product tempProd = new Product(id, name, type, size, quantity);
        System.out.println(id);
		return tempProd;
    }
}
