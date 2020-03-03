/*
Justin Girgis and Serenity
CECS 277
Project 3
October 10, 2019
 */

import java.util.ArrayList;
import java.util.Scanner; //scanner for user input

public class Tester2 {
    /**
     * price, quantity, output, name
     * @param args
     */
    public static void main(String[] args) {
        char input = 'c'; //null input to start off while loop
        String output ="";
        double price = 0.0;
        int quantity = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        VendingMachine VM = new VendingMachine();
        String name ="";

        Coin dollar = new Coin("Dollar", 1.00);
        Coin nickel = new Coin("Nickel", 0.05);
        Coin dime = new Coin("Dime", 0.1);
        Coin quarter = new Coin("Quarter", 0.25);

        do {
            output.toString(); // call the toString

            System.out.println("S)how products I)nsert coin B)uy A)dd product R)emove coins Q)uit");
            input = scanner.next().charAt(0);

            if(input == 'S' || input == 's') {
                for (int i = 0; i < products.size(); i++)
                    System.out.println(products.get(i));
            }
            else if(input == 'I' || input == 'i') {
                nickel.toString();
                System.out.println("A) nickel @ 0.05");
                System.out.println("B) dime @ 0.1");
                System.out.println("C) quarter @ 0.25");
                System.out.println("D) dollar @ 1.0");
                input = scanner.next().charAt(0);

                if (input == 'A' || input == 'a') //adds money based off of char input
                    VM.insertCoins(nickel);
                else if (input == 'B' || input == 'b')
                    VM.insertCoins(dime);
                else if (input == 'C' || input == 'c')
                    VM.insertCoins(quarter);
                else if (input == 'D' || input == 'd')
                    VM.insertCoins(dollar);

                System.out.println("You have inserted: $" + VM.getCoinSum());
            } else if(input == 'A' || input == 'a') {
                System.out.println("Description: ");
                name = scanner.next();

                System.out.println("Price: ");
                price = scanner.nextDouble();

                System.out.println("Quantity: ");
                quantity = scanner.nextInt();

                Product product1 = new Product(name, price, quantity); // call new product with inputted data
                products.add(product1); //add product to Array List so it is saved
                VM.addProduct(product1); //add product ot VM

            } else if (input == 'B' || input == 'b') {
                for(int i = 0; i < products.size() ; i++) {
                    System.out.println(i+1 + ") " + products.get(i));
                }
                int choice = scanner.nextInt();

                if(choice > products.size()) {
                    System.out.println("Invalid choice!");
                    choice = scanner.nextInt();
                }
                else {
                    VM.purchase((products.get(choice - 1)).getName());
                    //products.remove(choice-1);
                }
            } else if (input == 'R' || input == 'r') {
                System.out.println("You have been returned: $ " + VM.getCoinSum());
                VM.removeCoins();
            }


        } while (input != 'Q' && input != 'q');
    }

    public String toString() { // defualt toString
        String intro = "S)how products I)nsert coin B)uy A)dd product R)emove coins Q)uit\n";
        return intro;
    }
}
