package com.pedro.helpdesk.resources;

import com.pedro.helpdesk.Service.TecnicoService;
import com.pedro.helpdesk.classes.Tecnico;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
