package com.pedro.helpdesk.Service;

import com.pedro.helpdesk.classes.Chamado;
import com.pedro.helpdesk.classes.Cliente;
import com.pedro.helpdesk.classes.Tecnico;
import com.pedro.helpdesk.enums.Perfil;
import com.pedro.helpdesk.enums.Prioridade;
import com.pedro.helpdesk.enums.Status;
import com.pedro.helpdesk.repository.ChamadoRepository;
import com.pedro.helpdesk.repository.ClienteRepository;
import com.pedro.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;


    public void instanciaDB(){
        Tecnico tecnico = new Tecnico(null, "Pedro","1231123123","slamail.com","123");
        tecnico.addPerfil(Perfil.ADMIN);

        Cliente cliente = new Cliente(null, "Julia","32131231223","cliente@email.com","ily");
        cliente.addPerfil(Perfil.CLIENTE);

        Chamado chamado = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tecnico, cliente);

        tecnicoRepository.saveAll(Arrays.asList(tecnico));
        clienteRepository.saveAll(Arrays.asList(cliente));
        chamadoRepository.saveAll(Arrays.asList(chamado));


    }
}
