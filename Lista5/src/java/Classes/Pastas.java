package Classes;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Pastas {

    private String nome;
    private boolean ehDiretorio;
    private String tamanho;
    private Date dataCriacao;
    private Date ultimaModificacao;
    private String caminho;

    public Pastas() {
    }

    public Pastas(String nome, boolean ehDiretorio, String tamanho, Date dataCriacao, Date ultimaModificacao, String caminho) {
        this.nome = nome;
        this.ehDiretorio = ehDiretorio;
        this.tamanho = tamanho;
        this.dataCriacao = dataCriacao;
        this.ultimaModificacao = ultimaModificacao;
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEhDiretorio() {
        return ehDiretorio;
    }

    public void setEhDiretorio(boolean ehDiretorio) {
        this.ehDiretorio = ehDiretorio;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getUltimaModificacao() {
        return ultimaModificacao;
    }

    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }


}
