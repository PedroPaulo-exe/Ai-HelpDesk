package com.pedro.helpdesk.classes;

import com.pedro.helpdesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Pessoa{

     private static final long serialVersionUID = 1L;

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

    public Cliente(Integer id, Set<Integer> perfis, String senha, String nome, String cpf, String email) {
        super(id,perfis, senha, nome, cpf, email);
        addPerfil(Perfil.CLIENTE);
    }
}
