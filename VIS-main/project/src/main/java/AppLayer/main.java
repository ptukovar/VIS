package AppLayer;
import java.io.IOException;
import java.sql.SQLException;

import BusinessLayer.Mappers.ProductsMapper;
import BusinessLayer.TransactionScripts.LoginScript;
import BusinessLayer.TransactionScripts.RegisterScript;

public class main {
    public static void main(String args[]) throws IOException, SQLException {
    	int choice = -1;
    	MenuHelper menu = new MenuHelper();
    	while(choice!=0){
    		menu.outOptions();
	        choice=menu.KeyReader();
            switch (choice){
	        	case 1: 
	            	System.out.println("Enter name:");
	                String name = menu.StringReader();
	                
	            	System.out.println("Enter password:");
	            	String password = menu.StringReader();
	            	
	            	LoginScript logScript = new LoginScript();
	            	boolean logSuccess = logScript.login(name, password);
	            	
	            	if(logSuccess){
	            		System.out.println("Welcome!");
	            		int inMenu = -1;
	            		while(inMenu!=0) {
	            			menu.inOptions();
	        	            inMenu = menu.KeyReader();
	        	            ProductsMapper productMap = new ProductsMapper();
	            			switch(inMenu) {
		        	            case 1:	productMap.displayProducts();
		        	            	break;
		        	            case 2: productMap.insertProduct();
		        	            	break;
		        	            case 3: productMap.editProduct();
		        	            	break;
		        	            case 4: productMap.removeProduct();
		        	            	break;
		        	            case 5: productMap.prefillProducts();
		        	            	break;
		        	            case 6: productMap.saveProducts();
		        	            	break;
		        	            case 0:
		        	        		System.out.println("Goodbye");
		        	            	System.exit(0);
	            			}
	            		}
	            	}else{
	            		System.out.println("Wrong login!");
	            		break;
	            	}
	            	
	        	case 2:
	        		System.out.println("Enter name:");
	                String nameReg = menu.StringReader();
	                
	            	System.out.println("Enter password:");
	            	String passwordReg = menu.StringReader();
	            	
	            	System.out.println("Enter password again:");
	            	String passwordRegCheck = menu.StringReader();
	            	
	            	RegisterScript regScript = new RegisterScript();
	            	boolean regSuccess = regScript.register(nameReg, passwordReg, passwordRegCheck);
	            	
	            	if(regSuccess){
	            		System.out.println("Success!");
	            		break;
	            	}else{
	            		System.out.println("Error!");
	            		break;
	            	}

	        	case 0:
	        		System.out.println("Goodbye");
	        		System.exit(0);
	            default:
	            	System.out.println("Wrong option!");
	            	break;
            	}
            }
    	System.exit(0);
    	}
}