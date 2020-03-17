package edu.escuelaing.arep.springAWS.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.springAWS.servicios.ITestServices;

/**
 * 
 * @author checho
 *
 */
@RestController
public class control {
	@Autowired
	ITestServices testService;
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(){
	    try {
	        return new ResponseEntity<>(testService.list(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Archivo no encontrado",HttpStatus.NOT_FOUND);
	    }
    }
}
