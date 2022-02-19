// Class that conducts basic arithmetic functions.
public class Calculations 
{
    // Display current balance in account
    public double checkCosts(double balance, double totalCost, double income)
    {
        if(totalCost==0){
            balance = income;
        }
        return balance;
    }

    // Display current balance in account
    public void showBalance(double balance, double income)
    {
        System.out.println("\nRemaining Balance : $" + balance + " out of $" + income);
        System.out.println();
    }

    // Withdraw amount and update the balance
    public double amountWithdrawing(double income, double totalCost)
    {
        double balance = 0;
        if (income >= totalCost) {
            balance = income - totalCost;
            showBalance(balance, income);
        }
        else {
            System.out.println();
        }
        return balance;
    }
}

