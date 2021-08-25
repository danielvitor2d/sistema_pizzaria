package model.bean;

public class ReceitaBean {

    private String produto;
    private double qtdoupeso;
    private double precofinal;
    private String receita;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getQtdoupeso() {
        return qtdoupeso;
    }

    public void setQtdoupeso(double qtdoupeso) {
        this.qtdoupeso = qtdoupeso;
    }

    public double getPrecofinal() {
        return precofinal;
    }

    public void setPrecofinal(double precofinal) {
        this.precofinal = precofinal;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

}
