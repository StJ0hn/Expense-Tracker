//Criando atributos(variáveis de intância);
public class Expense {
    private String categoria;
    private double valor;
    private int id;
    private String data;

    //Construtor vazio;
    public Expense(){}

    //Construtor preenchido;
    public Expense(String categoria, double valor, int id, String data){
        this.categoria = categoria;
        this.valor = valor;
        this.id = id;
        this.data = data;
    }

    //Acessar valores dos atributos [get()]. Permitir alteração dos atributos [set()];
    public String getCategoria() {
        return categoria;
    }
    public double getValor() {
        return valor;
    }
    public int getId() {
        return id;
    }
    public String getData() {
        return data;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setData(String data) {
        this.data = data;
    }
}

