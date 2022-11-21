import DataLayer.Product;
import DataLayer.productsDB;

public class main {
    public static void main(String args[]){
        Product[] p = new Product[]{
                new Product(1, "Nike", "Shirt", 'M', 5),
                new Product(2, "Adidas", "Skirt", 'S', 2),
                new Product(2, "Gucci", "Jacket", 'L', 3),
                new Product(3, "Husqu", "Skirt", 'M', 1),
                new Product(4, "GymBeam", "Jacket", 'L', 8),
                new Product(5, "LuiWi", "Socks", 'S', 4),
                new Product(6, "Nike", "T-shirt", 'L', 1),
                new Product(7, "Adidas", "Skirt", 'S', 1),
                new Product(9, "Gucci", "Jacket", 'L', 7)
        };
        productsDB d1 = new productsDB();
        int i=0;
        for (Product product:p){
            d1.addProduct(p[i]);
            i++;
        }
        d1.displayProducts();
    }
}
