package apresentacao;

import java.util.ArrayList;
import java.util.Collections;

import controllers.empresaController;
import entidade.ComparadorPorNome;
import entidade.Empresa;

public class listarEmpresas {
	
	/**
	 * Metodo criado para criar um menu de Opções para listar as empresas
	 * cadastradas.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception Exception para quando não existe empresas cadastradas ou
	 *                   quando o cnpj informado foi incorreto
	 */
	public static void renderizar(ArrayList<Empresa> empresas) throws Exception {
		String[] opcao = { "Listar todas as empresas (A ~ Z)", "Consultar empresa por CNPJ:" };

		boolean repitir = true;

		do {
			int menu = Console.mostrarMenu(opcao, "\nOpções", null);
			switch (menu) {

			case 1:
				consultarTodasAsEmpresas(empresas);
				break;

			case 2:
				try {
					consultarEmpresaPorCnpj(empresas);
				} catch (Exception retorno) {
					System.out.println(retorno.getMessage());
				}
				break;

			case -1:
				System.out.println("Retornando ao menu anterior...");
				repitir = false;
				break;
			}
		} while (repitir == true);

	}

	/**
	 * Metodo criado para consultar uma empresa com o devido CNPJ informado.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto
	 */
	public static void consultarEmpresaPorCnpj(ArrayList<Empresa> empresas) throws Exception {
		if (empresas.isEmpty()) {
			System.out.println("Não existe Empresas Cadastradas");
		} else {
			Empresa empresa = empresaController.retornarEmpresa(empresas);

			System.out.println(empresa);

		}

	}

	/**
	 * Metodo criado para listar todas as empresas cadastradas classificando por
	 * orddem alfabetica.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception para quando não existe empresas cadastradas.
	 */
	public static void consultarTodasAsEmpresas(ArrayList<Empresa> empresas) throws Exception {
		ArrayList<Empresa> listaOrdenada = empresas;

		if (listaOrdenada.isEmpty()) {
			System.out.println("\nNão existe Empresas Cadastradas");
		} else {

			Collections.sort(listaOrdenada, new ComparadorPorNome());

			for (Empresa empresa : listaOrdenada) {

				System.out.println(empresa);
			}
		}

	}
}
