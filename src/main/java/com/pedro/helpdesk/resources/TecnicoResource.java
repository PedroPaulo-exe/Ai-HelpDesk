package com.pedro.helpdesk.resources;

import com.pedro.helpdesk.Service.TecnicoService;
import com.pedro.helpdesk.classes.Tecnico;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    //localhost:8080/tecnicos/1

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> buscarPorId(@PathVariable Integer id){
        Tecnico tecnico = tecnicoService.buscarPorId(id);

        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }
    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> tecnicos = tecnicoService.findAll();
        List<TecnicoDTO> tecnicosDTO = tecnicos.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(tecnicosDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> salvarTecnico(@RequestBody TecnicoDTO tecnicoDTO){
        Tecnico novoTecnico = tecnicoService.salvarTecnico(tecnicoDTO);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoTecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
