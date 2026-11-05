package com.pedro.helpdesk.repository;

import com.pedro.helpdesk.classes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
