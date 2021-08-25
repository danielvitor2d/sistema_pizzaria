package model.bean;

public class VendaBean {

    private String cliente;
    private String produto;
    private double qtdoupe;
    private double preco;
    private String hora;
    private String minuto;
    private String segundo;
    private String nvenda;
    private double precoreal;
    private String dia;
    private String mes;
    private String ano;
    private double desc;

    @Override
    public String toString() {
        return "VendaBean{" + "cliente=" + cliente + ", produto=" + produto + ", qtdoupe=" + qtdoupe + ", preco=" + preco + ", hora=" + hora + ", minuto=" + minuto + ", segundo=" + segundo + ", nvenda=" + nvenda + ", precoreal=" + precoreal + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + ", desc=" + desc + '}';
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getPrecoreal() {
        return precoreal;
    }

    public void setPrecoreal(double precoreal) {
        this.precoreal = precoreal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getQtdoupe() {
        return qtdoupe;
    }

    public void setQtdoupe(double qtdoupe) {
        this.qtdoupe = qtdoupe;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getNvenda() {
        return nvenda;
    }

    public void setNvenda(String nvenda) {
        this.nvenda = nvenda;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

}
