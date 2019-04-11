
package Classes;

public class AtributosData {
      
private String horaCriacao;
  private String ultimoAcesso;
  private String  ultimaModificao;

    public AtributosData(String horaCriacao, String ultimoAcesso, String ultimaModificao) {
        this.horaCriacao = horaCriacao;
        this.ultimoAcesso = ultimoAcesso;
        this.ultimaModificao = ultimaModificao;
    }

    public AtributosData() {
    }

    public String getHoraCriacao() {
        return horaCriacao;
    }

    public void setHoraCriacao(String horaCriacao) {
        this.horaCriacao = horaCriacao;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getUltimaModificao() {
        return ultimaModificao;
    }

    public void setUltimaModificao(String ultimaModificao) {
        this.ultimaModificao = ultimaModificao;
    }
     
}
