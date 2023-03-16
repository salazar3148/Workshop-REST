package com.christian.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessadorController {

    ProcessadorService processadorService;

    @Autowired
    public ProcessadorController(ProcessadorService processadorService) {
        this.processadorService = processadorService;
    }

    @PostMapping("/")
    public Documento validarDocumento(@RequestBody String ruta) {
        return processadorService.validarLineas(ruta);
    }

}
