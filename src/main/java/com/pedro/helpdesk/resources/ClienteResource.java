package com.pedro.helpdesk.resources;

import com.pedro.helpdesk.Service.ClienteService;
import com.pedro.helpdesk.classes.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")

public class ClienteResource {
    //localhost:8080/cliente/1

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarporId(@PathVariable Integer id){
        Cliente cliente = clienteService.buscarPorId(id);

        return ResponseEntity.ok().body(cliente);

    }

}
