package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDao {
	
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		//as interrogações no final são parâmetros de banco de dados (1, 2, 3)
		String sql = "insert into usuario (nome, login, senha) values(?, ?, ?)";
		
		//cria o Statement
		//PreparedStatement implementa a interface Autoclosable. Por isso, é possível uma 
		//sintaxe diferente da declaração try, usando parâmetros, e o próprio try encerra o recurso
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());//substitui o ponto de interrogação
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			//executa o comando SQL no bando
			preparador.execute();
			
			//libera o recurso (desnecessário em razão do try acima)
			//preparador.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//fim do try/catch
	}//fim do método cadastrar

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=?, where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//fim do try/catch
	}//fim do método alterar

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//fim do try/catch
	}//fim do método excluir
}//fim da classe UsuarioDao
