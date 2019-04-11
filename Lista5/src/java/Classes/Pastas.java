
package Classes;

import java.util.Date;

public class Pastas {
 
    private String nome;
    private boolean ehDiretorio;
    private long tamanho;
    private Date dataCriacao;
    private Date ultimaModificacao;

    public Pastas() {
    }

    public Pastas(String nome, boolean ehDiretorio, long tamanho, Date dataCriacao, Date ultimaModificacao) {
       
        this.nome = nome;
        this.ehDiretorio=ehDiretorio;
        this.tamanho = tamanho;
        this.dataCriacao = dataCriacao;
        this.ultimaModificacao = ultimaModificacao;
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



    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
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

    @Override
    public String toString() {
        return "DadosArquivosDiretorios{" + ", nomeArquivo=" + nome + ", "+" tamanho=" + tamanho + ", dataCriacao=" + dataCriacao + ", ultimaModificacao=" + ultimaModificacao + '}';
    }
    
    
    
}
