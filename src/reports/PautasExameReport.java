/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.util.Date;
import pojos.AlunoExame;
import pojos.Inscricao;

/**
 *
 * @author
 */
public class PautasExameReport {

    private String aluno;
    private int quantitativa;
    private String qualitativa;

    public PautasExameReport(AlunoExame obj) {
        this.aluno = obj.getAluno().getPessoa().getNome()+" "+obj.getAluno().getPessoa().getSobrenome();
        this.qualitativa = obj.getAvaliacaoQualitativa();
        this.quantitativa = obj.getAvaliacaoQuantitativa();
    }

    public String getAluno() {
        return aluno;
    }

    public int getQuantitativa() {
        return quantitativa;
    }

    public String getQualitativa() {
        return qualitativa;
    }

    
       

}
