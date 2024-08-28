
import java.util.*;
import java.text.DecimalFormat;

public class PizzaOutlet {
    public static void main(String[] args) {
        DecimalFormat money = new DecimalFormat("#0.00");
        Scanner keyboard = new Scanner(System.in);

        // Create multiple outlets
        ArrayList<Outlet> outlets = new ArrayList<>();
        outlets.add(new Outlet("LJU Pizza Outlet 1", "105 Shivalik Satyamev, Bopal"));
        outlets.add(new Outlet("LJU Pizza Outlet 2", "205 Empire Business hub, Science City"));
        outlets.add(new Outlet("LJU Pizza Outlet 3", "101 Shivalik Ship, Iskon"));

        // Add employees to each outlet

        // detailes of Outlet 1 
        outlets.get(0).addEmployee(new Employee("Harsh", 101, "Manager"));
        outlets.get(0).addEmployee(new Employee("Sahil", 102, "Chef"));
        outlets.get(0).addEmployee(new Employee("Jay", 103, "Cashier"));

        // detailes of Outlet 2 
        outlets.get(1).addEmployee(new Employee("Arth", 104, "Manager"));
        outlets.get(1).addEmployee(new Employee("Manan", 105, "Chef"));
        outlets.get(1).addEmployee(new Employee("Diya", 106, "Cashier"));

        // detailes of Outlet 3
        outlets.get(2).addEmployee(new Employee("Richa", 107, "Manager"));
        outlets.get(2).addEmployee(new Employee("Heena", 108, "Chef"));
        outlets.get(2).addEmployee(new Employee("Dharvi", 109, "Cashier"));

        // Select an outlet
        Outlet selectedOutlet = selectOutlet(outlets, keyboard);

        // Display selected outlet and employee details
        System.out.println("\n==============================================");
        System.out.println("You selected:");
        selectedOutlet.displayDetails();
        System.out.println("==============================================");

        // Initialize total cost
        double totalCost = 0;

        // Loop for multiple orders
        boolean ordering = true;
        while (ordering) {
            totalCost += placeOrder(keyboard, selectedOutlet);

            // Ask if the user wants to place another order
            System.out.print("\nWould you like to order another pizza? (Y/N): ");
            String moreOrder = keyboard.nextLine();
            if (!moreOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }

        // Display final total cost
        System.out.println("\n==============================================");
        System.out.println("The total cost of all your orders is: Rs " + money.format(totalCost));
        System.out.println("Your order(s) will be ready for pickup in 30 minutes.");
        System.out.println("==============================================");
        keyboard.close();
    }

    // Method to select an outlet
    public static Outlet selectOutlet(ArrayList<Outlet> outlets, Scanner keyboard) {
        System.out.println("\n==============================================");
        System.out.println("Available Outlets:");
        for (int i = 0; i < outlets.size(); i++) {
            System.out.println((i + 1) + ". " + outlets.get(i).getName() + " - " + outlets.get(i).getAddress());
        }
        System.out.print("\nPlease select an outlet by number: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();  // Consume newline

        if (choice < 1 || choice > outlets.size()) {
            System.out.println("\nInvalid choice, defaulting to the first outlet.");
            choice = 1;
        }

        return outlets.get(choice - 1);
    }

    // Method to place an order
    public static double placeOrder(Scanner keyboard, Outlet selectedOutlet) {
        DecimalFormat money = new DecimalFormat("#0.00");
        boolean discount = false;
        int inches;
        char crustType;
        double cost;
        final double TAX_RATE = .12;
        double tax;
        char choice;
        String input;
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("Cheese");
        int numberOfToppings = 0;

        // Prompt user and get first name
        System.out.println("\n==============================================");
        System.out.println("Welcome to " + selectedOutlet.getName());
        System.out.print("Enter your name: ");
        String firstName = keyboard.nextLine();

        // Determine if user is eligible for a discount
        if (firstName.equalsIgnoreCase("DEV") ||
            firstName.equalsIgnoreCase("DARSHIT") ||
            firstName.equalsIgnoreCase("vedant") ||
            firstName.equalsIgnoreCase("jeel")) {
            discount = true;
        }

        // Prompt user and get pizza size choice
        System.out.println("\nPizza Size (inches)   Cost");
        System.out.println("              10      Rs.250");
        System.out.println("              12      Rs.350");
        System.out.println("              14      Rs.450");
        System.out.println("              16      Rs.550");
        System.out.print("\nWhat size pizza would you like? 10, 12, 14, or 16 (enter the number only): ");
        inches = keyboard.nextInt();

        // Create an instance of a Pizza
        Pizza order = new Pizza();

        // Set price and size of pizza ordered
        if (inches == 10) {
            order.setSize(10);
            order.setCost(-100);
        } else if (inches == 12) {
            order.setSize(12);
            order.setCost(0);
        } else if (inches == 14) {
            order.setSize(14);
            order.setCost(100);
        } else if (inches == 16) {
            order.setSize(16);
            order.setCost(200);
        } else {
            System.out.println("\nUser input was not one of the choices, so a 12 inch pizza will be made.");
            order.setSize(12);
            order.setCost(0);
        }

        // Consume the remaining newline character
        keyboard.nextLine();

        // Prompt user and get crust choice
        System.out.println("\nWhat type of crust do you want?");
        System.out.print("(H) Hand-tossed, (T) Thin-crust, or (D) Deep-dish (enter H, T, or D): ");
        input = keyboard.nextLine();
        crustType = input.charAt(0);

        // Set user's crust choice on pizza ordered
        switch (crustType) {
            case 'H':
            case 'h':
                order.setCrust("Hand-Tossed");
                break;
            case 'T':
            case 't':
                order.setCrust("Thin-Crust");
                break;
            case 'D':
            case 'd':
                order.setCrust("Deep Dish");
                break;
            default:
                System.out.println("\nUser's input not one of the choices, so a hand-tossed crust will be made.");
                order.setCrust("Hand-Tossed");
        }

        // Prompt user and get topping choices one at a time
        System.out.println("\nAll pizzas come with cheese.");
        System.out.println("Additional toppings are Rs 30.0 each, choose from Pepperoni, Sausage, Onion, Mushroom");

        System.out.print("\nDo you want Pepperoni? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings++;
            toppings.add("Pepperoni");
        }
        System.out.print("Do you want Sausage? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings++;
            toppings.add("Sausage");
        }
        System.out.print("Do you want Onion? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings++;
            toppings.add("Onion");
        }
        System.out.print("Do you want Mushroom? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings++;
            toppings.add("Mushroom");
        }

        // Set number of toppings and topping list on pizza ordered
        order.setNumToppings(numberOfToppings);
        order.setToppingList(toppings);

        // Add additional toppings cost to the cost of pizza
        order.setCost(30 * numberOfToppings);

        // Display order confirmation
        System.out.println("\n==============================================");
        System.out.println("Your order is as follows:");
        System.out.println("Size: " + order.getSize() + " inch pizza");
        System.out.println("Crust type: " + order.getCrust());
        System.out.println("Your toppings: " + order.getToppingList());

        System.out.println();

        // Apply discount if user is eligible
        if (discount) {
            System.out.println("\nYou are eligible for a Rs 100.0 discount.");
            order.setCost(-100);
        }

        System.out.println("Special Discount Amount is 20%");

        // Display cost of pizza
        cost = order.getCost();
        double discountAmount = cost * 0.20;
        cost -= discountAmount;
        System.out.println("20% discount : " + discountAmount);
        System.out.println("\nThe cost of your order is: Rs " + money.format(cost));


        // Calculate and display tax and total cost
        tax = cost * TAX_RATE;
        System.out.println("The tax is: Rs " + money.format(tax));
        System.out.println("The total due is: Rs " + money.format(tax + cost));
        System.out.println("==============================================");

        return tax + cost;
    }
}