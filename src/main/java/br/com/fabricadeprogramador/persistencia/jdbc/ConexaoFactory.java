package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb", "postgres", "post");
		} catch (SQLException e) {
			//relançando a exception
			System.out.println("Não conseguiu conectar com o banco de dados" + e);
			throw new RuntimeException(e);
		}//fim do try/catch
	}//fim do método getConnection
}//fim da classe ConexaoFactory
