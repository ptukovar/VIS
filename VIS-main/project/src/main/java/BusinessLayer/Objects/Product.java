package BusinessLayer.Objects;

public class Product {
	public int id;
    public String name;
    public String type;
    public String size;
    public int quantity;

    public Product(int id, String name, String type, String size, int quantity) {
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
