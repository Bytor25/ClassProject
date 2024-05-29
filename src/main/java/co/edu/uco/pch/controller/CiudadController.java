package co.edu.uco.pch.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.pch.business.facade.impl.ciudad.ConsultarCiudadesFacade;
import co.edu.uco.pch.business.facade.impl.ciudad.RegistrarCiudadFacade;
import co.edu.uco.pch.controller.response.CiudadResponse;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;


@RestController
@RequestMapping("/api/v1/ciudades")

public final class CiudadController {
	
	@GetMapping("/dummy")
	
	public CiudadDTO dummy() {
		return CiudadDTO.build();
	}
	
	
	@GetMapping()
	public ResponseEntity<CiudadResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var CiudadResponse = new CiudadResponse();
		
		try {
			
			var ciudadDto = CiudadDTO.build();
			var facade = new ConsultarCiudadesFacade();
		
			var ciudadesRetorno = new ArrayList<CiudadDTO>();
			ciudadesRetorno.add(CiudadDTO.build());
			
			CiudadResponse.setDatos(facade.execute(ciudadDto));
			CiudadResponse.getMensajes().add("Ciudades consultades exitosamente");
			
		}catch (final PCHException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			CiudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		}catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = " Se ha presentado un problema tratando de consultar ";
			CiudadResponse.getMensajes().add(mensajeUsuario);
			excepcion.printStackTrace();
		}
		return new ResponseEntity<>(CiudadResponse, httpStatusCode);
	}
	
	@PostMapping 
	public ResponseEntity<CiudadResponse> crear(@RequestBody CiudadDTO ciudad){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var CiudadResponse = new CiudadResponse();
		
		try {
			
			var facade = new RegistrarCiudadFacade();
			facade.execute(ciudad);
			
			CiudadResponse.getMensajes().add("Ciudades creada exitosamente");
			
		}catch (final PCHException excepcion) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			CiudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
			
		}catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = " Se ha presentado un problema tratando de consultar ";
			CiudadResponse.getMensajes().add(mensajeUsuario);
			excepcion.printStackTrace();
		}
		return new ResponseEntity<CiudadResponse>(CiudadResponse, httpStatusCode);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<CiudadResponse> eliminar(@PathVariable UUID id){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var ciudadResponse = new CiudadResponse();

        try {
        	
            ciudadResponse.getMensajes().add("Ciudades eliminada exitosamente");
        }catch (final PCHException exception){
        	
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
            
        }catch (final Exception exception){
        	
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presntado un problema tratando de eliminar la ciudad";
            ciudadResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<CiudadResponse> modificar(@PathVariable UUID id, @RequestBody CiudadDTO ciudadDTO){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var ciudadResponse = new CiudadResponse();

        try {
            ciudadDTO.setId(id);
            //var facade = new ModificarCiudadFacade();

            //facade.execute(id);
            ciudadResponse.getMensajes().add("Ciudades modificada exitosamente");
        }catch (final PCHException exception){
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        }catch (final Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presntado un problema tratando de modificar la ciudad";
            ciudadResponse.getMensajes().add(mensajeUsuario);

            exception.printStackTrace();

        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }
	
	}


