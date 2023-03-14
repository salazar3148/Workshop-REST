package com.christian.workshop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessadorController {

    @PostMapping("/")
    public Documento validarDocumento(@RequestBody String ruta) {
        ProcessadorService ps = new ProcessadorService();
        return ps.validarLineas(ruta);
    }
}
