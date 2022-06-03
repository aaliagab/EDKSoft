/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.util.Date;
import pojos.AlunoExame;
import pojos.Aula;
import pojos.Inscricao;
import pojos.Professor;
import pojos.Tipo;

/**
 *
 * @author
 */
public class AulasProfessorReport {

    private String professor;
    private String tipo;
    private String sumario;
    private Date dateAula;
    private int numero;
    private String horaInicio;
    private String duracao;

    public AulasProfessorReport(Aula obj) {
        this.professor = obj.getProfessor().getFuncionario().getPessoa().getNome()+" "+
                obj.getProfessor().getFuncionario().getPessoa().getSobrenome();
        this.tipo = obj.getTipo().getNome();
        this.sumario = obj.getSumario();
        this.dateAula = obj.getDateAula();
        this.numero = obj.getNumero();
        this.horaInicio = obj.getHoraInicio();
        this.duracao = obj.getDuracao();
    }

    public String getProfessor() {
        return professor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSumario() {
        return sumario;
    }

    public Date getDateAula() {
        return dateAula;
    }

    public int getNumero() {
        return numero;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getDuracao() {
        return duracao;
    }

    
    
}
