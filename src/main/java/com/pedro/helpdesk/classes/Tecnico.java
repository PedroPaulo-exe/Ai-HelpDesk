package com.pedro.helpdesk.classes;

import com.pedro.helpdesk.enums.Perfil;

import java.util.Set;

public class Tecnico extends Pessoa{

    private static final long serialVersionUID = 1L;

    public Tecnico(){
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Integer id, Set<Integer> perfis, String senha, String nome, String cpf, String email) {
        super(id, perfis, senha, nome, senha, email);
        addPerfil(Perfil.TECNICO);
    }
}
