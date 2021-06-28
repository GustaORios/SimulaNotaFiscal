package apresentacao;

import java.util.ArrayList;
import controllers.empresaController;
import controllers.notaController;
import entidade.Empresa;

public class Principal {

	public static void main(String[] args) throws Exception {

		Integer notaFiscal = 0;
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();

		String[] opcao = { "Cadastrar Empresa", "Consultar empresas", "Excluir Empresas", "Emitir Nota",
				"Cancelar Nota", "Relatorio de Notas.", "Cadastrar produto" };

		boolean repitir = true;

		do {
			int menu = Console.mostrarMenu(opcao, "\nOpções", null);

			switch (menu) {

			case 1:
				try {
					Empresa empresa = empresaController.cadastrarEmpresa(empresas);
					empresas.add(empresa);
					System.out.println("\nEmpresa Cadastrada. ");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				try {
					listarEmpresas.renderizar(empresas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					empresas = empresaController.excluirEmpresa(empresas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					notaFiscal = notaController.emitirNota(empresas, notaFiscal);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 5:
				try {
					notaController.cancelarNota(empresas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:

				listarNotas.renderizar(empresas);
				break;
				
			case 7:
				cadastrarProduto.renderizar();
				break;

			case -1:
				System.out.println("Finalizando o Sistema...");
				repitir = false;
				break;
			}
		} while (repitir == true);
	}

}
