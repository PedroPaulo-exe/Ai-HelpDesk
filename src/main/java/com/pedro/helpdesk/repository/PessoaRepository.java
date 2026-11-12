package com.pedro.helpdesk.repository;

import com.pedro.helpdesk.classes.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByCpf(String cpfCnpj);
    Optional<Pessoa> findByEmail (String email);
}
