package controllers;

import java.util.ArrayList;

import apresentacao.Console;
import entidade.Empresa;
import entidade.NotaFiscal;

public class empresaController {
	
	/**
	 * Matodo para excluir uma empresa, desde que ela não tenha uma nota fiscal
	 * valida
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @return retorna o vetor com as impresas que não foram excluidas.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto.
	 */
	public static ArrayList<Empresa> excluirEmpresa(ArrayList<Empresa> empresas) throws Exception {

		if (empresas.isEmpty()) {
			throw new Exception("Nao existe empresas cadastradas.");
		} else {
			Empresa empresa = retornarEmpresa(empresas);
			ArrayList<NotaFiscal> notasValidas = empresa.getNotasFiscaisValidas();

			if (notasValidas.isEmpty()) {
				System.out.println(empresa);
				empresas.remove(empresa);
				System.out.println("\nEmpresa Excluida! ");

			} else {
				throw new Exception("Não foi possivel excluir pois existem notas validas no sistema ");

			}

		}
		return empresas;
	}
	
	

	/**
	 * Metodo criado para efetuar o cadastro das empresas..
	 * 
	 * @param empresas Vetor de todas as empresas cadastradas.
	 * @return retorna um vetor Objeto de Empresas cadastradas.
	 * @throws Exception para quando o CNPJ ja é existente.
	 */
	public static Empresa cadastrarEmpresa(ArrayList<Empresa> empresas) throws Exception {

		String nome = Console.recuperaTexto("Infome o Nome da Empresa");
		String cnpj = Console.recuperaTexto("Informe CNPJ");

		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equals(cnpj)) {
				throw new Exception("CNPJ já Está Cadastrado!");
			}
		}
		Empresa retorno = new Empresa(nome, cnpj);

		return retorno;

	}

	/**
	 * Metodo criado para buscar uma empresa por cnpj informado.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @return retorna uma empresa.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto
	 */
	public static Empresa retornarEmpresa(ArrayList<Empresa> empresas) throws Exception {
		String cnpj = Console.recuperaTexto("Informe o CNPJ que deseja buscar.");
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equals(cnpj)) {

				return empresa;
			}
		}
		throw new Exception("CNPJ informado não é Valido");
	}

}
