package edu.escuelaing.arep.repositorio;

import java.util.*;
import java.sql.SQLException;

import edu.escuelaing.arep.modelo.Entity;

/**
 * 
 * @author checho
 *
 */
public interface IDBRepositoy {
	public List<Entity> query() throws SQLException ; 
}
