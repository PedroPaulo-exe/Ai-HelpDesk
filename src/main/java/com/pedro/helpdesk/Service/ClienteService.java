package com.pedro.helpdesk.Service;

import com.pedro.helpdesk.classes.Cliente;
import com.pedro.helpdesk.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return  cliente.orElse(null);
    }
}
