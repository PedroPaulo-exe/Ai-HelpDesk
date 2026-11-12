package com.pedro.helpdesk.Service;

import com.pedro.helpdesk.classes.Pessoa;
import com.pedro.helpdesk.classes.Tecnico;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import com.pedro.helpdesk.exception.DataIntegrityViolationException;
import com.pedro.helpdesk.exception.ObjectNotFoundException;
import com.pedro.helpdesk.repository.PessoaRepository;
import com.pedro.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico buscarPorId(Integer id) {

        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Registro de id não encontrado" + id));
    }
    public List<Tecnico> findAll(){
        return tecnicoRepository.findAll();
    }

    public Tecnico salvarTecnico(TecnicoDTO tecnicoDTO){
        tecnicoDTO.setId(null);
        isCpfEmailExiste(tecnicoDTO);
        Tecnico novoTecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(novoTecnico);

    }
    private void isCpfEmailExiste (TecnicoDTO tecnicoDTO){
        Optional<Pessoa> registroCadastrado = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(registroCadastrado.isPresent() && registroCadastrado.get().getId() != tecnicoDTO.getId() ){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        registroCadastrado = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(registroCadastrado.isPresent() && registroCadastrado.get().getId() != tecnicoDTO.getId() ){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
