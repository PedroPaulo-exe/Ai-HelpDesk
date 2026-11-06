package com.pedro.helpdesk.repository;

import com.pedro.helpdesk.classes.Pessoa;
import com.pedro.helpdesk.classes.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {



}
