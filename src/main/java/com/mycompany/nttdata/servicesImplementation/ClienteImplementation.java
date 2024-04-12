package com.mycompany.nttdata.servicesImplementation;

import com.mycompany.nttdata.entity.ClienteEntity;
import com.mycompany.nttdata.entity.ErrorEntity;
import com.mycompany.nttdata.services.ClienteInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteImplementation implements ClienteInterface{

    @Override
    public ResponseEntity<?> ConsultaCliente(String tipoDocumento, String numeroDocumento) {
        //Se valida el tipo de documento de la peticion
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            //Como el tipo de documento es incorrecto se retorna mensaje con codigo estado respuesta 400
            ErrorEntity error = new ErrorEntity(HttpStatus.BAD_REQUEST.toString(),"Tipo de documento no valido para la consulta.");            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } else {
            //Se valida que el numero y tipo de documento sea el mockeado para las respectivas pruebas
            if (numeroDocumento.equals("23445322") && tipoDocumento.equals("C")) {
                try {
                    //Se setean los campos de la entidad cliente, 
                    //Se puede hacer con ayuda del getter y setter de cada campo o con ayuda del constructor generado para la entidad
                    ClienteEntity cliente = new ClienteEntity();
                    cliente.setPrimerNombre("Juan");
                    cliente.setSegundoNombre("Bautista");
                    cliente.setPrimerApellido("Moreno");
                    cliente.setSegundoApellido("Ballesteros");
                    cliente.setTelefono("3228455384");
                    cliente.setDireccion("Carrera 7c #181a-50");
                    cliente.setCiudadResidencia("Bogotá D.C");
                    
                    //Como el proceso fue correcto se retorna la entidad con codigo estado respuesta 200
                    return ResponseEntity.status(HttpStatus.OK).body(cliente);

                } catch (Exception exception) {
                    //Como el proceso genero una excepcion se retorna mensaje con codigo estado respuesta 500
                    ErrorEntity error = new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Error interno :" + exception.getMessage());            
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
                }

            } else {
                //Como el recurso no se encuentra se retorna mensaje con codigo estado respuesta 404
                ErrorEntity error = new ErrorEntity(HttpStatus.NOT_FOUND.toString(),"No se encuentra información para el cliente solicitado.");            
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
        }
    }
    
}
