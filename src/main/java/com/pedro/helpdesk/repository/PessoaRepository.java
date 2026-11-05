package com.pedro.helpdesk.repository;

import com.pedro.helpdesk.classes.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
