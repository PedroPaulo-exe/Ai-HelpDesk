package com.pedro.helpdesk.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.helpdesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Pessoa{

     private static final long serialVersionUID = 1L;
     @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> Chamado = new ArrayList<>();

    public List<Chamado> getChamado() {
        return Chamado;
    }

    public void setChamado(List<Chamado> chamado) {
        Chamado = chamado;
    }


    public Cliente(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }
}
