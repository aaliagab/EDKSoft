package pojos;
// Generated 09-may-2022 18:22:43 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Exame generated by hbm2java
 */
public class Exame  implements java.io.Serializable {


     private Integer id;
     private Categoria categoria;
     private Instructor instructor;
     private Tipo tipo;
     private Date data;
     private String hora;
     private String duracao;
     private Set<AlunoExame> alunoExames = new HashSet<AlunoExame>(0);

    public Exame() {
    }

	
    public Exame(Categoria categoria, Instructor instructor, Tipo tipo, Date data, String hora, String duracao) {
        this.categoria = categoria;
        this.instructor = instructor;
        this.tipo = tipo;
        this.data = data;
        this.hora = hora;
        this.duracao = duracao;
    }
    public Exame(Categoria categoria, Instructor instructor, Tipo tipo, Date data, String hora, String duracao, Set<AlunoExame> alunoExames) {
       this.categoria = categoria;
       this.instructor = instructor;
       this.tipo = tipo;
       this.data = data;
       this.hora = hora;
       this.duracao = duracao;
       this.alunoExames = alunoExames;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Instructor getInstructor() {
        return this.instructor;
    }
    
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDuracao() {
        return this.duracao;
    }
    
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public Set<AlunoExame> getAlunoExames() {
        return this.alunoExames;
    }
    
    public void setAlunoExames(Set<AlunoExame> alunoExames) {
        this.alunoExames = alunoExames;
    }




}


