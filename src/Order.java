import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    public Order (ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);

        String placeOrder = input.nextLine();

        ArrayList<Object> order = new ArrayList<Object>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            // leave blank
        } else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;

        while (ordering) {
            // loop continues
            System.out.println("What would you like to order? " +
                    "Please use the number associated with each item to order.");

            int orderChoice = input.nextInt();
            input.nextLine();

            if (orderChoice == 1) {
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            } else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            } else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            } else if (orderChoice == 4) {
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");
            } else if (orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            } else if (orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            } else {
                System.out.println("Sorry, we don't seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");

            placeOrder = input.nextLine();

            if (!placeOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }

        System.out.println(order.get(0));
        System.out.println(order.get(1));

        double subtotal = 0.0;

        for (int i = 2; i < order.size(); i++) {
            if (order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).getPrice());
                subtotal += cupcakeMenu.get(0).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).getPrice());
                subtotal += cupcakeMenu.get(1).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(2))) {
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).getPrice());
                subtotal += cupcakeMenu.get(2).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(0))) {
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).getPrice());
                subtotal += drinkMenu.get(0).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(1))) {
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).getPrice());
                subtotal += drinkMenu.get(1).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(2))) {
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).getPrice());
                subtotal += drinkMenu.get(2).getPrice();
            }
        }

        System.out.println("$" + subtotal + "\n");
        new CreateFile();
        new WriteToFile(order);
    }


}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File ("salesData.txt");

            if (salesData.createNewFile()) {
                System.out.println("File created: " + salesData.getName());
            } else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter ("salesData.txt", true);

            PrintWriter salesWriter = new PrintWriter (fw);

            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }

            salesWriter.close();

            System.out.println("Successfully wrote to the file");
        }
        catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}