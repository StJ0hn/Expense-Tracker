import java.util.ArrayList;

public class ExpenseService {
    private ArrayList <Expense> expenses = new ArrayList<>();
    //method to add a expense in ArrayList:
    public void add(Expense expense){
        expenses.add(expense);
    }
    //method to list all expenses in ArrayList:
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
    //method to remove a expense of ArrayList:
    public void remove(int id){
        if(id >= 0 && id < expenses.size()){
            expenses.remove(id);
        }
        else {
            System.out.println("Invalid index. Failed to remove expense at given id.");
        }
    }
    //method to get total amount of expenses:
    public double getTotalExpenses(){
        double sum = 0;
        for(Expense expense : expenses){
            sum += expense.getValue();
        }
        return sum;
    }
    //method to return total expenses of month:
    public double getMonthExpense(int month){
        double sum = 0;
        for (Expense e : expenses){
            if(e.getDate().getMonthValue() == month){
                sum += e.getValue();
            }
        }
    return sum;
    }
    //method to clear ArrayList:
    public void clearExpenses(){
        expenses.clear();
    }
}
