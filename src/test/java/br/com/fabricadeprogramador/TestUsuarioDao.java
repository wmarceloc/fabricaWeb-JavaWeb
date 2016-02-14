package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDao;

public class TestUsuarioDao {

	public static void main(String[] args) {
		
		//Cria o usuário que irá persistir no banco de dados
		UsuarioDao usuDao = new UsuarioDao();
				
		//Cadastrando o usuário no banco
		//testCadastrar();
		
		//Alterando o usuário no banco
		//testAlterar();
		
		//Excluindo o usuário no banco
		testExcluir();
	
	}//fim de main
	
	public static void testCadastrar(){
		//Cria o usuário que irá persistir no banco de dados
				Usuario usu = new Usuario();
				usu.setId(4);
				usu.setNome("Jãozão");
				usu.setLogin("jzao");
				usu.setSenha("123");
				
				//Cadastrando o usuário no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.alterar(usu);
				System.out.println("Cadastrado com sucesso!");
	}//fim do método testCadastrar
	
	public static void testAlterar(){
		//Cria o usuário
				Usuario usu = new Usuario();
				usu.setId(4);
				usu.setNome("Jãozão da Silva");
				usu.setLogin("jzaoss");
				usu.setSenha("12354561");
				
				//Cadastrando o usuário no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.cadastrar(usu);
				System.out.println("Alterado com sucesso!");
	}//fim do método testAlterar
	
	public static void testExcluir(){
		
		//Cria o usuário
				Usuario usu = new Usuario();
				usu.setId(4);
				//Cadastrando o usuário no banco
				UsuarioDao usuDao = new UsuarioDao();
				usuDao.excluir(usu);
				System.out.println("Excluido com sucesso!");
	}//fim do método testExcluir
}//fim da classe TestUsuarioDao
