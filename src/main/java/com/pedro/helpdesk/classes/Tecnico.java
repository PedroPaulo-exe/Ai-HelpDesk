package com.pedro.helpdesk.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import com.pedro.helpdesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamado = new ArrayList<>();

    public List<Chamado> getChamado() {
        return chamado;
    }

    public void setChamado(List<Chamado> chamado) {
        this.chamado = chamado;
    }

    public Tecnico(){
        super();
        addPerfil(Perfil.TECNICO);
    }
    public Tecnico(TecnicoDTO obj){
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();

    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }


}
