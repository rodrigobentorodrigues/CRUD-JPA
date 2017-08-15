
package com.ifpb.ads.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "minhaSeq", allocationSize = 1)
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "minhaSeq")
    private int id;
    @Column(name = "nome", length = 30)
    private String nome;
    @Column(name = "sobrenome", length = 30)
    private String sobrenome;
    @Column(name = "idade")
    private int idade;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    public enum Sexo {
        MASCULINO,
        FEMININO;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, int idade, Sexo sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    } 

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", sexo=" + sexo + '}';
    }
    
}
