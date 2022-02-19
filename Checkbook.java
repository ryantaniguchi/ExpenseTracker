import java.io.*;
import java.util.*;

// Main class for the program
class Checkbook {

    // Main function of the program
    public static void main(String[] args)
    throws IOException 
    {
        // Creates an instance of the Calculations, StoreData, and UserInput classes
        Calculations calculate = new Calculations();
        StoreData storage = new StoreData();
        UserInput user = new UserInput();

        // Declare the variables
        Double income = 0.0, totalCost = 0.0, remainder = 0.0, percentage = 0.0;
        char reply;

        // Creates a hashmap to store expenses and their costs
        HashMap<String, Double> costsMap = new HashMap<>();

        // Set the name of the file this data will be stored to.
        String fileName = "monthlyExpenses.txt";

        // Create Scanner object to take in user input
        Scanner input = new Scanner(System.in);
        
        // Input the integer. Loops until a valid number is provided.
        income = user.userIncome(input);

        // Stores the total income to the storage file
        storage.SaveBalance(fileName, "Income: ", income);

        // Collects expense information, looping until the user indicates there 
        // are no more.
        do{

            // Asks for the name of the next expense
            System.out.println("\nWhat is the name of the next expense? ");
            String expense = input.next();

            // Calls the itemCost function to get the cost of the next expense
            double cost = user.itemCost(input);

            // Calculates the total cost and remainder.
            if((totalCost + cost) < income){
                // Places both expense names and their cost into the hashmap.
                costsMap.put(expense, cost);
                storage.saveExpenses(fileName, expense, cost);
                totalCost += cost; 
                remainder = calculate.amountWithdrawing(income, totalCost);
            }
            else {
                System.out.println("Sorry! Insufficient Funds");
            }
            
            // Displays their income
            System.out.println("Your income for this month is $"+ income);

            // Prints each expense and what it is for
            System.out.println("\nCosts:");
            for (Map.Entry<String, Double> m : costsMap.entrySet()) {
                // Determines what percentage of income each item costs
                percentage = (m.getValue() / income) * 100;
                // Prints out the name, cost, and percentage of each expense
                System.out.println(m.getKey() + ": $" + m.getValue() + ", " + percentage + "% of your income");
            }
            // Verify that costs have occurred
            remainder = calculate.checkCosts(remainder, totalCost, income);

            // Check if the user wants to go again
            System.out.println("\nType any key to add another expense. Type 'q' to quit.");
            reply = input.next().charAt(0);   
            
        // Breaks the loop if the user responds 'n'.
        }while(reply!='q');

        // Stores the remaining balance to the storage file
        storage.SaveBalance(fileName, "Remainder: ", remainder);
        
        // Prints contents of the storage file
        storage.readFile(fileName);

        // Closes the scanner
        input.close();
    }
}
