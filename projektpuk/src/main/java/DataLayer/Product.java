package DataLayer;

public class Product {
    int id;
    String name;
    String type;
    char size;
    int quantity;

    public Product(int id, String name, String type, char size, int quantity) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.id = id;
    }
    public Product getProduct(){
        return this;
    }
}
