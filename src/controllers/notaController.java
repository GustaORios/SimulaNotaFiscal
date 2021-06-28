package controllers;

import java.util.ArrayList;

import apresentacao.cadastrarProduto;
import apresentacao.Console;
import entidade.Empresa;
import entidade.Imposto;
import entidade.NotaFiscal;
import entidade.Produto;


public class notaController {

	static ArrayList<Produto> produtos = new ArrayList<Produto>(); 
	
	/**
	 * Metodo criado para emitir uma nota fiscal para um CNPJ informado.
	 * 
	 * @param empresas   vetor de todas as empresas.
	 * @param notaFiscal variavel objeto para criar uma nota fiscal a ser atribuida
	 *                   a uma empresa expecifica.
	 * @return ultimo numero da nota fiscal emitida para ser utilizado quando for
	 *         criado a procima nota fiscal, deixando a numeração da note fiscal
	 *         automatica.
	 * @throws Exception para quando não existe empresas cadastradas ou quando o
	 *                   cnpj informado foi incorreto
	 */
	public static Integer emitirNota(ArrayList<Empresa> empresas, Integer notaFiscal) throws Exception {
		Integer numero = null;
		if (empresas.isEmpty()) {
			System.out.println("Nao existe empresas cadastradas.");
		} else {
			
			Empresa empresa = empresaController.retornarEmpresa(empresas);
			System.out.println(empresa);
			numero = notaFiscal + 1;
			produtos = cadastrarProduto.renderizar();
			Double valor = notaController.calcularValorFinal(produtos);
			String estado = impostoController.consultarEstado();
			Imposto imposto = impostoController.estadoDoImposto(valor, estado);
			NotaFiscal nota = new NotaFiscal(numero, produtos, valor, estado, imposto);
			empresa.addNotaFiscal(nota);
			System.out.println(nota);

		}
		return numero;

	}
	

	/**
	 * metodo criado para excluir uma nota de uma empresa solicitada via CNPJ.
	 * 
	 * @param empresas vetor de todas as empresas.
	 * @throws Exception para quando não existe empresas cadastradas, quando o cnpj
	 *                   informado foi incorreto ou numero da nota incorreto.
	 */

	public static void cancelarNota(ArrayList<Empresa> empresas) throws Exception {
		if (empresas.isEmpty()) {
			throw new Exception("Nao existe empresas cadastradas.");
		} else {
			Empresa empresa = empresaController.retornarEmpresa(empresas);
			ArrayList<NotaFiscal> notas = empresa.getNotasFiscaisValidas();
			if (!notas.isEmpty()) {
				for (NotaFiscal notaFiscal : notas) {
					System.out.println(notaFiscal);
				}

				Integer numeroNota = Console
						.recuperaInteiro("\nInforme o Numero da Nota desejada para realização do cancelamento: ");
				Boolean ok = empresa.cancelamentoDeNota(numeroNota);
				if (ok) {
					System.out.println("\nNota Cancelada!\n");
				} else {
					System.out.println("\nNumero informado não é de uma nota fiscal valida!");
				}
			} else {
				throw new Exception("Nao existe notas validas para cancelamento.");
			}
		}

	}

	/**
	 * metodo criado para calcular o valor total dos produtos
	 * 
	 * @param produtos vetor de todos os produtos na nota equivalente.
	 */
	
	 public static Double calcularValorFinal(ArrayList<Produto> produtos) {
		 Double valor = 0.0;
		 for (Produto produtoCadastrado : produtos) {
			 if(produtoCadastrado.getValorFinal() > 0) {
				 valor = produtoCadastrado.getValorFinal() + valor;
			 }
		 }
		return valor;
	 
	 }
	
}
