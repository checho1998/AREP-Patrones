package edu.escuelaing.arep.springAWS.repositorio;

import java.util.*;
import java.sql.SQLException;

import edu.escuelaing.arep.springAWS.modelo.Entity;

/**
 * 
 * @author checho
 *
 */
public interface IDBRepositoy {
	public List<Entity> query() throws SQLException ; 
}
