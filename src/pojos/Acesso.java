package pojos;
// Generated 05-may-2022 17:44:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Acesso generated by hbm2java
 */
public class Acesso  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Acesso() {
    }

	
    public Acesso(String nome) {
        this.nome = nome;
    }
    public Acesso(String nome, Set<Usuario> usuarios) {
       this.nome = nome;
       this.usuarios = usuarios;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


