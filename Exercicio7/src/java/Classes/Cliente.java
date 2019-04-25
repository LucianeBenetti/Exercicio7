package Classes;

public class Cliente {

    private String nome;
    private String celular;
    private String endereço;

    public Cliente() {
    }

    public Cliente(String nome, String celular, String endereço) {
        this.nome = nome;
        this.celular = celular;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", celular=" + celular + ", endere\u00e7o=" + endereço + '}';
    }
    
    

}
