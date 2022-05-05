package pojos;
// Generated 05-may-2022 17:44:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Aula generated by hbm2java
 */
public class Aula  implements java.io.Serializable {


     private Integer id;
     private Professor professor;
     private Tipo tipo;
     private String sumario;
     private Date dateAula;
     private int numero;
     private String horaInicio;
     private String duracao;
     private Set<AlunoAula> alunoAulas = new HashSet<AlunoAula>(0);

    public Aula() {
    }

	
    public Aula(Professor professor, Tipo tipo, String sumario, Date dateAula, int numero, String horaInicio, String duracao) {
        this.professor = professor;
        this.tipo = tipo;
        this.sumario = sumario;
        this.dateAula = dateAula;
        this.numero = numero;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }
    public Aula(Professor professor, Tipo tipo, String sumario, Date dateAula, int numero, String horaInicio, String duracao, Set<AlunoAula> alunoAulas) {
       this.professor = professor;
       this.tipo = tipo;
       this.sumario = sumario;
       this.dateAula = dateAula;
       this.numero = numero;
       this.horaInicio = horaInicio;
       this.duracao = duracao;
       this.alunoAulas = alunoAulas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Professor getProfessor() {
        return this.professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String getSumario() {
        return this.sumario;
    }
    
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
    public Date getDateAula() {
        return this.dateAula;
    }
    
    public void setDateAula(Date dateAula) {
        this.dateAula = dateAula;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getDuracao() {
        return this.duracao;
    }
    
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public Set<AlunoAula> getAlunoAulas() {
        return this.alunoAulas;
    }
    
    public void setAlunoAulas(Set<AlunoAula> alunoAulas) {
        this.alunoAulas = alunoAulas;
    }




}


