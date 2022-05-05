package pojos;
// Generated 05-may-2022 17:44:55 by Hibernate Tools 4.3.1



/**
 * AlunoExame generated by hbm2java
 */
public class AlunoExame  implements java.io.Serializable {


     private Integer id;
     private Aluno aluno;
     private Exame exame;
     private String documento;
     private String registroCriminal;
     private String atestadoMedico;
     private double avaliacaoQuantitativa;
     private String avaliacaoQualitativa;

    public AlunoExame() {
    }

    public AlunoExame(Aluno aluno, Exame exame, String documento, String registroCriminal, String atestadoMedico, double avaliacaoQuantitativa, String avaliacaoQualitativa) {
       this.aluno = aluno;
       this.exame = exame;
       this.documento = documento;
       this.registroCriminal = registroCriminal;
       this.atestadoMedico = atestadoMedico;
       this.avaliacaoQuantitativa = avaliacaoQuantitativa;
       this.avaliacaoQualitativa = avaliacaoQualitativa;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Aluno getAluno() {
        return this.aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Exame getExame() {
        return this.exame;
    }
    
    public void setExame(Exame exame) {
        this.exame = exame;
    }
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getRegistroCriminal() {
        return this.registroCriminal;
    }
    
    public void setRegistroCriminal(String registroCriminal) {
        this.registroCriminal = registroCriminal;
    }
    public String getAtestadoMedico() {
        return this.atestadoMedico;
    }
    
    public void setAtestadoMedico(String atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }
    public double getAvaliacaoQuantitativa() {
        return this.avaliacaoQuantitativa;
    }
    
    public void setAvaliacaoQuantitativa(double avaliacaoQuantitativa) {
        this.avaliacaoQuantitativa = avaliacaoQuantitativa;
    }
    public String getAvaliacaoQualitativa() {
        return this.avaliacaoQualitativa;
    }
    
    public void setAvaliacaoQualitativa(String avaliacaoQualitativa) {
        this.avaliacaoQualitativa = avaliacaoQualitativa;
    }




}

