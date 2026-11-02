package com.pedro.helpdesk.classes;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import com.pedro.helpdesk.enums.Perfil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa(){
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, Set<Integer> perfis, String senha, String nome, String cpf, String email) {
        super();
        this.id = id;
        this.perfis = perfis;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        addPerfil(Perfil.CLIENTE);
    }



    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }


    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public void setPerfis(Set<Integer> perfis) {
        this.perfis = perfis;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf,id);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(cpf,other.cpf) && Objects.equals(id, other.id);
    }
}
