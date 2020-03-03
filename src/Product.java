public class Product {
    public String name;
    private double cost = 0.0;
    private int quantity = 0;

    /**
     * Null Constructor
     */
    public Product() {
        name = "";
        cost = 0.0;
        quantity = 0;
    }

    /**
     * Overloaded constructor
     * @param name String name of product
     * @param cost double cost of product
     */
    public Product(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name Sets name to name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for cost
     * @return double value cost
     */
    public double getCost() {
        return cost;
    }
    /**
     * Getter for quantity
     * @return int quantity
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for cost
     * @param cost double cost value
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Overriding toString method
     * @return String of product
     */
    @Override
    public String toString() {
        return name + " @ " + cost;
    }

}