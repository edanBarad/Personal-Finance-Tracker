import java.io.FileWriter;
import java.util.ArrayList;

public class FinanceManager {
    private ArrayList<Transaction> transactions;
    public FinanceManager (ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void viewTransactions(){
        System.out.println(this.transactions);
    }

    public void calculateBalance(){
        double income = 0, expenses = 0, balance = 0;
        for (Transaction t : this.transactions){
            if (t.getType().equals("income")){
                balance += t.getAmount();
                income += t.getAmount();
            }else if(t.getType().equals("expense")) expenses += t.getAmount();
        }
        System.out.println("Total income = " + income);
        System.out.println("Total expenses = " + expenses);
        System.out.println("Balance = " + balance);
    }

    public void saveToFile(String filename){
        //FileWriter writer = new FileWriter();
    }

}