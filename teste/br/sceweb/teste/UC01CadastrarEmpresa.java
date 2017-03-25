package br.sceweb.teste;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void CT01UC01FBCadastraSucesso(){
		assertEquals(1, empresaDAO.adiciona(empresa));;
	}
	
	@Test
	public void CT01UC01A0CadastraIgual(){
			empresa.setNomeDaEmpresa("empresa x");
			empresa.setCnpj("89424232000180");
			empresa.setNomeFantasia("empresa x");
			empresa.setEndereco("rua taquari");
			empresa.setTelefone("2222");	
			empresa.setNomeDaEmpresa("empresa x");
			empresa.setCnpj("89424232000180");
			empresa.setNomeFantasia("empresa x");
			empresa.setEndereco("rua taquari");
	}
	
	@Test
	public void CT01UC02FBExcluiSucesso(){
		assertEquals(1, empresaDAO.exclui(empresa.getCnpj()));;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CT01UC01A1CadastraErrado(){
		empresa.setCnpj("");
		empresa.setNomeDaEmpresa("");
		empresa.setNomeFantasia("");
		empresa.setEndereco("");
		empresa.setTelefone("");		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void CT01UC01A2CadastraErradoCNPJ(){
		empresa.setNomeDaEmpresa("empresa y");
		empresa.setCnpj("");
		empresa.setNomeFantasia("empresa y");
		empresa.setEndereco("rua taquary");
		empresa.setTelefone("3333");		
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void CT01UC01A3CadastraErradoNome(){
		empresa.setNomeDaEmpresa("");
		empresa.setCnpj("89424232000179");
		empresa.setNomeFantasia("empresa w");
		empresa.setEndereco("rua taquary");
		empresa.setTelefone("3333");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CT01UC01A4CadastraErradoFantasia(){
		empresa.setNomeDaEmpresa("empresa z");
		empresa.setCnpj("89424232000181");
		empresa.setNomeFantasia("");
		empresa.setEndereco("rua taquazy");
		empresa.setTelefone("4444");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CT01UC01A5CadastraErradoEnd(){
		empresa.setNomeDaEmpresa("empresa a");
		empresa.setCnpj("89424232000182");
		empresa.setNomeFantasia("empresa a");
		empresa.setEndereco("");
		empresa.setTelefone("5555");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CT01UC01A6CadastraErradoTel(){
		empresa.setNomeDaEmpresa("empresa b");
		empresa.setCnpj("89424232000183");
		empresa.setNomeFantasia("empresa b");
		empresa.setEndereco("rua taquaz");
		empresa.setTelefone("");		
	}
	
	@Test
	public void CT01UC02A1ExcluiErrado(){
		empresaDAO.exclui(null);
	}
	
	@After
	public void excluiEmpresa() throws Exception{
		empresaDAO.exclui("89424232000179");
		empresaDAO.exclui("89424232000180");
		empresaDAO.exclui("89424232000181");
		empresaDAO.exclui("89424232000182");
		empresaDAO.exclui("89424232000183");
	}
	
	
}