package com.pedro.helpdesk.classes;

import com.pedro.helpdesk.enums.Perfil;

import java.util.Set;

public class Cliente extends Pessoa{

    public Cliente(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, Set<Integer> perfis, String senha, String nome, String cpf, String email) {
        super(id,perfis, senha, nome, cpf, email);
        addPerfil(Perfil.CLIENTE);
    }
}
