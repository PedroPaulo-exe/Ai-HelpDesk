package com.pedro.helpdesk.Service;

import com.pedro.helpdesk.classes.Tecnico;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import com.pedro.helpdesk.exception.ObjectNotFoundException;
import com.pedro.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico buscarPorId(Integer id) {

        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Registro de id não encontrado" + id));


    }

    public List<Tecnico> findAll(){
        return tecnicoRepository.findAll();
    }

    public Tecnico salvarTecnico(TecnicoDTO tecnicoDTO){
        tecnicoDTO.setId(null);
        Tecnico novoTecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(novoTecnico);

    }
}
