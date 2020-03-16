package edu.escuelaing.arep.servicios;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import edu.escuelaing.arep.modelo.Entity;
/**
 * 
 * @author checho
 *
 */
@Service
public interface  ITestServices {
	public List<Entity> list() throws SQLException;
}
