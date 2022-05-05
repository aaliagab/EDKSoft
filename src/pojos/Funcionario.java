package pojos;
// Generated 05-may-2022 17:44:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private int id;
     private Cargo cargo;
     private Pessoa pessoa;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Funcionario() {
    }

	
    public Funcionario(Cargo cargo, Pessoa pessoa) {
        this.cargo = cargo;
        this.pessoa = pessoa;
    }
    public Funcionario(Cargo cargo, Pessoa pessoa, Set<Usuario> usuarios) {
       this.cargo = cargo;
       this.pessoa = pessoa;
       this.usuarios = usuarios;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


