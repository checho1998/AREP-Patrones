package edu.escuelaing.arep.configuracion;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/**
 * 
 * @author checho
 *
 */

@Component
public class RepositoryDB {
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	
	@Bean
	public DataSource dataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			config.setUsername(dbUsername);
			config.setPassword(dbPassword);
			config.setMaximumPoolSize(2);
			return new HikariDataSource(config);
		}
	}
}
