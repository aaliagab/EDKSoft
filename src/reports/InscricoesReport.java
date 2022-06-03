/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.util.Date;
import pojos.Inscricao;

/**
 *
 * @author
 */
public class InscricoesReport {

    private String aluno;
    private String categoria;
    private String tipoInscricao;
    private Date data;

    public InscricoesReport(Inscricao obj) {
        this.aluno = obj.getAluno().getPessoa().getNome()+" "+obj.getAluno().getPessoa().getSobrenome();
        this.categoria = obj.getCategoria().getNome();
        this.tipoInscricao = obj.getTipoInscricao().getNome();
        this.data = obj.getData();
    }

    public String getAluno() {
        return aluno;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipoInscricao() {
        return tipoInscricao;
    }

    public Date getData() {
        return data;
    }
    
       

}
