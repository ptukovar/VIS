package AppLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuHelper {
	//Helper class for better looking main file
    public String StringReader() throws IOException {
    	BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        return bufReader.readLine();
    }
    public int KeyReader() throws IOException {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String bufString = bufReader.readLine();
		return Integer.parseInt(bufString);
    }
    
    public void outOptions() {
    	System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("0) Quit");
    }
    
    public void inOptions() {
    	System.out.println("1) Show products");
        System.out.println("2) Add product");
        System.out.println("3) Update product");
        System.out.println("4) Remove product");
        System.out.println("5) Prefill database");
        System.out.println("6) Save products in file");
        System.out.println("0) Quit");
    }
}
