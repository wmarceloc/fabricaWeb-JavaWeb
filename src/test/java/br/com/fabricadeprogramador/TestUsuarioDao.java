package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDao;

public class TestUsuarioDao {

	public static void main(String[] args) {
		
		//Cria o usu�rio que ir� persistir no banco de dados
		UsuarioDao usuDao = new UsuarioDao();
				
		//Cadastrando o usu�rio no banco
		//testCadastrar();
		
		//Alterando o usu�rio no banco
		//testAlterar();
		
		//Excluindo o usu�rio no banco
		testExcluir();
	
	}//fim de main
	
	public static void testCadastrar(){
		//Cria o usu�rio que ir� persistir no banco de dados
				Usuario usu = new Usuario();
				usu.setId(4);
				usu.setNome("J�oz�o");
				usu.setLogin("jzao");
				usu.setSenha("123");
				
				//Cadastrando o usu�rio no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.alterar(usu);
				System.out.println("Cadastrado com sucesso!");
	}//fim do m�todo testCadastrar
	
	public static void testAlterar(){
		//Cria o usu�rio
				Usuario usu = new Usuario();
				usu.setId(4);
				usu.setNome("J�oz�o da Silva");
				usu.setLogin("jzaoss");
				usu.setSenha("12354561");
				
				//Cadastrando o usu�rio no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.cadastrar(usu);
				System.out.println("Alterado com sucesso!");
	}//fim do m�todo testAlterar
	
	public static void testExcluir(){
		
		//Cria o usu�rio
				Usuario usu = new Usuario();
				usu.setId(4);
				//Cadastrando o usu�rio no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.excluir(usu);
				System.out.println("Excluido com sucesso!");
	}//fim do m�todo testExcluir
}//fim da classe TestUsuarioDao
