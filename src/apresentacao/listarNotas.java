package apresentacao;

import java.util.ArrayList;
import java.util.Collections;

import controllers.empresaController;
import entidade.ComparadorPorValor;
import entidade.Empresa;
import entidade.NotaFiscal;

public class listarNotas {
	
	/**
	 * Metodo para mostrar os menus de listar as notas.
	 * 
	 * @param empresas
	 */
	public static void renderizar(ArrayList<Empresa> empresas) {

		String[] opcao = { "Notas fiscais validas por empresa", "Notas fiscais canceladas por empresas",
				"Todas as notas ordenadas por valor" };

		boolean repitir = true;

		do {
			int menu = Console.mostrarMenu(opcao, "Opções", null);

			switch (menu) {

			case 1:

				try {
					notasValidas(empresas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:

				try {
					notasCanceladas(empresas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 3:
				notasOrdenarValor(empresas);

				break;

			case -1:
				System.out.println("Retornando ao menu principal. . .");
				repitir = false;
				break;
			}
		} while (repitir == true);
	}
	
	/**
	 * Metodo para listar as notas canceladas de um CNPJ especifico.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto.
	 */
	private static void notasCanceladas(ArrayList<Empresa> empresas) throws Exception {
		if (empresas.isEmpty()) {
			System.out.println("Nao existe empresas cadastradas.");
		} else {
			Empresa empresa = empresaController.retornarEmpresa(empresas);
			ArrayList<NotaFiscal> notasCanceladas = empresa.getNotasFiscaisCanceladas();
			if (notasCanceladas.isEmpty()) {
				System.out.println("Não existe notas Canceladas! ");
			} else {
				for (NotaFiscal notaFiscal : notasCanceladas) {
					System.out.println(notaFiscal);

				}
			}
		}

	}

	/**
	 * Metodo para listar as notas validas de um CNPJ especifico.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto.
	 */
	public static void notasValidas(ArrayList<Empresa> empresas) throws Exception {
		if (empresas.isEmpty()) {
			System.out.println("Nao existe empresas cadastradas.");
		} else {
			Empresa empresa = empresaController.retornarEmpresa(empresas);
			ArrayList<NotaFiscal> notasValidas = empresa.getNotasFiscaisValidas();
			if (notasValidas.isEmpty()) {
				System.out.println("Não existe notas Validas! ");
			} else {
				
				for (NotaFiscal notaFiscal : notasValidas) {
					System.out.println(notaFiscal);

				}
			}
		}

	}
	

	/**
	 * Metodo para listar ordenando pelo valor com imposto em orddem crescente.
	 * 
	 * @param empresas vetor com todas as empresas.
	 */
	public static void notasOrdenarValor(ArrayList<Empresa> empresas) {
		if (empresas.isEmpty()) {
			System.out.println("Nao existe empresas cadastradas.");
		} else {
			ArrayList<NotaFiscal> todasAsNotas = new ArrayList<>();
			ArrayList<NotaFiscal> notas = new ArrayList<>();
			for (Empresa empresa : empresas) {
				notas = empresa.getNotasFiscais();
				for (NotaFiscal notaFiscal : notas) {
					todasAsNotas.add(notaFiscal);

				}
			}
			if (todasAsNotas.isEmpty()) {
				System.out.println("Não Existe notas cadastradas! ");
			} else {
				Collections.sort(todasAsNotas, new ComparadorPorValor());
				for (NotaFiscal notaFiscal : todasAsNotas) {
					System.out.println(notaFiscal);
				}
			}
		}

	}

}
