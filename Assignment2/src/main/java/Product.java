// Product domain is parent of macbook, iphone, airpods
public class Product {

    // As basic property of product, price should exists
    private int basePrice;

    // After user selects model and options, total cost is necessary
    private int totalCost = 0;

    // There are 3 models and 1 exit in model options but this field is only for model
    private String model;

    // Quantity means how many user will buy products
    private int quantity;

    // Because fields of product are private, Getter and Setter method is necessary
    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // This method is for getting user selection model and will be changed by other domains
    public void getUserSelection() {

    }

    // This method is for calculating cost of adding options to model so this will also be changed by other domains
    public void calculateCost() {

    }
}
