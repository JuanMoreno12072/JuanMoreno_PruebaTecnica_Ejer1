package com.mycompany.nttdata.controller;

import com.mycompany.nttdata.entity.ClienteEntity;
import com.mycompany.nttdata.services.ClienteInterface;
import com.mycompany.nttdata.servicesImplementation.ClienteImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    ClienteInterface cliententerface;

    @GetMapping("ConsultaCliente")
    public ResponseEntity<?> getCliente(@RequestParam(name = "tipoDocumento", required = true) String tipoDocumento, @RequestParam(name = "numeroDocumento", required = true) String numeroDocumento) {
        return cliententerface.ConsultaCliente(tipoDocumento, numeroDocumento);
    }
}
