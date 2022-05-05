package pojos;
// Generated 05-may-2022 17:44:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pagamento generated by hbm2java
 */
public class Pagamento  implements java.io.Serializable {


     private Integer id;
     private Inscricao inscricao;
     private Date data;
     private double valor;
     private String modo;
     private String observacao;

    public Pagamento() {
    }

	
    public Pagamento(Inscricao inscricao, Date data, double valor, String modo) {
        this.inscricao = inscricao;
        this.data = data;
        this.valor = valor;
        this.modo = modo;
    }
    public Pagamento(Inscricao inscricao, Date data, double valor, String modo, String observacao) {
       this.inscricao = inscricao;
       this.data = data;
       this.valor = valor;
       this.modo = modo;
       this.observacao = observacao;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Inscricao getInscricao() {
        return this.inscricao;
    }
    
    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getModo() {
        return this.modo;
    }
    
    public void setModo(String modo) {
        this.modo = modo;
    }
    public String getObservacao() {
        return this.observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }




}


