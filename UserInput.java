import java.util.*;

// Main class for the program
class UserInput {

    // Assigns user input to income variable and returns it
    public double userIncome (Scanner input) {
        double income = 0.0;
        do {
            try {
                System.out.println("Please specify your income for the month: ");
                // User input is assigned to the income variable
                income = input.nextDouble();
            // Notifies user if there are any errors, and asks them to enter a valid number.
            } catch (Exception e) {
                System.out.print("\nPlease enter a valid number.\n");
            }
            input.nextLine();        
        } while (income <= 0);
        return income;
    }

    // Assigns user input to the cost variable and returns it
    public double itemCost (Scanner input) {
        double cost = 0.0;
        do {
            try {
                System.out.println("\nWhat is the cost of this expense: ");
                // User input is assigned to the income variable
                cost = input.nextDouble();
            // Notifies user if there are any errors, and asks them to enter a valid number.
            } catch (Exception e) {
                System.out.print("\nPlease enter a valid number.\n");
            }
            input.nextLine();        
        } while (cost <= 0);
        return cost;
    }
}