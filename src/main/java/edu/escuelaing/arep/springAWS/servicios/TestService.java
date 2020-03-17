package edu.escuelaing.arep.springAWS.servicios;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.escuelaing.arep.springAWS.modelo.Entity;
import edu.escuelaing.arep.springAWS.repositorio.IDBRepositoy;
/**
 * 
 * @author chech
 *
 */
@Component
public class TestService implements ITestServices {
	
	@Autowired
	private IDBRepositoy dataBaseRepository;

	@Override
	public List<Entity> list() throws SQLException {
		return dataBaseRepository.query();
	}

}
