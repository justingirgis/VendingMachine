import java.util.ArrayList;
import java.lang.Math;
import java.text.DecimalFormat;

public class VendingMachine {
    private ArrayList<Product> products;
    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinPurchase;
    private double coinSum;

    /**
     * Default constructor
     */
    public VendingMachine() {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
        coinSum = 0.0;
    }

    /**
     * Constructor to insert a product
     * @param product Product object
     */
    public VendingMachine(Product product) {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
        products.add(product);
        coinSum = 0.00;
    }

    /**
     * Constructor to insert a list of product objects
     * @param listProduct Product arraylist
     */
    public VendingMachine(ArrayList<Product> listProduct) {
        products = new ArrayList<>();
        coins = new ArrayList<>();
        coinPurchase = new ArrayList<>();
        products.addAll(listProduct);
        coinSum = 0.00;
    }

    /**
     * Method to add individual product to the arraylist of available products
     * @param product Product object
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Method to add a list of products
     * @param productList ArrayList of product objects
     */
    public void addProducts(ArrayList<Product> productList) {
        products.addAll(productList);
    }

    /**
     * Method to buy a product.
     * @param product Product object product
     */
    public Object purchase(String product) {
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            if (item.getName().equals(product)) {
                if (coinSum >= item.getCost()) {
                    System.out.println("You bought " + Math.addExact(i, 1) + " " + item.getName());
                    coins.addAll(coinPurchase);
                    products.remove(i);
                    coinPurchase.clear();
                    coinSum = coinSum - item.getCost();
                    return item;
                } else
                    System.out.println("Insufficient money!");
            }
        }
        return coinPurchase;
    }

    /**
     * Method to insert coins for purchase of item
     * @param coin Coin object
     */
    public void insertCoins(Coin coin) {
        coinPurchase.add(coin);
        coinSum += coin.getValue();
    }

    /**
     * Getter for coin sum
     * @return double value of coin sum
     */
    public String getCoinSum() {
        double roundOff = Math.round(coinSum * 100.0) / 100.0;
        DecimalFormat f = new DecimalFormat("##.00");
        return (f.format(coinSum));
    }

    /**
     * Method to get list of coins in vending machine
     * @return arraylist of coin objects
     */
    public ArrayList<Coin> getCoins() {
        return coins;
    }

    /**
     * Method to remove all coins from vending machine
     * @return Arraylist of coin objects
     */
    public ArrayList<Coin> removeCoins() {
        coinSum = 0;
        return coins;
    }

    @Override
    /**
     * Method to Override toString
     */
    public String toString() {
        String result = "";
        for (Product product : products) {
            result += product.getName() + " $" + product.getCost() + "\n";
        }
        return result;
    }
}