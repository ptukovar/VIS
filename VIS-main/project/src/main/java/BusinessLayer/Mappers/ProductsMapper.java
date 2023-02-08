package BusinessLayer.Mappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import BusinessLayer.Objects.Product;
import DataLayer.Gateway.ProductsGateway;

public class ProductsMapper {
	public ArrayList<Product> productList;
    public int size;

    public ProductsMapper() {
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
    public void insertProduct() throws IOException {
    	ProductsGateway prodGate = new ProductsGateway();
    	
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
        
        prodGate.insertTable(tempProd);
    }
    public void editProduct() throws NumberFormatException, IOException {
    	ProductsGateway prodGate = new ProductsGateway();
    	System.out.println("Enter ID of product:");
    	BufferedReader scanner1 = new BufferedReader(new InputStreamReader(System.in));
    	int id = Integer.parseInt(scanner1.readLine());
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
        prodGate.updateTable(tempProd);
    }
    public void displayProducts(){
    	ProductsGateway prodGate = new ProductsGateway();
    	this.productList = prodGate.selectTable();
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
    public void removeProduct() throws NumberFormatException, IOException {
    	ProductsGateway prodGate = new ProductsGateway();
    	System.out.println("Enter ID of product you want to remove:");
    	BufferedReader scanner2 = new BufferedReader(new InputStreamReader(System.in));
    	int rid = Integer.parseInt(scanner2.readLine());
    	prodGate.removeTable(rid);
    }

	public void prefillProducts() {
		ProductsGateway prodGate = new ProductsGateway();
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
		prodGate.preInsert(p);		
	}
	public void saveProducts() {
		ProductsGateway prodGate = new ProductsGateway();
		prodGate.saveS();
	}
}
