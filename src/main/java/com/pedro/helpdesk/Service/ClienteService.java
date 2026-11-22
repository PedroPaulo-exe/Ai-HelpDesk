package com.pedro.helpdesk.Service;

import com.pedro.helpdesk.classes.Cliente;
import com.pedro.helpdesk.classes.Pessoa;
import com.pedro.helpdesk.dtos.ClienteDTO;
import com.pedro.helpdesk.exception.DataIntegrityViolationException;
import com.pedro.helpdesk.exception.ObjectNotFoundException;
import com.pedro.helpdesk.repository.ClienteRepository;
import com.pedro.helpdesk.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Registro de id não encontrado: " + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(ClienteDTO clienteDTO) {
        clienteDTO.setId(null);
        isCpfEmailExiste(clienteDTO);
        Cliente novoCliente = new Cliente(clienteDTO);
        return clienteRepository.save(novoCliente);
    }

    public Cliente atualizarCliente(Integer id, @Valid ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente clienteLocalizado = buscarPorId(id);
        isCpfEmailExiste(clienteDTO);
        clienteLocalizado = new Cliente(clienteDTO);
        return clienteRepository.save(clienteLocalizado);
    }

    private void isCpfEmailExiste(ClienteDTO clienteDTO) {
        Optional<Pessoa> registroCadastrado = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if (registroCadastrado.isPresent() && !registroCadastrado.get().getId().equals(clienteDTO.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        registroCadastrado = pessoaRepository.findByEmail(clienteDTO.getEmail());
        if (registroCadastrado.isPresent() && !registroCadastrado.get().getId().equals(clienteDTO.getId())) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }

    public void deletarCliente(Integer id) {
        Cliente clienteLocalizado = buscarPorId(id);
        if (clienteLocalizado.getChamado().size() > 0) {
            throw new DataIntegrityViolationException("Cliente possui chamados relacionados, não podendo ser excluido");
        }
        clienteRepository.deleteById(id);
    }
}