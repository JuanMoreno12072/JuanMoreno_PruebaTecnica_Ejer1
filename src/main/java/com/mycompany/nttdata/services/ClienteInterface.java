package com.mycompany.nttdata.services;

import com.mycompany.nttdata.entity.ClienteEntity;
import org.springframework.http.ResponseEntity;


public interface ClienteInterface {
    
    public ResponseEntity<?> ConsultaCliente(String tipoDocumento, String numeroDocumento);
    
}
