package com.pedro.helpdesk.classes;

import com.pedro.helpdesk.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Tecnico extends Pessoa{

    private static final long serialVersionUID = 1L;

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

    public Tecnico(Integer id, Set<Integer> perfis, String senha, String nome, String cpf, String email) {
        super(id, perfis, senha, nome, senha, email);
        addPerfil(Perfil.TECNICO);
    }
}
