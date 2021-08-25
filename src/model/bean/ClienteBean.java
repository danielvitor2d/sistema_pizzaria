package model.bean;

public class ClienteBean {

    private int id;
    private String nome;
    private String apelido;
    private String rua;
    private String numero;
    private String complemento;
    private String cidade;
    private String bairro;
    private String numerot;

    public ClienteBean() {
    }

    public ClienteBean(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "ClienteBean{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", bairro=" + bairro + ", numerot=" + numerot + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumerot() {
        return numerot;
    }

    public void setNumerot(String numerot) {
        this.numerot = numerot;
    }

}
