package controllers;

import apresentacao.Console;
import entidade.Imposto;

public class impostoController {
	
	/**
	 * Metodo criado para selecionar qual imposto deve ser aplicado na nota fiscal
	 * emitida.
	 * 
	 * @param valor  variavel passada para calculo do imposto.
	 * @param estado variavel para seleção da criação do imposto.
	 * @return retorna o o objeto imposto para a emissão de uma nota fiscal.
	 */
	public static Imposto estadoDoImposto(Double valor, String estado) {
		String opcao = estado;
		Imposto imposto = null;
		boolean repitir = true;

		do {

			switch (opcao) {

			case "Paraná":
				imposto = new entidade.ImpostoParana(valor);
				repitir = false;
				break;

			case "São Paulo":
				imposto = new entidade.ImpostoSaoPaulo(valor);
				repitir = false;
				break;

			case "Santa Catarina":
				imposto = new entidade.ImpostoSantaCatarina(valor);
				repitir = false;
				break;

			default:
				System.out.println("\nSelecione uma Opção Valida...\n");
				break;
			}
		} while (repitir == true);
		return imposto;
	}

	/**
	 * Metodo criado para selecionar um estado onde a nota fiscal vai ser emitida..
	 * 
	 * @return retorna um estado.
	 */
	public static String consultarEstado() {
		String[] opcao = { "Paraná", "São Paulo", "Santa Catarina" };

		String estado = null;
		boolean repitir = true;

		do {
			int menu = Console.mostrarMenuMeu(opcao, "Informe o estado:", null);
			switch (menu) {

			case 1:
				estado = "Paraná";
				repitir = false;
				break;

			case 2:
				estado = "São Paulo";
				repitir = false;
				break;

			case 3:
				estado = "Santa Catarina";
				repitir = false;
				break;

			default:
				System.out.println("\nSelecione uma Opção Valida...\n");
				break;
			}
		} while (repitir == true);
		return estado;

	}
}
