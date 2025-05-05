import java.time.LocalDate;

public class Expense {
    private String category;
    private double value;
    private int id;
    private LocalDate date;

    public Expense(){}

    public Expense(String category, double value, int id, LocalDate date){
        this.category = category;
        this.value = value;
        this.id = id;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }
    public double getValue() {
        return value;
    }
    public int getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setCategory(String category){
        this.category = category;
    }
    public void setValue(double value){
        this.value = value;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}

