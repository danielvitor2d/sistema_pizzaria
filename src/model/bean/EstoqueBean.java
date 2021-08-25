package model.bean;

public class EstoqueBean {

    private int id;
    private String prod;
    private double qdtoupe;
    private double preco;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public double getQdtoupe() {
        return qdtoupe;
    }

    public void setQdtoupe(double qdt) {
        this.qdtoupe = qdt;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
