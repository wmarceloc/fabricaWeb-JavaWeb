package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDao {
	
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		//as interroga��es no final s�o par�metros de banco de dados (1, 2, 3)
		String sql = "insert into usuario (nome, login, senha) values(?, ?, ?)";
		
		//cria o Statement
		//PreparedStatement implementa a interface Autoclosable. Por isso, � poss�vel uma 
		//sintaxe diferente da declara��o try, usando par�metros, e o pr�prio try encerra o recurso
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());//substitui o ponto de interroga��o
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			//executa o comando SQL no bando
			preparador.execute();
			
			//libera o recurso (desnecess�rio em raz�o do try acima)
			//preparador.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//fim do try/catch
	}//fim do m�todo cadastrar

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
	}//fim do m�todo alterar

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//fim do try/catch
	}//fim do m�todo excluir
}//fim da classe UsuarioDao
